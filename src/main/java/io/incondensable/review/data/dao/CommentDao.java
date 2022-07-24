package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.CommentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDao extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT c FROM CommentEntity c WHERE c.product.id = :productId")
    List<CommentEntity> findAllCommentsByProductId(@Param("productId") long productId);

    @Query("SELECT c FROM CommentEntity c WHERE c.product.id = :productId AND c.status.code = :productStatus ORDER BY c.id DESC")
    List<CommentEntity> findLastThreeApprovedCommentsByProductId(@Param("productId") long productId, @Param("productStatus") byte productStatus, Pageable pageable);

    @Query("SELECT count(c) FROM CommentEntity as c left join ProductEntity p on p.id = c.product.id where c.id = :commentId AND p.manager.id = :managerId")
    Integer isManagerTheOwnerOfProductForApprovingComment(@Param("managerId") Long managerId, @Param("commentId") Long commentId);

    @Modifying
    @Query("UPDATE CommentEntity c SET c.status.code = :approvedStatus WHERE c.id = :commentId")
    void approveComment(@Param("approvedStatus") Byte approvedStatus, @Param("commentId") Long commentId);

}
