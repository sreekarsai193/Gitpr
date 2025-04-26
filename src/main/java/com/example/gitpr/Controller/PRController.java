package com.example.gitpr.Controller;

import com.example.gitpr.Model.ItemsDto;
import com.example.gitpr.Service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gitpr.Model.PR;
import java.util.List;

@RequestMapping
@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class PRController {

    private final GithubService gitHubService;

    @Autowired
    PRController(GithubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/prs/{username}")
    public ResponseEntity<List<ItemsDto>> getPRs(@PathVariable String username) throws Exception {
        return ResponseEntity.ok(gitHubService.getpr(username));
    }
}