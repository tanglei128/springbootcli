package com.tyy.springbootcli.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    @Bean
    public ClearTokenInterceptor initAuthInterceptor(){
        return new ClearTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns：哪些路径下的会被拦截
        //excludePathPatterns：哪些路径下不会被拦截
        registry.addInterceptor(initAuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**");
    }
}
