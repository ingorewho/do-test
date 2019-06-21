package com.ignore.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Author renzhiqiang
 * @Description 日志记录切面
 * @Date 2019-06-21
 **/
@Configuration
@Aspect
public class LogRecordAspect {
    private Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    @Pointcut("@annotation(logRecord)")
    public Object logRecord(ProceedingJoinPoint point, LogRecord logRecord)throws Throwable {
        // 可以打印相关记录日志
        logger.debug("....");
        return point.proceed();
    }
}
