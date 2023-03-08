package cn.java.log.aspect;

import cn.java.log.config.LogProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@AllArgsConstructor
public class LogAspect {

    LogProperties logProperties;

    @Pointcut("@annotation(cn.java.log.aspect.Log)")
    public void pointCut(){}


    @Around("pointCut() && @annotation(logA)")
    public Object around(ProceedingJoinPoint joinPoint, Log logA){
        // 执行的方法名称
        String taskName = joinPoint.getSignature()
                .toString().substring(
                        joinPoint.getSignature()
                                .toString().indexOf(" "),
                        joinPoint.getSignature().toString().indexOf("(")
                ).trim();

        long time = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("{} -- method :{} run : {} ms ",logProperties.getAppName(),taskName,(System.currentTimeMillis() - time));
        return result;
    }

}
