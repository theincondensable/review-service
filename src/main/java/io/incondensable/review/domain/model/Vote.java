package io.incondensable.review.domain.model;

public class Vote {
    private Long id;
    private Byte score;
    private Byte status;
    private Long productId;

    public Vote(Long id, Byte score, Byte status, Long productId) {
        this.id = id;
        this.score = score;
        this.status = status;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
