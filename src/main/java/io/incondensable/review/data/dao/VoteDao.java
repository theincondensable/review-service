package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteDao extends JpaRepository<VoteEntity, Long> {

    @Query("SELECT v FROM VoteEntity v WHERE v.product.id = :productId")
    List<VoteEntity> findAllVotesByProductId(@Param("productId") long productId);

    @Query("SELECT v FROM VoteEntity v WHERE v.product.id = :productId AND v.status.code = :voteStatus")
    List<VoteEntity> findAllApprovedVotesByProductId(@Param("productId") long productId, @Param("voteStatus") byte voteStatus);

    @Query("SELECT sum(v.score) FROM VoteEntity v WHERE v.product.id = :productId AND v.status.code = :voteStatus")
    Integer findAllAndCalculateSumOfApprovedScoresByProductId(@Param("productId") long productId, @Param("voteStatus") byte voteStatus);

    @Query("SELECT count(v) FROM VoteEntity as v left join ProductEntity p on p.id = v.product.id where v.id = :voteId AND p.manager.id = :managerId")
    Integer isManagerTheOwnerOfProductForApprovingVote(@Param("managerId") Long managerId, @Param("voteId") Long voteId);

    @Modifying
    @Query("UPDATE VoteEntity v SET v.status.code = :approvedStatus WHERE v.id = :voteId")
    void approveVote(@Param("approvedStatus") Byte approvedStatus, @Param("voteId") Long voteId);



}
