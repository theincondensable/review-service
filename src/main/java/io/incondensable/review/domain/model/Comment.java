package io.incondensable.review.domain.model;

public class Comment {
    private Long id;
    private String context;
    private Byte status;
    private Long productId;
    private Long userId;

    public Comment() {
    }

    private Comment(String context, Byte status, Long productId , Long userId) {
        this.context = context;
        this.status = status;
        this.productId = productId;
        this.userId = userId;
    }

    private Comment(Long id, String context, Byte status, Long productId, Long userId) {
        this.id = id;
        this.context = context;
        this.status = status;
        this.productId = productId;
        this.userId = userId;
    }

    public static Comment buildFromEntity(Long id, String context, Byte status, Long productId, Long userId) {
        return new Comment(id, context, status, productId, userId);
    }

    public static Comment buildFromDto(String context, Byte status, Long productId, Long userId) {
        return new Comment(context, status, productId, userId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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
