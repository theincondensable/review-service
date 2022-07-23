package io.incondensable.review.data.model;

import javax.persistence.*;

@Entity
@Table(name = "vote")
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score")
    private Byte score;

    @OneToOne
    @JoinColumn(name = "status")
    private VoteStatus status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

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

    public VoteStatus getStatus() {
        return status;
    }

    public void setStatus(VoteStatus status) {
        this.status = status;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
