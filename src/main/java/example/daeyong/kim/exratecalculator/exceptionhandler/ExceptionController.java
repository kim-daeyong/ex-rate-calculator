package example.daeyong.kim.exratecalculator.exceptionhandler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(Error.class)
    public String handlerError(Error error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNull(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegal(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handlerRestClient(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerException(Exception error){
        log.warn(error.getClass().getName() + "  " +error.getMessage());
        return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
