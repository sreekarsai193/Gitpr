package Old.Controller;

import com.example.gitpr.service.old.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gitpr.Model.old.PRModel;

import java.util.List;

@RequestMapping
@RestController
public class GetcommitsController {
    private final GitHubService gitHubService;

    @Autowired
    public GetcommitsController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }
//    @GetMapping("/getCommits")
//    public List<RepoObject> getCommits(){
//        return gitHubService.CalculateOpenSourceRepos();
//    }
    @GetMapping("/getCommits")
    public List<PRModel> getPRs() throws Exception{
        return gitHubService.getCommitsFromAuthor();
    }


    @GetMapping("/getprs")
    public List<PRModel> getPRsFromAuthor() throws Exception{
        return gitHubService.searchRepos();
    }



}
