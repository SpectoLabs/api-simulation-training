package io.specto;

public class Comment {

    private String postId;
    private String id;
    private String email;
    private String body;

    public Comment() {
    }

    public Comment(String postId, String id, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.email = email;
        this.body = body;
    }

    public String getPostId() {
        return postId;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
