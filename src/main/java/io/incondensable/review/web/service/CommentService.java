package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductCommentsDto;

import java.util.List;

public interface CommentService {

    List<ProductCommentsDto> getAllCommentsOfProduct(Long productId);

    List<ProductCommentsDto> getAllApprovedCommentsOfProduct(Long productId);

}
