package com.tqsm.life.config.exception;


import com.tqsm.life.config.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理
 * <p>方法顺序及捕获顺序</p>
 *
 * @author qtx
 * @since 2022/10/29 0:05
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NullPointerException.class)
//    public Result<String> nullException(NullPointerException e) {
//        log.error("空指针异常");
//        return Result.failed("空指针异常");
//    }

    @ExceptionHandler(DataException.class)
    public Result<String> dateException(DataException e) {
        log.info("DataException:{}", e.getMessage());
        return Result.failed(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        log.error(e.getMessage(), e);
        return Result.failed(e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}