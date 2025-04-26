package com.example.gitpr.Service;

import com.example.gitpr.Model.ItemsDto;
import com.example.gitpr.Model.PR;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubService {

    RestClient restClient=RestClient.builder().build();


    public List<ItemsDto> getpr(String username) {
        PR pr= restClient.get()
                .uri("https://api.github.com/search/issues?q=author:"+username)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(PR.class);

        return Arrays.stream(pr.getItems()).
                map(item ->new ItemsDto(item.getTitle(),item.getName())).
                collect(Collectors.toList());

    }
}
