package io.incondensable.review.web.dto;

public class ProductVotesResponseDto {

    private Long id;
    private Byte score;
    private Long productId;
    private Long userId;
    private String status;

    public ProductVotesResponseDto(Long id, Byte score, Long productId, Long userId, String status) {
        this.id = id;
        this.score = score;
        this.productId = productId;
        this.userId = userId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
