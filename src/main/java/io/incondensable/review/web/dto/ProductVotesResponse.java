package io.incondensable.review.web.dto;

public class ProductVotesResponse {
    private Long productId;
    private String productDescription;
    private Integer productVoteScore;

    public ProductVotesResponse(Long productId, String productDescription, Integer productVoteScore) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.productVoteScore = productVoteScore;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductVoteScore() {
        return productVoteScore;
    }

    public void setProductVoteScore(Integer productVoteScore) {
        this.productVoteScore = productVoteScore;
    }

}
