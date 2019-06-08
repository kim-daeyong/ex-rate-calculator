package example.daeyong.kim.exratecalculator.service;


import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
public class ExRateCalServiceImpl implements ExRateCalService {
    @Value("${currencyLayer.source}")
    private String source;

    private final ExRateAPIService exRateAPIService;

    @Override
    public Double getExRateCal(String sendingCon, String receivingCon) {
        ExRateAPIDto exRateAPIDto = exRateAPIService.getExchangeRate();
            return exRateAPIDto.getQuotes().get(sendingCon + receivingCon);
    }
    @Override
    public String convertForm(Number number) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            return decimalFormat.format(number);
    }

    @Override
    public Double totalAmount(Double number, Double number2) {
        Double total = number * number2;
        return total;
    }
}
