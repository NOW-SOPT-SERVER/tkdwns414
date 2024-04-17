package org.sopt.carrot.repository;

import org.sopt.carrot.domain.Product;
import org.sopt.carrot.dto.type.ErrorCode;
import org.sopt.carrot.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    default Product findByIdOrThrow(Long id){
        return findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_PRODUCT));
    };
}
