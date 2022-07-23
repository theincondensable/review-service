package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductCommentsResponseDto;

import java.util.List;

public interface CommentService {

    List<ProductCommentsResponseDto> getAllCommentsOfProduct(Long productId);

    List<ProductCommentsResponseDto> getAllApprovedCommentsOfProduct(Long productId);

}
