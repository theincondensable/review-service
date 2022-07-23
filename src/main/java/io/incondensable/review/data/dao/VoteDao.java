package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteDao extends JpaRepository<VoteEntity, Long> {

    @Query("SELECT v FROM VoteEntity v WHERE v.product.id = :productId")
    List<VoteEntity> findAllVotesByProductId(@Param("productId") long productId);

    @Query("SELECT v FROM VoteEntity v WHERE v.product.id = :productId AND v.status.code = :voteStatus")
    List<VoteEntity> findAllApprovedVotesByProductId(@Param("productId") long productId, @Param("voteStatus") byte voteStatus);

}
