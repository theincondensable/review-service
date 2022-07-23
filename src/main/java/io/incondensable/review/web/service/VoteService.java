package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductVotesResponseDto;

import java.util.List;

public interface VoteService {

    List<ProductVotesResponseDto> getAllVotesOfProduct(Long productId);

    List<ProductVotesResponseDto> getAllApprovedVotesOfProduct(Long productId);

    Integer getSumOfApprovedVotesOfProduct(Long productId);

}
