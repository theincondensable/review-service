package io.incondensable.review.data.mapper.impl;

import io.incondensable.review.data.mapper.LocalMapper;
import io.incondensable.review.data.model.CommentEntity;
import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.global.annotations.Mapper;

@Mapper
public class CommentMapper implements LocalMapper<CommentEntity, Comment> {

    @Override
    public Comment mapEntityToDomain(CommentEntity entity) {
        return Comment.build(
                entity.getId(),
                entity.getContext(),
                entity.getStatus().getCode(),
                entity.getProduct().getId(),
                entity.getUser().getId()
        );
    }

    @Override
    public CommentEntity mapDomainToEntity(Comment domain) {
//        return new CommentEntity(
//                domain.getId(),
//                domain.getContext(),
//                domain.getStatus(),
//                domain.getProductId()
//        );
        return null;
    }

}
