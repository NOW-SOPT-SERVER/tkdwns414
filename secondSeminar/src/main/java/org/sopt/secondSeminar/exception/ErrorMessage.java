package org.sopt.secondSeminar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    BLOG_PERMISSION_DENIED(HttpStatus.FORBIDDEN.value(), "해당 블로그의 주인이 아닙니다."),
    POST_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 게시글이 존재하지 않습니다."),
    POST_NOT_IN_BLOG_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 게시글이 존재하지 않습니다."),

    ;

    private final int status;
    private final String message;
}
