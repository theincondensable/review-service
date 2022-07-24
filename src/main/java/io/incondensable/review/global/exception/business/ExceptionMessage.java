package io.incondensable.review.global.exception.business;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionMessage {
    private final String message;
    private final HttpStatus httpStatus;
    private final Object[] args;
    private final LocalDateTime time;

    public ExceptionMessage(String message,HttpStatus status, Object[] args) {
        this.message = message;
        this.httpStatus = status;
        this.args = args;
        this.time = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Object[] getArgs() {
        return args;
    }

    public LocalDateTime getTime() {
        return time;
    }

}
