package org.sopt.carrot.dto.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //400
    BAD_REQUEST(40000, HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    MISSING_REQUEST_HEADER(40001, HttpStatus.BAD_REQUEST, "필수 헤더가 누락되었습니다."),
    // 404 Not Found
    NOT_FOUND_END_POINT(40400, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    NOT_FOUND_USER(40401, HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),
    NOT_FOUND_PRODUCT(40402, HttpStatus.NOT_FOUND, "존재하지 않는 상품입니다."),
    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
