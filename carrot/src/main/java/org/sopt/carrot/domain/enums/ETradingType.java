package org.sopt.carrot.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ETradingType {
    SALE("판매하기"),
    GIVEAWAY("나눔하기");

    private final String value;
}
