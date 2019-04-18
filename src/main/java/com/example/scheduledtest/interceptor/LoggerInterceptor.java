package com.example.scheduledtest.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className LoggerInterceptor
 * @Description
 * @Date 2019/4/17 11:35
 * @Author shenguang
 * @Version 1.0
 **/
@Component
public class LoggerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("className={},method={}","LoggerInterceptor.class","preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("className={},method={}","LoggerInterceptor.class","postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("className={},method={}","LoggerInterceptor.class","afterCompletion");
    }
}
