package io.incondensable.review.web.dto;

public class UserVoteRequestDto {
    private Long userId;
    private Long productId;
    private Byte voteScore;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Byte getVoteScore() {
        return voteScore;
    }

    public void setVoteScore(Byte voteScore) {
        this.voteScore = voteScore;
    }
}
