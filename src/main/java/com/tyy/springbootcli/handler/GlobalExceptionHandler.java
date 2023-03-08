package com.tyy.springbootcli.handler;
import com.tyy.springbootcli.common.exception.BusinessException;
import com.tyy.springbootcli.result.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class GlobalExceptionHandler  {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    public ResponseResult<?> allExceptionHandler(HttpServletRequest request, Exception exception, HttpServletResponse response) {
//        String exNm = exception.getClass().getName();
        logger.error("请求出现异常:"+ request.getRequestURI()+","+exception.getMessage());
        if (exception instanceof BusinessException){
            return ResponseResult.error(exception.getMessage());
        } else {
            logger.error("请求异常详情:"+ exception.getMessage());
            return ResponseResult.error("系统异常");
        }
    }

}
