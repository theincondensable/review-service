package io.incondensable.review.web.dto;

public class ProductVotesDto {

    private Long id;
    private Byte score;
    private Long productId;
    private Long userId;

    public ProductVotesDto(Long id, Byte score, Long productId, Long userId) {
        this.id = id;
        this.score = score;
        this.productId = productId;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
