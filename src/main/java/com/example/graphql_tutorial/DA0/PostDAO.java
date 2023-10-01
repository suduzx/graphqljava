package com.example.graphql_tutorial.DA0;

import com.example.graphql_tutorial.exception.AlreadyPresentException;
import com.example.graphql_tutorial.exception.HandleExceptionGraphql;
import com.example.graphql_tutorial.model.Post;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@GraphQlRepository
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

    public List<Post> getPosts(String id) {
        if (id.equals("aaa")) {
            var post = posts.stream()
                    .filter(item -> id.equals(item.getId()))
                    .collect(Collectors.toList());
            Map<String, Post> params = new HashMap<>();
            Map<String, Object> convertedMap = new HashMap<>();

            Post post1 = new Post();
            post1.setId("acz");
            post1.setTitle("ttt");
            post1.setText("text");
            params.put("id ",post1 );
            for (Map.Entry<String, Post> entry : params.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                convertedMap.put(key, value);
            }
            throw new AlreadyPresentException("Failed to get vehicle. Vehicle with vin already present.", convertedMap);
        } else {
            return  posts.stream()
                    .filter(item -> id.equals(item.getId()))
                    .collect(Collectors.toList());
        }

    }
}
