package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
}
