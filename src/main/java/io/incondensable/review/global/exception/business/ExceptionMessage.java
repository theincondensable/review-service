package io.incondensable.review.global.exception.business;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionMessage {
    private String message;
    private HttpStatus httpStatus;
    private Object[] args;
    private LocalDateTime time;

    public ExceptionMessage(String message,HttpStatus status, Object[] args, LocalDateTime time) {
        this.message = message;
        this.httpStatus = status;
        this.args = args;
        this.time = time;
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
