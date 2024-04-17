package org.sopt.carrot.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.carrot.domain.enums.EStatus;
import org.sopt.carrot.domain.enums.ETradingType;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EStatus status;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "can_negotiate", nullable = false)
    private boolean canNegotiate;

    @Column(name = "price", nullable = false)
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "trading_type", nullable = false)
    private ETradingType tradingType;

    @Column(name = "can_receive_give_away", nullable = false)
    private boolean canReceiveGiveAway;

    @Column(name = "description")
    private String description;

    // todo: 거래 희망 장소, 이미지, 생성일, 카테고리

    @Builder
    public Product(User user, EStatus status, String title, boolean canNegotiate, int price, ETradingType tradingType, boolean canReceiveGiveAway, String description) {
        this.user = user;
        this.status = status;
        this.title = title;
        this.canNegotiate = canNegotiate;
        this.price = price;
        this.tradingType = tradingType;
        this.canReceiveGiveAway = canReceiveGiveAway;
        this.description = description;
    }

    public static Product createSaleProduct(
            User user,
            String title,
            boolean canNegotiate,
            int price,
            String description
    ){
        return Product.builder()
                .status(EStatus.AVAILABLE)
                .tradingType(ETradingType.SALE)
                .canReceiveGiveAway(false)
                .user(user)
                .title(title)
                .canNegotiate(canNegotiate)
                .price(price)
                .description(description)
                .build();
    }

    public static Product createGiveAwayProduct(
            User user,
            String title,
            boolean canReceiveGiveAway,
            String description
    ){
        return Product.builder()
                .status(EStatus.AVAILABLE)
                .tradingType(ETradingType.GIVEAWAY)
                .canNegotiate(false)
                .price(0)
                .user(user)
                .title(title)
                .canReceiveGiveAway(canReceiveGiveAway)
                .description(description)
                .build();
    }
}
