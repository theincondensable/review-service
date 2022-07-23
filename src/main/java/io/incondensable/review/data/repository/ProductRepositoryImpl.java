package io.incondensable.review.data.repository;

import io.incondensable.review.data.dao.ProductDao;
import io.incondensable.review.data.mapper.impl.ProductMapper;
import io.incondensable.review.domain.model.Product;
import io.incondensable.review.domain.repository.ProductRepository;
import io.incondensable.review.global.constants.Constants;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDao dao;
    private final ProductMapper mapper;

    public ProductRepositoryImpl(ProductDao dao, ProductMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getReviewableProducts() {
        return dao.findAllReviewableProducts(Constants.ProductStatus.REVIEWABLE.getValue())
                .stream()
                .map(mapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }

}
