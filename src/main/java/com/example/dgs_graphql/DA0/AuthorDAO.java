package com.example.dgs_graphql.DA0;


import com.example.dgs_graphql.model.Author;

import java.util.List;

public class AuthorDAO {
    private final List<Author> authors;

    public AuthorDAO(List<Author> authors) {
        this.authors = authors;
    }

    public Author getAuthor(String id) {
        return authors.stream()
                .filter(author -> id.equals(author.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
