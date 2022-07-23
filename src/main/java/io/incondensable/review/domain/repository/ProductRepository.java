package io.incondensable.review.domain.repository;

import io.incondensable.review.domain.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getReviewableProducts();

    Product getProductById(Long productId);

}
