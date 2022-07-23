package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ReviewableProductResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReviewableProductResponseDto>> showAllReviewableProducts() {
        return new ResponseEntity<>(service.getAllProductsAvailableToReview(), HttpStatus.OK);
    }

}
