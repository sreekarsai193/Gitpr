package Old.Controller.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PRModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("user")
    private User user;
//    @JsonProperty("sha")
//    private String description;
//
//    @JsonProperty("commit")
//    private Commit commit;
//
//    public Commit getCommit() {
//        return commit;
//
//    }
public static class User {
    @JsonProperty("login")
    private String login;

    public String getLogin() {
        return login;
    }
}
public User getUser() {
    return user;
}

}
