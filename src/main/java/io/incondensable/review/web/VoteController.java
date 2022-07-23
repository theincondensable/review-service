package io.incondensable.review.web;

import io.incondensable.review.web.dto.ProductVotesDto;
import io.incondensable.review.web.service.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/votes")
@Tag(name = "Vote Controller", description = "Responsible for handling the Manager requests for Vote")
public class VoteController {

    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductVotesDto>> showProductAllVotes(@PathVariable Long productId) {
        return new ResponseEntity(service.getAllVotesOfProduct(productId), HttpStatus.OK);
    }

    @GetMapping("/approved/product/{productId}")
    public ResponseEntity<List<ProductVotesDto>> showProductAllApprovedVotes(@PathVariable Long productId) {
        return new ResponseEntity(service.getAllApprovedVotesOfProduct(productId), HttpStatus.OK);
    }

}
