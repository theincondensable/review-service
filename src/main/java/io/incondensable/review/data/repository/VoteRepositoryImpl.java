package io.incondensable.review.data.repository;

import io.incondensable.review.data.dao.VoteDao;
import io.incondensable.review.data.mapper.impl.VoteMapper;
import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.domain.repository.VoteRepository;
import io.incondensable.review.global.constants.Constants;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    private final VoteMapper mapper;
    private final VoteDao dao;

    public VoteRepositoryImpl(VoteMapper mapper, VoteDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }

    @Override
    public List<Vote> getVotesOfProduct(Long productId) {
        return dao.findAllVotesByProductId(productId)
                .stream()
                .map(mapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vote> getApprovedVotesOfProduct(Long productId) {
        return dao.findAllApprovedVotesByProductId(productId, Constants.VoteAndCommentStatus.APPROVED.getValue())
                .stream()
                .map(mapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }

}
