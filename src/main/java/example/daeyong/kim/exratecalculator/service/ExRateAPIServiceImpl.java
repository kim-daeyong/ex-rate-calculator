package example.daeyong.kim.exratecalculator.service;


import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
@PropertySource( value = "/apikey.properties", ignoreResourceNotFound = true )
public class ExRateAPIServiceImpl implements ExRateAPIService {

    @Value("${currencyLayer.accessKey}")
    private String accessKey;
    @Value("${currencyLayer.endPointUrl}")
    private String endPoint;
    @Value("${currencyLayer.source}")
    private String source;
    @Value("${currencyLayer.currencies}")
    private String currencies;

    private RestTemplate restTemplate;
    private ExRateAPIDto exRateAPIDto;

    public ExRateAPIServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ExRateAPIDto getExchangeRate() {
            exRateAPIDto = restTemplate.getForObject(endPoint + "/live?access_key=" + accessKey
                            + "&source=" + source
                            + "&currencies=" + currencies,
                    ExRateAPIDto.class);

            checkExRateAPIDto();

            return exRateAPIDto;
        }

    private void checkExRateAPIDto() {
        Optional<ExRateAPIDto> check = Optional.ofNullable(exRateAPIDto);
        if (!check.isPresent()) {
            throw new RestClientException("API를 확인해주세요");
        }
        if (!check.get().isSuccess()) {
            throw new RestClientException("API 호출 에러 "
                    + exRateAPIDto.getError().get("code") + "\n"
                    + exRateAPIDto.getError().get("type"));
        }
    }



}
