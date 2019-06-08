package example.daeyong.kim.exratecalculator.service;

import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;

public interface ExRateAPIService {

    ExRateAPIDto getExchangeRate();

    ExRateAPIDto renewAPI();
}
