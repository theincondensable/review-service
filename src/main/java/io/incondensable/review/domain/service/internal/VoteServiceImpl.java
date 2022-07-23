package io.incondensable.review.domain.service.internal;

import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.domain.repository.VoteRepository;
import io.incondensable.review.web.dto.ProductVotesDto;
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
    public List<ProductVotesDto> getAllVotesOfProduct(Long productId) {
        List<Vote> allProductVotes = repository.getVotesOfProduct(productId);

        return createResponseDto(allProductVotes);
    }

    @Override
    public List<ProductVotesDto> getAllApprovedVotesOfProduct(Long productId) {
        List<Vote> allProductApprovedVotes = repository.getApprovedVotesOfProduct(productId);

        return createResponseDto(allProductApprovedVotes);
    }

    private List<ProductVotesDto> createResponseDto(List<Vote> input) {
        List<ProductVotesDto> response = new ArrayList<>();

        input.forEach(
                entity -> response.add(
                        new ProductVotesDto(
                                entity.getId(),
                                entity.getScore(),
                                entity.getProductId()
                        )
                )
        );

        return response;
    }

}
