package io.incondensable.review.global.exception.business;

public class BusinessException extends RuntimeException {
    private ExceptionMessage exceptionMessage;

    public BusinessException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }

}
