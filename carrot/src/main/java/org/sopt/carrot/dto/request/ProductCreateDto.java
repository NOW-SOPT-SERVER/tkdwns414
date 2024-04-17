package org.sopt.carrot.dto.request;

import org.sopt.carrot.domain.enums.ETradingType;

public record ProductCreateDto(
    String title,
    boolean canNegotiate,
    int price,
    ETradingType tradingType,
    boolean canReceiveGiveAway,
    String description
) {
}
