package io.incondensable.review.web;

import io.incondensable.review.web.service.ManagerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    private final ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @PutMapping("/comment/approve")
    public void approveComment(@RequestParam Long managerId, @RequestParam Long commentId) {
        service.approveComment(managerId, commentId);
    }

    @PutMapping("/vote/approve")
    public void approveVote(@RequestParam Long managerId, @RequestParam Long voteId) {
        service.approveVote(managerId, voteId);
    }

}
