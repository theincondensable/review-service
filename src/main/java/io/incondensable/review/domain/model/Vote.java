package io.incondensable.review.domain.model;

public class Vote {
    private Long id;
    private Byte score;
    private Byte status;
    private Long productId;
    private Long userId;

    private Vote(Byte score, Byte status, Long productId, Long userId) {
        this.score = score;
        this.status = status;
        this.productId = productId;
        this.userId = userId;
    }

    private Vote(Long id, Byte score, Byte status, Long productId, Long userId) {
        this.id = id;
        this.score = score;
        this.status = status;
        this.productId = productId;
        this.userId = userId;
    }

    public static Vote buildFromEntity(Long id, Byte score, Byte status, Long productId, Long userId) {
        return new Vote(id, score, status, productId, userId);
    }

    public static Vote buildFromDto(Byte score, Byte status, Long productId, Long userId) {
        return new Vote(score, status, productId, userId);
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
