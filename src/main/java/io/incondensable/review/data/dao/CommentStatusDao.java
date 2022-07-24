package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.CommentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentStatusDao extends JpaRepository<CommentStatus, Byte> {
}
