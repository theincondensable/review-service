package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.isReviewAvailableForAll = :isReviewAvailableForAll")
    List<ProductEntity> findAllReviewableProducts(@Param("isReviewAvailableForAll") byte isReviewAvailableForAll);



}
