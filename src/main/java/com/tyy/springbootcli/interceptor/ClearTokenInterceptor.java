package com.tyy.springbootcli.interceptor;

import com.tyy.springbootcli.common.exception.AuthException;
import com.tyy.springbootcli.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class ClearTokenInterceptor implements HandlerInterceptor {
    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private RedisUtil redisUtil;

    List<String> whiteUrls = Arrays.asList("/v1/login");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("requestURI:"+requestURI);
        System.out.println("request"+request.getHeader(AUTHORIZATION));
        String token = request.getHeader(AUTHORIZATION);
        if (whiteUrls.contains(requestURI)) {
            return true;
        }
        if (null == token) {
            throw new AuthException("token不能为空！");
        }
        Object tokenRedis = redisUtil.get(token);
        if (null == tokenRedis) {
            throw new AuthException("token校验不通过");
        }
        return true;
    }
}
