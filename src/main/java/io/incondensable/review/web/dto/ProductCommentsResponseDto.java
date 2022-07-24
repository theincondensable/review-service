package io.incondensable.review.web.dto;

public class ProductCommentsResponseDto {

    private Long id;
    private String context;
    private Long productId;
    private Long userId;
    private String status;

    public ProductCommentsResponseDto(Long id, String context, Long productId, Long userId, String status) {
        this.id = id;
        this.context = context;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
