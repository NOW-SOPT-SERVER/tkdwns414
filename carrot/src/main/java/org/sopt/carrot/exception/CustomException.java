package org.sopt.carrot.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.carrot.dto.type.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public String getMessage() {
        return errorCode.getMessage();
    }
}
