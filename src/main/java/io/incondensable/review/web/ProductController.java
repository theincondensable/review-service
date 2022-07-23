package io.incondensable.review.web;

import io.incondensable.review.web.dto.ProductInformationDto;
import io.incondensable.review.web.dto.ProductResponseDto;
import io.incondensable.review.web.service.ProductService;
import io.incondensable.review.web.service.facade.ProductFacadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product Controller", description = "This controller handles requests for showing Products")
public class ProductController {

    private final ProductService service;
    private final ProductFacadeService productFacade;

    public ProductController(ProductService service, ProductFacadeService productFacade) {
        this.service = service;
        this.productFacade = productFacade;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> showAllReviewableProducts() {
        return new ResponseEntity<>(service.getAllProductsAvailableToReview(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductInformationDto> showReviewableProductInformation(@PathVariable Long productId) {
        return new ResponseEntity<>(productFacade.getReviewableProductInformation(productId), HttpStatus.OK);
    }

}
