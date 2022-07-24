package io.incondensable.review.data.dao;

import io.incondensable.review.data.model.UserPurchasedProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPurchasedProductsDao extends JpaRepository<UserPurchasedProductsEntity, Long> {

    @Query("SELECT upp FROM UserPurchasedProductsEntity upp WHERE upp.user.id = :userId AND upp.product.id = :productId")
    List<UserPurchasedProductsEntity> findAllPurchasedProductsByUserIdAndProductId(
            @Param("userId") long userId,
            @Param("productId") long productId
    );

}
