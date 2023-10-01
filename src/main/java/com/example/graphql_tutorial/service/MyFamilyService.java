//package com.example.graphql_tutorial.service;
//
//import com.example.graphql_tutorial.model.Customer;
//import com.example.graphql_tutorial.model.MyFamily;
//import com.example.graphql_tutorial.model.Post;
//import com.example.graphql_tutorial.repository.MyFamilyRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class MyFamilyService {
//
//    private final MyFamilyRepository myFamilyRepository;
//
//    @Autowired
//    public MyFamilyService(MyFamilyRepository myFamilyRepository) {
//        this.myFamilyRepository = myFamilyRepository;
//    }
//
//    public List<Customer> getAllFamilies() {
//        return myFamilyRepository
//                .deleteAll()
//                .thenMany(Flux.just("Josh", "Jürgen", "Dave", "Madhura", "Mark", "Yuxin")
//                        .map(name -> new Customer(null, name))
//                        .flatMap(myFamilyRepository::save))
//                .thenMany(myFamilyRepository.findAll())
//                .collectList()
//                .block();
//    }
//}
