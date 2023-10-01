package com.example.graphql_tutorial.model;

import lombok.Data;
import org.springframework.graphql.data.GraphQlRepository;

@Data
public class Author {

    private String id;
    private String name;
    private String thumbnail;
}
