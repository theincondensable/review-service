package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerDao extends JpaRepository<ManagerEntity, Long> {

    @Query("SELECT count(c) FROM CommentEntity as c left join ProductEntity p on p.id = c.product.id where c.id = :commentId AND p.manager.id = :managerId")
    Integer isManagerTheOwnerOfProductForApprovingComment(@Param("managerId") Long managerId, @Param("commentId") Long commentId);

    @Query("SELECT count(v) FROM VoteEntity as v left join ProductEntity p on p.id = v.product.id where v.id = :voteId AND p.manager.id = :managerId")
    Integer isManagerTheOwnerOfProductForApprovingVote(@Param("managerId") Long managerId, @Param("voteId") Long voteId);

    @Modifying
    @Query("UPDATE CommentEntity c SET c.status.code = :approvedStatus WHERE c.id = :commentId")
    void approveComment(@Param("approvedStatus") Byte approvedStatus, @Param("commentId") Long commentId);

    @Modifying
    @Query("UPDATE VoteEntity v SET v.status.code = :approvedStatus WHERE v.id = :voteId")
    void approveVote(@Param("approvedStatus") Byte approvedStatus, @Param("voteId") Long voteId);

}
