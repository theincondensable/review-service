package io.incondensable.review.data.mapper.impl;

import io.incondensable.review.data.mapper.LocalMapper;
import io.incondensable.review.data.model.VoteEntity;
import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.global.annotations.Mapper;

@Mapper
public class VoteMapper implements LocalMapper<VoteEntity, Vote> {

    @Override
    public Vote mapEntityToDomain(VoteEntity entity) {
        return new Vote(
                entity.getId(),
                entity.getScore(),
                entity.getStatus().getCode(),
                entity.getProduct().getId(),
                entity.getUser().getId()
        );
    }

    @Override
    public VoteEntity mapDomainToEntity(Vote domain) {
        return null;
    }

}
