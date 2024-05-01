package org.sopt.secondSeminar.dto;

import org.sopt.secondSeminar.common.SuccessMessage;

public record SuccessStatusResponse(
        int status,
        String message
) {

    public static SuccessStatusResponse of(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }

}
