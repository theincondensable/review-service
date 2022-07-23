package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ReviewableProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ReviewableProductResponseDto> getAllProductsAvailableToReview();

}
