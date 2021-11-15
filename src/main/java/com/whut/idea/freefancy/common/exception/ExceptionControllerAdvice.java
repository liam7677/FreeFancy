package com.whut.idea.freefancy.common.exception;

import com.whut.idea.freefancy.common.response.ResponseCode;
import com.whut.idea.freefancy.common.response.ResponseJson;
import com.whut.idea.freefancy.controller.PublicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author LiMing
 * @date 2021/11/11 16:15
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    /**
     * 数据校验或参数错误处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Object validatedExceptionHandler(BindException exception) {

        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();

        List<FieldError> fieldErrors = result.getFieldErrors();
        fieldErrors.forEach(error -> {
            log.error("field: " + error.getField() + ", msg:" + error.getDefaultMessage());
            errorMsg.append(error.getDefaultMessage()).append("!");
        });
        return ResponseJson.failure(ResponseCode.PARAM_ERROR.code(), errorMsg.toString());
    }

    /**
     * 处理运行时错误，因为这些错误是代码中未意识到，没有捕获处理的，需要记录日志。
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    public Object exceptionHandler(Exception e){
        // 获取异常信息，记录日志
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String className = stackTraceElement.getClassName();
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        String methodName = stackTraceElement.getMethodName();

        log.error("类名:{},文件名:{},行数:{},办法名:{}", className, fileName, lineNumber, methodName);

        return ResponseJson.failure(ResponseCode.SYSTEM_INNER_ERROR.code(),e.getMessage());
    }
}
