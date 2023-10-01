package com.example.dgs_graphql.DA0;

import com.example.dgs_graphql.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDAO {

    private final List<Post> posts;

    public PostDAO(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count) {
        var data = posts.stream()
                .limit(count)
                .collect(Collectors.toList());
        return data;
    }

    public List<Post> getAuthorPosts(String author) {
        return posts.stream()
                .filter(post -> author.equals(post.getAuthorId()))
                .collect(Collectors.toList());
    }

    public void savePost(Post post) {
        posts.add(post);
    }
}
