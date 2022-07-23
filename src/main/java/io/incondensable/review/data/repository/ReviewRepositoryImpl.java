package io.incondensable.review.data.repository;

import io.incondensable.review.data.model.ProductEntity;
import io.incondensable.review.data.mapper.impl.ReviewMapper;
import io.incondensable.review.domain.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private final ReviewMapper mapper;

    public ReviewRepositoryImpl(ReviewMapper mapper) {
        this.mapper = mapper;
    }

    public ProductEntity getProductAndItsApprovedCommentsAndVotes(long productId) {
        return null;
    }

}
