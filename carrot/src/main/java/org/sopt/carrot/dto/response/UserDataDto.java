package org.sopt.carrot.dto.response;

import org.sopt.carrot.domain.User;

public record UserDataDto (
        Long id,
        String nickname
) {
    public static UserDataDto of(User user) {
        return new UserDataDto(user.getId(), user.getNickname());
    }
}
