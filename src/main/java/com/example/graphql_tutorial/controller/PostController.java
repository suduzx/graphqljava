package com.example.graphql_tutorial.controller;


import com.example.graphql_tutorial.DA0.AuthorDAO;
import com.example.graphql_tutorial.DA0.PostDAO;
import com.example.graphql_tutorial.model.Author;
import com.example.graphql_tutorial.model.Post;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class PostController {

    private final PostDAO postDao;
    private final AuthorDAO authorDao;

    public PostController(PostDAO postDao, AuthorDAO authorDao) {
        this.postDao = postDao;
        this.authorDao = authorDao;
    }

    @QueryMapping
    public List<Post> recentPosts(@Argument int count) {
        return postDao.getRecentPosts(count);
    }

    @SchemaMapping
    public Author author(Post post) {
        System.out.println("get author ");
        return authorDao.getAuthor(post.getAuthorId());
    }

    @SchemaMapping(typeName="Post", field="first_author")
    public Author getFirstAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String text,
                           @Argument String category, @Argument String authorId) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);
        postDao.savePost(post);

        return post;
    }

}

