package example.daeyong.kim.exratecalculator.controller;


import example.daeyong.kim.exratecalculator.controller.api.ExRateAPIController;
import example.daeyong.kim.exratecalculator.dto.CurrencyDto;
import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Timestamp;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExRateAPIController.class)
public class ExRateAPITest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ExRateAPIService exRateAPIService;

    @MockBean
    ExRateAPIController exRateAPIController;



    @Test
    public void getAPIDataByUSDKRW() {

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setSendingCon("USD");
        currencyDto.setReceivingCon("KRW");
        currencyDto.setAmount(100.10);

//        Assert.assertNotNull(exRate);
//        Assert.assertEquals(exRateAPIDto.getQuotes().get("USDKRW"), exRate);
//        System.out.println(exRateAmount);
//        System.out.println(exRateAPIDto.getQuotes().get("USDKRW"));

//        given(this.exRateAPIController.getExchangeRate(currencyDto)).willReturn(currencyDto);

//        mvc.perform(get("/api/exchangerate"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("@[*].author", containsInAnyOrder("kwseo", "kwseo")));
    }

    @Test
    public void getAPIDataByUSDKRWWithAmonunt() {

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setSendingCon("USD");
        currencyDto.setReceivingCon("KRW");
        currencyDto.setAmount(100.10);

//        Assert.assertNotNull(exRate);
//        Assert.assertEquals(exRateAPIDto.getQuotes().get("USDKRW"), exRate);
//        System.out.println(exRateAmount);
//        System.out.println(exRateAPIDto.getQuotes().get("USDKRW"));


//        given(articleService.findFromDB(eq("kwseo"))).willReturn(articles);

//        mvc.perform(get("/api/receiving-currency?author=kwseo"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("@[*].author", containsInAnyOrder("kwseo", "kwseo")));
    }

}
