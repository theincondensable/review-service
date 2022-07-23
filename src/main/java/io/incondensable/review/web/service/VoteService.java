package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductVotesDto;

import java.util.List;

public interface VoteService {

    List<ProductVotesDto> getAllVotesOfProduct(Long productId);

    List<ProductVotesDto> getAllApprovedVotesOfProduct(Long productId);

}
