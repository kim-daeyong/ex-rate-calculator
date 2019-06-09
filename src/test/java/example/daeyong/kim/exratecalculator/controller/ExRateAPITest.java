package example.daeyong.kim.exratecalculator.controller;

/*
import com.fasterxml.jackson.databind.ObjectMapper;
import example.daeyong.kim.exratecalculator.controller.api.ExRateAPIController;
import example.daeyong.kim.exratecalculator.dto.CurrencyDto;
import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.Mockito;

import java.nio.charset.Charset;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import example.daeyong.kim.exratecalculator.controller.api.ExRateAPIController;
import example.daeyong.kim.exratecalculator.dto.CurrencyDto;
import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ExRateAPIController.class)
public class ExRateAPITest {


    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ExRateAPIService exRateAPIService;

    @MockBean
    ExRateAPIController exRateAPIController;
    
    @Test
    public void getAPIDataByUSDKRW() throws Exception {

        CurrencyDto currencyDto = CurrencyDto.builder()
                .sendingCon("USD")
                .sendingCon("KRW")
                .build();

//        currencyDto.setSendingCon("USD");
//        currencyDto.setReceivingCon("KRW");
//        currencyDto.setAmount(100.10);
//
//        Mockito.when(exRateAPIService.getExchangeRate(currencyDto.getSendingCon(),currencyDto.getReceivingCon())).thenReturn(0);
        mvc.perform(get("/api/exchangerate")
                .param(currencyDto.getSendingCon(),currencyDto.getReceivingCon()))
                .andExpect(status().isOk())
                .andDo(print());




//        mvc.perform(get("/api/exchangerate")
//                .param(currencyDto.getSendingCon(),currencyDto.getReceivingCon())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.success").value("true"))
//                .andDo(print());



    }

}
