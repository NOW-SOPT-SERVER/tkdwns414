package org.sopt.carrot.dto.response;

import org.sopt.carrot.domain.Product;
import org.sopt.carrot.domain.enums.EStatus;
import org.sopt.carrot.domain.enums.ETradingType;

public record ProductDataDto(
        Long id,
        String title,
        UserDataDto user,
        EStatus status,
        boolean canNegotiate,
        int price,
        ETradingType tradingType,
        boolean canReceiveGiveAway,
        String description
) {
    public static ProductDataDto of(Product product) {
        return new ProductDataDto(
                product.getId(),
                product.getTitle(),
                UserDataDto.of(product.getUser()),
                product.getStatus(),
                product.isCanNegotiate(),
                product.getPrice(),
                product.getTradingType(),
                product.isCanReceiveGiveAway(), 
                product.getDescription()
        );
    }
}
