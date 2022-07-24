package io.incondensable.review.data.mapper.impl;

import io.incondensable.review.data.dao.ProductDao;
import io.incondensable.review.data.dao.UserDao;
import io.incondensable.review.data.dao.VoteStatusDao;
import io.incondensable.review.data.mapper.LocalMapper;
import io.incondensable.review.data.model.VoteEntity;
import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.global.annotations.Mapper;

@Mapper
public class VoteMapper implements LocalMapper<VoteEntity, Vote> {

    private final UserDao userDao;
    private final ProductDao productDao;
    private final VoteStatusDao voteStatusDao;

    public VoteMapper(UserDao userDao, ProductDao productDao, VoteStatusDao voteStatusDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.voteStatusDao = voteStatusDao;
    }

    @Override
    public Vote mapEntityToDomain(VoteEntity entity) {
        return Vote.buildFromEntity(
                entity.getId(),
                entity.getScore(),
                entity.getStatus().getCode(),
                entity.getProduct().getId(),
                entity.getUser().getId()
        );
    }

    @Override
    public VoteEntity mapDomainToEntity(Vote domain) {
        return new VoteEntity(
                domain.getScore(),
                voteStatusDao.getById(domain.getStatus()),
                productDao.getById(domain.getProductId()),
                userDao.getById(domain.getUserId())
        );
    }

}
