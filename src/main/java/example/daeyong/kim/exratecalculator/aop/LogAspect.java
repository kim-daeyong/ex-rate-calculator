package example.daeyong.kim.exratecalculator.aop;


import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component // 1
@Aspect // 2
@Slf4j
@PropertySource( value = "/apikey.properties", ignoreResourceNotFound = true )
public class LogAspect {

    @Value("${slackApi.key}")
    private String accessKey;

    protected static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private final SlackMessage slackMessage = new SlackMessage();



    @Before("execution(public * example..*(..))")
    public void before(JoinPoint jointPoint) {
        String signatureName = jointPoint.getSignature().getName();
        SlackApi slackApi = new SlackApi(""+accessKey+"");
        slackMessage.setUsername("testtest");
        slackMessage.setChannel("#general");
        logger.info("@Before [ " + signatureName + " ] 메서드 실행 전처리 수행 ");
        for(Object arg : jointPoint.getArgs()) {
            logger.info("@Before [ " + signatureName + " ] : " + arg);
            slackMessage.setText("{"+ signatureName +"}, return= {"+arg+"}");
            slackApi.call(slackMessage);
        }
    }

    @AfterReturning(pointcut="execution(public * example.daeyong.kim.exratecalculator.*.*(..))", returning="ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {


        String signatureName = joinPoint.getSignature().getName();
        logger.info("@AfterReturing [ " + signatureName + " ] 메서드 실행 후처리 수행");
        logger.info("@AfterReturing [ " + signatureName + " ] 리턴값=" + ret);

    }

    @AfterThrowing(pointcut="execution(* *..service*.*(..))", throwing="ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String signatureName = joinPoint.getSignature().getName();
        logger.info("@AfterThrowing [ " + signatureName + " ] 메서드 실행 중 예외 발생");
        logger.info("@AfterThrowing [ " + signatureName + " ] 예외=" + ex.getMessage());
        SlackApi slackApi = new SlackApi(""+accessKey+"");
        slackMessage.setUsername("testtest");
        slackMessage.setChannel("#general");
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        slackMessage.setText(" url={"+request.getRequestURL()+"}, errorMessage={"+ex+"}");
        slackApi.call(slackMessage);
    }

    @After("execution(* *..*.*service(..))")
    public void afterFinally(JoinPoint joinPoint) {
        String signatureName = joinPoint.getSignature().getName();
        logger.info("@After [ " + signatureName + " ] 메서드 실행 완료");


    }
}
