package io.specto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentsController {

    private RestTemplate restTemplate;

    @Autowired
    public CommentsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping
    public List<Comment> getComments() {
        ResponseEntity<List<Comment>> commentsResponse =
                restTemplate.exchange("https://jsonplaceholder.typicode.com/comments",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Comment>>() {
                        });
        return commentsResponse.getBody();
    }
}
