package io.incondensable.review.web.dto;

public class ProductVotesDto {

    private Long id;
    private Byte score;
    private Long productId;

    public ProductVotesDto(Long id, Byte score, Long productId) {
        this.id = id;
        this.score = score;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
