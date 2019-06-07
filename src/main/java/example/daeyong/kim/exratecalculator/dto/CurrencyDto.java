package example.daeyong.kim.exratecalculator.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CurrencyDto {

    // notNull, "", " " 를 허용하지않는다.
//    @NotBlank
    private String sendingCon;
//    @NotBlank
    private String receivingCon;

    @Min(0)
    @Max(10000)
    private double amount;


}
