package io.incondensable.review.web;

import io.incondensable.review.web.dto.ProductCommentsResponseDto;
import io.incondensable.review.web.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@Tag(name = "Comment Controller", description = "Responsible for handling the Manager requests for Comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductCommentsResponseDto>> showProductAllComments(@PathVariable Long productId) {
        return new ResponseEntity(service.getAllCommentsOfProduct(productId), HttpStatus.OK);
    }

    @GetMapping("/approved/product/{productId}")
    public ResponseEntity<List<ProductCommentsResponseDto>> showProductAllApprovedComments(@PathVariable Long productId) {
        return new ResponseEntity(service.getAllApprovedCommentsOfProduct(productId), HttpStatus.OK);
    }

}
