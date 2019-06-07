package example.daeyong.kim.exratecalculator.Service;


import example.daeyong.kim.exratecalculator.dto.CurrencyDto;
import example.daeyong.kim.exratecalculator.dto.ExRateAPIDto;
import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import example.daeyong.kim.exratecalculator.service.ExRateCalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExRateCalTest {

    @Autowired
    private ExRateCalService exRateCalService;

    @Autowired
    private ExRateAPIService exRateAPIService;

    //USD, KRW을 입력하였을때 정상적인 출력 확인
    @Test
    public void getAPIDataByUSDKRW() {
        Double exRate = exRateCalService.getExRateCal("USD", "KRW");
        ExRateAPIDto exRateAPIDto=exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRate);
        Assert.assertEquals(exRateAPIDto.getQuotes().get("USDKRW"), exRate);
        System.out.println(exRate);
        System.out.println(exRateAPIDto.getQuotes().get("USDKRW"));
    }

    //USD, JPY을 입력하였을때 정상적인 출력 확인
    @Test
    public void getAPIDataByUSDJPY() {
        Double exRate = exRateCalService.getExRateCal("USD", "JPY");
        ExRateAPIDto exRateAPIDto=exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRate);
        Assert.assertEquals(exRateAPIDto.getQuotes().get("USDJPY"), exRate);
        System.out.println(exRate);
        System.out.println(exRateAPIDto.getQuotes().get("USDJPY"));
    }

    //USD, PHP을 입력하였을때 정상적인 출력 확인
    @Test
    public void getAPIDataByUSDPHP() {
        Double exRate = exRateCalService.getExRateCal("USD", "PHP");
        ExRateAPIDto exRateAPIDto=exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRate);
        Assert.assertEquals(exRateAPIDto.getQuotes().get("USDPHP"), exRate);
        System.out.println(exRate);
        System.out.println(exRateAPIDto.getQuotes().get("USDPHP"));
    }

    //USD이외의 KRW, PHP을 입력하였을때 출력 확인
    @Test
    public void getAPIDataByKRWPHP() {
        Double exRate = exRateCalService.getExRateCal("KRW", "PHP");
        ExRateAPIDto exRateAPIDto=exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRate); // NULL
        Assert.assertEquals(exRateAPIDto.getQuotes().get("KRWPHP"), exRate);
        System.out.println(exRate);
        System.out.println(exRateAPIDto.getQuotes().get("KRWPHP"));
    }

    //USD, KRW을 입력하였을때 폼(#,###.##) 변환 확인
    @Test
    public void getAPIDataToConvertForm() {
        Double exRate = exRateCalService.getExRateCal("USD", "KRW");
        ExRateAPIDto exRateAPIDto=exRateAPIService.getExchangeRate();
        Assert.assertNotNull(exRate);
        Assert.assertEquals(exRateAPIDto.getQuotes().get("USDKRW"), exRate);
        String cenvertForm = exRateCalService.convertForm(exRate);
        System.out.println(cenvertForm);
        System.out.println(exRateAPIDto.getQuotes().get("USDKRW"));
    }

}
