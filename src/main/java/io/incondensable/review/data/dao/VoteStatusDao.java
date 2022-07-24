package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.VoteStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteStatusDao extends JpaRepository<VoteStatus, Byte> {
}
