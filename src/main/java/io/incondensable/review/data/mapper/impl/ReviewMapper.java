package io.incondensable.review.data.mapper.impl;

import io.incondensable.review.data.mapper.LocalMapper;
import io.incondensable.review.data.model.ReviewEntity;
import io.incondensable.review.global.annotations.Mapper;
import io.incondensable.review.domain.model.Review;

@Mapper
public class ReviewMapper implements LocalMapper<ReviewEntity, Review> {

    @Override
    public Review mapEntityToDomain(ReviewEntity reviewEntity) {
        return null;
    }

    @Override
    public ReviewEntity mapDomainToEntity(Review review) {
        return null;
    }

}
