package com.tyy.springbootcli.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

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
        // 无需拦截的接口集合
        List<String> ignorePath = new ArrayList<>();
        ignorePath.add("/v1/login");
        // knife4j(swagger) v2->v3 此处很重要，涉及到拦截器是否能正确放行
        ignorePath.add("/swagger-resources/**");
        ignorePath.add("/doc.html");
        ignorePath.add("/v3/**");
        ignorePath.add("/webjars/**");

        ignorePath.add("/static/**");
        ignorePath.add("/templates/**");
        ignorePath.add("/error");
        registry.addInterceptor(initAuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(ignorePath);
    }
}
