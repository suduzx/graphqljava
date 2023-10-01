//package com.example.graphql_tutorial.controller;
//
//import com.example.graphql_tutorial.DA0.AuthorDAO;
//import com.example.graphql_tutorial.DA0.PostDAO;
//import com.example.graphql_tutorial.model.Customer;
//import com.example.graphql_tutorial.model.MyFamily;
//import com.example.graphql_tutorial.model.Post;
//import com.example.graphql_tutorial.service.MyFamilyService;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller
//public class FamilyController {
//
//    private final MyFamilyService myFamilyService;
//
//    public FamilyController(MyFamilyService myFamilyService) {
//        this.myFamilyService = myFamilyService;
//    }
//    @QueryMapping
//    public List<Customer> getAllFamilies() {
//        return myFamilyService.getAllFamilies();
//    }
//
////    @BatchMapping(typeName = "Post", field = "author")
////    public Map<Post, Author> author(List<Post> post) {
////        System.out.println(" call get author");
////        return post
////                .stream()
////                .collect(Collectors.toMap(posts -> posts,
////                posts -> authorDao.getAuthor(posts.getAuthorId())));
////    }
//}
