package io.incondensable.review.domain.model;

public class Comment {
    private Long id;
    private String context;
    private Byte status;
    private Long productId;

    public Comment() {
    }

    private Comment(Long id, String context, Byte status, Long productId) {
        this.id = id;
        this.context = context;
        this.status = status;
        this.productId = productId;
    }

    public static Comment build(Long id, String context, Byte status, Long productId) {
        return new Comment(id, context, status, productId);
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

}
