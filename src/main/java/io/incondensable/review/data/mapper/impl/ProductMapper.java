package io.incondensable.review.data.mapper.impl;

import io.incondensable.review.data.mapper.LocalMapper;
import io.incondensable.review.data.model.ProductEntity;
import io.incondensable.review.domain.model.Product;
import io.incondensable.review.global.annotations.Mapper;

@Mapper
public class ProductMapper implements LocalMapper<ProductEntity, Product> {

    @Override
    public Product mapEntityToDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getIsReviewAvailableForAll(),
                entity.getManager().getId()
        );
    }

    @Override
    public ProductEntity mapDomainToEntity(Product domain) {
        return null;
    }

}
