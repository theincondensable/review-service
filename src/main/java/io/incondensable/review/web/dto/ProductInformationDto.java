package io.incondensable.review.web.dto;

import java.util.List;

public class ProductInformationDto {
    private Long productId;
    private String productName;
//    private ManagerDto manager;
    private List<ProductCommentsResponseDto> comments;
    private Integer votesScore;

    public ProductInformationDto(Long productId, String productName, List<ProductCommentsResponseDto> comments, Integer votesScore) {
        this.productId = productId;
        this.productName = productName;
//        this.manager = manager;
        this.comments = comments;
        this.votesScore = votesScore;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public ManagerDto getManager() {
//        return manager;
//    }

//    public void setManager(ManagerDto manager) {
//        this.manager = manager;
//    }

    public List<ProductCommentsResponseDto> getComments() {
        return comments;
    }

    public void setComments(List<ProductCommentsResponseDto> comments) {
        this.comments = comments;
    }

    public Integer getVotesScore() {
        return votesScore;
    }

    public void setVotesScore(Integer votesScore) {
        this.votesScore = votesScore;
    }

}
