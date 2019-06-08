package example.daeyong.kim.exratecalculator.controller.api;


import example.daeyong.kim.exratecalculator.config.WebConfig;
import example.daeyong.kim.exratecalculator.dto.CurrencyDto;
import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import example.daeyong.kim.exratecalculator.service.ExRateCalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExRateAPIController {

    @Autowired
    ExRateAPIService exRateAPIService;

    @Autowired
    ExRateCalService exRateCalService;

    private ExRateAPIDto exRateAPIDto;

    @GetMapping("/exchangerate")
    public ResponseEntity getExchangeRate(@Valid @ModelAttribute CurrencyDto currencyDto) {
        Double exchangeRate = exRateCalService.getExRateCal(currencyDto.getSendingCon(), currencyDto.getReceivingCon());
        return ResponseEntity.ok(exRateCalService.convertForm(exchangeRate));
    }

    @GetMapping("/receiving-currency")
    public ResponseEntity getReceivingAmount(@Valid @ModelAttribute CurrencyDto currencyDto) {
        Map<String, String> response = new HashMap<>();
        Double exchangeRate = exRateCalService.getExRateCal(currencyDto.getSendingCon(), currencyDto.getReceivingCon());
        Double receivingAmount = exRateCalService.totalAmount(exchangeRate,currencyDto.getAmount());

        response.put("exrate", exRateCalService.convertForm(exchangeRate));
        response.put("receivingAmount", exRateCalService.convertForm(receivingAmount));
        return ResponseEntity.ok(response);
    }

}
