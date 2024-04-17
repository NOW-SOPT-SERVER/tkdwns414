package org.sopt.carrot.dto.common;

import jakarta.validation.constraints.NotNull;
import org.sopt.carrot.dto.type.ErrorCode;

public record ExceptionDto (
        @NotNull Integer code,
        @NotNull String message
) {

    public static ExceptionDto of(ErrorCode errorCode) {
        return new ExceptionDto(
                errorCode.getCode(),
                errorCode.getMessage()
        );
    }
}
