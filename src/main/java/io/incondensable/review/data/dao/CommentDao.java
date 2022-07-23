package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDao extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT c FROM CommentEntity c WHERE c.product.id = :productId")
    List<CommentEntity> findAllCommentsByProductId(@Param("productId") long productId);

    @Query("SELECT c FROM CommentEntity c WHERE c.product.id = :productId AND c.status.code = :productStatus")
    List<CommentEntity> findAllApprovedCommentsByProductId(@Param("productId") long productId, @Param("productStatus") byte productStatus);

}
