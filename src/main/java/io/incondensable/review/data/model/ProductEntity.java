package io.incondensable.review.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagerEntity manager;

    @Column(name = "is_review_available_for_all")
    private Byte isReviewAvailableForAll;

    @OneToMany(cascade = CascadeType.ALL)
    private List<VoteEntity> votes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public Byte getIsReviewAvailableForAll() {
        return isReviewAvailableForAll;
    }

    public void setIsReviewAvailableForAll(Byte isReviewAvailableForAll) {
        this.isReviewAvailableForAll = isReviewAvailableForAll;
    }

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

}
