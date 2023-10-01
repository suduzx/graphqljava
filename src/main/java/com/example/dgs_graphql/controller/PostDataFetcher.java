package com.example.dgs_graphql.controller;

import com.example.dgs_graphql.DA0.AuthorDAO;
import com.example.dgs_graphql.DA0.PostDAO;
import com.example.dgs_graphql.model.Author;
import com.example.dgs_graphql.model.Post;
import com.example.dgs_graphql.model.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class PostDataFetcher {

    private final PostDAO postDao;
    private final AuthorDAO authorDao;

    public PostDataFetcher(PostDAO postDao, AuthorDAO authorDao) {
        this.postDao = postDao;
        this.authorDao = authorDao;
    }

    @DgsQuery
    public List<Post> recentPosts(@InputArgument int count) {
        return postDao.getRecentPosts(count);
    }

    @DgsData(parentType = "Post")
    public Author author(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

}
