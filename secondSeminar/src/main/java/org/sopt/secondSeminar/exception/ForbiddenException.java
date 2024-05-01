package org.sopt.secondSeminar.exception;

public class ForbiddenException extends BusinessException {
    public ForbiddenException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
