package com.example.gitpr.Controllers;

import com.example.gitpr.service.GitHubService;
import com.example.gitpr.Model.RepoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gitpr.Model.PRModel;

import java.util.List;

@RequestMapping
@RestController
public class GetcommitsController {
    private final GitHubService gitHubService;

    @Autowired
    public GetcommitsController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }
    @GetMapping("/getCommits")
    public List<RepoObject> getCommits(){
        return gitHubService.GetCommits();
    }
    @GetMapping("/getPrs")
    public List<PRModel> getPRs() throws Exception{
        return gitHubService.getPrsFromOpenSource();
    }



}
