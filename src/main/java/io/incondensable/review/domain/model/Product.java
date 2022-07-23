package io.incondensable.review.domain.model;

public class Product {
    private Long id;
    private String name;
    private Byte isReviewAvailableForAll;
    private Long managerId;

    public Product() {
    }

    public Product(Long id, String name, Byte isReviewAvailableForAll, Long managerId) {
        this.id = id;
        this.name = name;
        this.isReviewAvailableForAll = isReviewAvailableForAll;
        this.managerId = managerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getIsReviewAvailableForAll() {
        return isReviewAvailableForAll;
    }

    public void setIsReviewAvailableForAll(Byte isReviewAvailableForAll) {
        this.isReviewAvailableForAll = isReviewAvailableForAll;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
