package org.example.expert.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Aspect
@Slf4j
@Component
public class AspectBundle {

    @Pointcut("@annotation(org.example.expert.annotation.TrackUser)")
    private void trackUserAnnotation() {}

    @Before("trackUserAnnotation())")
    public void beforeMethod() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        log.info("요청한 사용자의 Id : {}",request.getAttribute("userId"));
        log.info("API 요청 URL : {}", request.getRequestURI());
        log.info("API 요청시각 : {}", LocalDateTime.now());
    }

}
