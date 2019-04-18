package com.example.scheduledtest.config;

import com.example.scheduledtest.interceptor.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @className MyMvcConfig
 * @Description：配置拦截
 * @Date 2019/4/17 11:48
 * @Author shenguang
 * @Version 1.0
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoggerInterceptor loggerInterceptor;//拦截器
    /* *
     * @Author shenguang
     * @Description //配置拦截器，以及拦截的路径
     * @Param [registry]
     * @return void
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器，并添加需要拦截的路径（/**）表示拦截所有的路径
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
        //在拦截的路径（/**）下面，那些路径不进行拦截
        interceptorRegistration.excludePathPatterns("/welcome/*");
    }
    /* *
     * @Author shenguang
     * @Description //访问localhost:8089/toIndex 跳转到index.html页面，剔除之前使用controller进行跳转页面
     * @Param [registry]
     * @return void
     **/
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/toIndex").setViewName("/index.html");
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
//    }
}
