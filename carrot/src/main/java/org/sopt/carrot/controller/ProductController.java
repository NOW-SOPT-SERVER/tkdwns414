package org.sopt.carrot.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.carrot.constant.Constants;
import org.sopt.carrot.dto.common.ApiResponse;
import org.sopt.carrot.dto.request.ProductCreateDto;
import org.sopt.carrot.dto.response.ProductDataDto;
import org.sopt.carrot.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<Void> createProduct(
            @RequestHeader(Constants.USER_ID) Long userId,
            @RequestBody ProductCreateDto productCreateDto
    ) {
        productService.createProduct(userId, productCreateDto);
        return ApiResponse.created(null);
    }

    @GetMapping("/{productId}")
    public ApiResponse<ProductDataDto> getProduct(
            @PathVariable Long productId
    ) {
        return ApiResponse.ok(productService.getProduct(productId));
    }
}
