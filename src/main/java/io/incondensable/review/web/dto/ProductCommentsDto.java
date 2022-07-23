package io.incondensable.review.web.dto;

public class ProductCommentsDto {

    private Long id;
    private String context;
    private Long productId;

    public ProductCommentsDto(Long id, String context, Long productId) {
        this.id = id;
        this.context = context;
        this.productId = productId;
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

}
