package io.incondensable.review.data.mapper.impl;

import io.incondensable.review.data.dao.CommentStatusDao;
import io.incondensable.review.data.dao.ProductDao;
import io.incondensable.review.data.dao.UserDao;
import io.incondensable.review.data.mapper.LocalMapper;
import io.incondensable.review.data.model.CommentEntity;
import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.global.annotations.Mapper;

@Mapper
public class CommentMapper implements LocalMapper<CommentEntity, Comment> {

    private final UserDao userDao;
    private final ProductDao productDao;
    private final CommentStatusDao commentStatusDao;

    public CommentMapper(UserDao userDao, ProductDao productDao, CommentStatusDao commentStatusDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.commentStatusDao = commentStatusDao;
    }

    @Override
    public Comment mapEntityToDomain(CommentEntity entity) {
        return Comment.buildFromEntity(
                entity.getId(),
                entity.getContext(),
                entity.getStatus().getCode(),
                entity.getProduct().getId(),
                entity.getUser().getId()
        );
    }

    @Override
    public CommentEntity mapDomainToEntity(Comment domain) {
        return new CommentEntity(
                domain.getContext(),
                commentStatusDao.getById(domain.getStatus()),
                productDao.getById(domain.getProductId()),
                userDao.getById(domain.getUserId())
        );
    }

}
