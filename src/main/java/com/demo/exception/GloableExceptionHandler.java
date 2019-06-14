package com.demo.exception;

import com.demo.javabean.RestResult;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@SuppressWarnings("all")
public class GloableExceptionHandler {

    /**
     * 处理全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public RestResult handleGlobalException(Exception e) {
        e.printStackTrace();//用于云桌面查看日志
        RestResult result = new RestResult();
        result.setCode("500");
        result.setValue("服务器异常: " + e.getLocalizedMessage());
        result.setResponseData(null);
        return result;
    }

    @ExceptionHandler(value = {BindException.class})
    public RestResult handleGlobalException(BindException e) {
        RestResult result = new RestResult();
        result.setCode("500");
        List<ObjectError> errors = e.getAllErrors();
        StringBuilder errorMessage = new StringBuilder();
        for(ObjectError error : errors){
            errorMessage.append(error.getDefaultMessage());
        }
        result.setValue("参数异常: " + errorMessage);
        return result;
    }
}
