package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProductsAvailableToReview();

    ProductResponseDto getProductById(Long productId);

}
