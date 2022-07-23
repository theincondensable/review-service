package io.incondensable.review.web.dto;

public class ProductCommentsDto {

    private Long id;
    private String context;
    private Long productId;
    private Long userId;

    public ProductCommentsDto(Long id, String context, Long productId, Long userId) {
        this.id = id;
        this.context = context;
        this.productId = productId;
        this.userId = userId;
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
