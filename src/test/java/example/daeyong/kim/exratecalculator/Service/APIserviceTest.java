package example.daeyong.kim.exratecalculator.Service;


import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class APIserviceTest {


    @Autowired
    private ExRateAPIService exRateAPIService;

    @Test
    public void getAPIData() {
        ExRateAPIDto exRateAPIDto = exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRateAPIDto);
    }

    @Test
    public void getAPIDataByUSD() {
        ExRateAPIDto exRateAPIDto = exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRateAPIDto);
    }


}
