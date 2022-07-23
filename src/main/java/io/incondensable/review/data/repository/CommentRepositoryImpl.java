package io.incondensable.review.data.repository;

import io.incondensable.review.data.dao.CommentDao;
import io.incondensable.review.data.mapper.impl.CommentMapper;
import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.domain.repository.CommentRepository;
import io.incondensable.review.global.constants.ProductsConstants;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentDao dao;
    private final CommentMapper mapper;

    public CommentRepositoryImpl(CommentDao dao, CommentMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<Comment> getCommentsOfProduct(Long productId) {
        return dao.findAllCommentsByProductId(productId)
                .stream()
                .map(mapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Comment> getApprovedCommentsOfProduct(Long productId) {
        return dao.findAllApprovedCommentsByProductId(
                        productId,
                        ProductsConstants.VoteAndCommentStatus.APPROVED.getValue()
                ).stream()
                .map(mapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }

}
