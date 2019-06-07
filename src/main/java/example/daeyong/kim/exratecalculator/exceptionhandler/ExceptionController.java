package example.daeyong.kim.exratecalculator.exceptionhandler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(Error.class)
    public String handlerError(Error error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handlerNull(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return "error";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handlerIllegal(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return "error";
    }

}
