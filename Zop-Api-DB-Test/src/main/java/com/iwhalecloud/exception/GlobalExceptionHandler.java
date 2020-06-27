package com.iwhalecloud.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * 统一异常处理
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    //private static String PARAM_FAIL_CODE = "600";
    //private static String VALIDATION_CODE = "1003";

    @ExceptionHandler(BindException.class)
    public DcoosExceptionResponse validExceptionHandler(BindException bindException) {
        FieldError fieldError = bindException.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        // 将错误的参数的详细信息封装到统一的返回实体
        DcoosExceptionResponse dcoosExceptionResponse = new DcoosExceptionResponse();
        dcoosExceptionResponse.setCode(fieldError.getCode());
        dcoosExceptionResponse.setStatus("400");
        dcoosExceptionResponse.setMessage(fieldError.getDefaultMessage());
        dcoosExceptionResponse.setReferenceError(fieldError.getDefaultMessage());
        dcoosExceptionResponse.setReason(fieldError.getField() + "错误");
        return dcoosExceptionResponse;
    }

    /**
     * 方法参数校验
     * 捕捉全局异常之后Controller不需要BindingResult result
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DcoosExceptionResponse validExceptionHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        // 将错误的参数的详细信息封装到统一的返回实体
        DcoosExceptionResponse dcoosExceptionResponse = new DcoosExceptionResponse();
        dcoosExceptionResponse.setCode(fieldError.getCode());
        dcoosExceptionResponse.setStatus("400");
        dcoosExceptionResponse.setMessage(fieldError.getDefaultMessage());
        dcoosExceptionResponse.setReferenceError(fieldError.getDefaultMessage());
        dcoosExceptionResponse.setReason(fieldError.getField() + "错误");
        return dcoosExceptionResponse;
    }

    /**
     * ValidationException
     */
    /*@ExceptionHandler(ValidationException.class)
    public DcoosExceptionResponse handleValidationException(ValidationException e) {
        return new DcoosExceptionResponse(VALIDATION_CODE, e.getCause().getMessage());
    }*/

    /**
     * ConstraintViolationException
     */
    /*@ExceptionHandler(ConstraintViolationException.class)
    public DcoosExceptionResponse handleConstraintViolationException(ConstraintViolationException e) {
        return new DcoosExceptionResponse(PARAM_FAIL_CODE, e.getMessage());
    }*/


    /*@ExceptionHandler(value = Exception.class)  //定义异常处理器
    public Object dealExceptionHandler(Exception e) {
        String failMessage = null;

        //判断是否为绑定异常
        *//*if(e instanceof BindException){
            BindException ex = (BindException)e;
            failMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
            return validExceptionHandler(ex);
        }*//*

        return failMessage;
    }*/


    /**
     * 404异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public DcoosExceptionResponse handlerNoFoundException(Exception e) {
        return new DcoosExceptionResponse("404", "路径不存在，请检查路径是否正确");
    }

    /**
     * 500异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public DcoosExceptionResponse handleException(Exception e) {
        return new DcoosExceptionResponse("500", "系统繁忙,请稍后再试");
    }
}
