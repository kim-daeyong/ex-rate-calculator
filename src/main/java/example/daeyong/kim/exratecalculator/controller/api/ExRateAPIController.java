package example.daeyong.kim.exratecalculator.controller.api;


import example.daeyong.kim.exratecalculator.config.WebConfig;
import example.daeyong.kim.exratecalculator.dto.CurrencyDto;
import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
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

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExRateAPIController {

    @Autowired
    ExRateAPIService exRateAPIService;

    private ExRateAPIDto exRateAPIDto;

//    @GetMapping("/exchangerate")
//    public ResponseEntity getExchangeRate(){
//        exRateAPIDto = exRateAPIService.getExchangeRate();
//        return new ResponseEntity(exRateAPIDto, HttpStatus.OK);
//    }

    @GetMapping("/exchangerate")
    public ResponseEntity getExchangeRate(@ModelAttribute CurrencyDto currencyDto) {
        Double exchangeRate = exRateAPIService.getExchangeRate(currencyDto.getSendingCon(), currencyDto.getReceivingCon());
        return  new ResponseEntity(exRateAPIDto, HttpStatus.OK);

    }
}
