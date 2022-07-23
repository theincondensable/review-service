package io.incondensable.review.domain.service.facade;

import io.incondensable.review.web.dto.ProductInformationDto;
import io.incondensable.review.web.dto.ProductResponseDto;
import io.incondensable.review.web.service.CommentService;
import io.incondensable.review.web.service.ProductService;
import io.incondensable.review.web.service.VoteService;
import io.incondensable.review.web.service.facade.ProductFacadeService;
import org.springframework.stereotype.Service;

@Service
public class ProductFacadeServiceImpl implements ProductFacadeService {

    private final ProductService productService;
    private final CommentService commentService;
    private final VoteService voteService;

    public ProductFacadeServiceImpl(ProductService productService, CommentService commentService, VoteService voteService) {
        this.productService = productService;
        this.commentService = commentService;
        this.voteService = voteService;
    }

    @Override
    public ProductInformationDto getReviewableProductInformation(Long productId) {
        ProductResponseDto product = productService.getProductById(productId);

        return new ProductInformationDto(
                product.getId(),
                product.getName(),
                commentService.getAllApprovedCommentsOfProduct(productId),
                voteService.getSumOfApprovedVotesOfProduct(productId)
        );
    }

}
