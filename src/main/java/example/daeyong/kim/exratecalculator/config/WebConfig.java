package example.daeyong.kim.exratecalculator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class WebConfig {

//    private RestTemplate restTemplate;
    //todo WebClient 교체
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) { return builder.build();
    }


}


