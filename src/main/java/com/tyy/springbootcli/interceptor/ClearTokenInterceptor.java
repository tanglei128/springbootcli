package com.tyy.springbootcli.interceptor;

import com.tyy.springbootcli.common.exception.BusinessException;
import com.tyy.springbootcli.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session超时，通知前端删除token
 *
 * @author shimh
 * <p>
 * 2018年1月30日
 */

public class ClearTokenInterceptor implements HandlerInterceptor {

    private static final String SESSION_TIME_OUT_K = "SESSION_TIME_OUT";
    private static final String SESSION_TIME_OUT_V = "timeout";
    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader(AUTHORIZATION);

        if (null != token) {
            Object tokenRedis = redisUtil.get(token);

            if (null == tokenRedis) {
                throw new BusinessException("token校验不通过");
//                response.setHeader(SESSION_TIME_OUT_K, SESSION_TIME_OUT_V);
            }
        }

        return true;
    }

}
