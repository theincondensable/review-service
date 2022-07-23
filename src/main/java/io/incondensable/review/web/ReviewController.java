package io.incondensable.review.web;

import io.incondensable.review.web.dto.ProductWithVotesResponse;
import io.incondensable.review.web.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/reviews")
@Tag(name = "Review Controller", description = "Responsible for handling the User requests for Products, its Comments and Votes.")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductWithVotesResponse> getProductVotes(@PathVariable long productId) {
        return new ResponseEntity<>(reviewService.showProductsWithApprovedCommentsAndVotes(productId), HttpStatus.OK);
    }

}
