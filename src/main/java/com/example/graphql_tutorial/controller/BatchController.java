package com.example.graphql_tutorial.controller;

import com.example.graphql_tutorial.DA0.AuthorDAO;
import com.example.graphql_tutorial.DA0.PostDAO;
import com.example.graphql_tutorial.model.Author;
import com.example.graphql_tutorial.model.Post;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BatchController {

    private final PostDAO postDao;
    private final AuthorDAO authorDao;

    public BatchController(PostDAO postDao, AuthorDAO authorDao) {
        this.postDao = postDao;
        this.authorDao = authorDao;
    }
    @QueryMapping
        public List<Post> postsBatching(@Argument String idPost) {
        return postDao.getPosts(idPost);
    }

//    @BatchMapping(typeName = "Post", field = "author")
//    public Map<Post, Author> author(List<Post> post) {
//        System.out.println(" call get author");
//        return post
//                .stream()
//                .collect(Collectors.toMap(posts -> posts,
//                posts -> authorDao.getAuthor(posts.getAuthorId())));
//    }

}
