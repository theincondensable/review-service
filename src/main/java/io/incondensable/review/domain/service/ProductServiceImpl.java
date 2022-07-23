package io.incondensable.review.domain.service;

import io.incondensable.review.domain.model.Product;
import io.incondensable.review.domain.repository.ProductRepository;
import io.incondensable.review.web.dto.ProductResponseDto;
import io.incondensable.review.web.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductResponseDto> getAllProductsAvailableToReview() {
        List<Product> reviewableProducts = repository.getReviewableProducts();

        return createDto(reviewableProducts);
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        Product product = repository.getProductById(productId);

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getIsReviewAvailableForAll(),
                product.getManagerId()
        );
    }

    private List<ProductResponseDto> createDto(List<Product> input) {
        List<ProductResponseDto> response = new ArrayList<>();

        input.forEach(
                product -> response.add(
                        new ProductResponseDto(
                                product.getId(),
                                product.getName(),
                                product.getIsReviewAvailableForAll(),
                                product.getManagerId()
                        )
                )
        );

        return response;
    }

}
