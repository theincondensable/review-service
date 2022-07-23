package io.incondensable.review.domain.service;

import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.domain.repository.VoteRepository;
import io.incondensable.review.web.dto.ProductVotesResponseDto;
import io.incondensable.review.web.service.VoteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This service is responsible for retrieving the Approved and UnApproved Votes
 */
@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductVotesResponseDto> getAllVotesOfProduct(Long productId) {
        List<Vote> allProductVotes = repository.getVotesOfProduct(productId);

        return createResponseDto(allProductVotes);
    }

    @Override
    public List<ProductVotesResponseDto> getAllApprovedVotesOfProduct(Long productId) {
        List<Vote> allProductApprovedVotes = repository.getApprovedVotesOfProduct(productId);

        return createResponseDto(allProductApprovedVotes);
    }

    private List<ProductVotesResponseDto> createResponseDto(List<Vote> input) {
        List<ProductVotesResponseDto> response = new ArrayList<>();

        input.forEach(
                model -> response.add(
                        new ProductVotesResponseDto(
                                model.getId(),
                                model.getScore(),
                                model.getProductId(),
                                model.getUserId()
                        )
                )
        );

        return response;
    }

}