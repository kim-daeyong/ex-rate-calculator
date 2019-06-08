package example.daeyong.kim.exratecalculator.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 1
@Aspect // 2
@Slf4j
public class LogAspect {

    protected static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Before("execution(public * example..*(..))")
    public void before(JoinPoint jointPoint) {
        String signatureName = jointPoint.getSignature().getName();
        logger.info("@Before [ " + signatureName + " ] 메서드 실행 전처리 수행 ");
        for(Object arg : jointPoint.getArgs()) {
            logger.info("@Before [ " + signatureName + " ] : " + arg);
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
    }

    @After("execution(* *..*.*service(..))")
    public void afterFinally(JoinPoint joinPoint) {
        String signatureName = joinPoint.getSignature().getName();
        logger.info("@After [ " + signatureName + " ] 메서드 실행 완료");
    }
}
