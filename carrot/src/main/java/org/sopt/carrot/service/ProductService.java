package org.sopt.carrot.service;

import lombok.RequiredArgsConstructor;
import org.sopt.carrot.domain.Product;
import org.sopt.carrot.domain.User;
import org.sopt.carrot.domain.enums.ETradingType;
import org.sopt.carrot.dto.request.ProductCreateDto;
import org.sopt.carrot.dto.response.ProductDataDto;
import org.sopt.carrot.dto.type.ErrorCode;
import org.sopt.carrot.exception.CustomException;
import org.sopt.carrot.repository.ProductRepository;
import org.sopt.carrot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public void createProduct(Long userId, ProductCreateDto productCreateDto) {
        User user = userRepository.findByIdOrThrow(userId);
        if (productCreateDto.tradingType().equals(ETradingType.SALE))
            productRepository.save(
                    Product.createSaleProduct(user, productCreateDto.title(), productCreateDto.canNegotiate(), productCreateDto.price(), productCreateDto.description())
            );
        else if (productCreateDto.tradingType().equals(ETradingType.GIVEAWAY))
            productRepository.save(
                    Product.createGiveAwayProduct(user, productCreateDto.title(), productCreateDto.canReceiveGiveAway(), productCreateDto.description())
            );
        else
            throw new CustomException(ErrorCode.BAD_REQUEST);

    }

    public ProductDataDto getProduct(Long productId) {
        Product product = productRepository.findByIdOrThrow(productId);
        return ProductDataDto.of(product);
    }
}
