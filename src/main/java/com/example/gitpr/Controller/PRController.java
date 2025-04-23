package com.example.gitpr.Controller;

import com.example.gitpr.Model.ItemsDto;
import com.example.gitpr.Service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gitpr.Model.PR;
import java.util.List;

@RequestMapping
@RestController
public class PRController {

    private final GithubService gitHubService;

    @Autowired
    PRController(GithubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/prs")
    public ResponseEntity<List<ItemsDto>> getPRs() throws Exception {
        return ResponseEntity.ok(gitHubService.getpr());
    }
}