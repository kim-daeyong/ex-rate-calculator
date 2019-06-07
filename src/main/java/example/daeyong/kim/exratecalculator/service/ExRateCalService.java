package example.daeyong.kim.exratecalculator.service;

public interface ExRateCalService {

    Double getExRateCal(String sendingCon, String receivingCon);

    String convertForm(Number number);
}
