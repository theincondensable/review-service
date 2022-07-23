package io.incondensable.review.global.exception;

import io.incondensable.review.global.exception.business.BusinessException;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity handleBusinessException(BusinessException exception) {
        return new ResponseEntity<>(
                getErrorMessage(exception), exception.getExceptionMessage().getHttpStatus()
        );
    }

    private String getErrorMessage(BusinessException exception) {
        return messageSource.getMessage(
                exception.getExceptionMessage().getMessage(),
                exception.getExceptionMessage().getArgs(),
                Locale.getDefault()
        );
    }

}
