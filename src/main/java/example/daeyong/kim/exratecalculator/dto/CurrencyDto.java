package example.daeyong.kim.exratecalculator.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class CurrencyDto {

    // notNull, "", " " 를 허용하지않는다.
//    @NotBlank
    private String sendingCon;
//    @NotBlank
    private String receivingCon;
    @Min(0)
    @Max(10000)
    private double amount;

//    private double

    public CurrencyDto(){

    }

    public CurrencyDto(String sendingCon, String receivingCon, @Min(0) @Max(10000) double amount) {
        this.sendingCon = sendingCon;
        this.receivingCon = receivingCon;
        this.amount = amount;
    }


}
