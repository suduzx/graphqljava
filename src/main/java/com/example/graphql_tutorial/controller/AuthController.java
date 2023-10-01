package com.example.graphql_tutorial.controller;

import com.example.graphql_tutorial.DA0.AuthorDAO;
import com.example.graphql_tutorial.DA0.PostDAO;
import com.example.graphql_tutorial.model.Author;
import com.example.graphql_tutorial.model.Post;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AuthController {

    private final PostDAO postDao;
    private final AuthorDAO authorDAO;

    public AuthController(PostDAO postDao, AuthorDAO authorDAO) {
        this.postDao = postDao;
        this.authorDAO = authorDAO;
    }

    @SchemaMapping
    public List<Post> posts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }

    @QueryMapping
    public Author findAuthor(@Argument String idAuthor) {
        Author author = authorDAO.getAuthor(idAuthor);
        return author;
    }
}
