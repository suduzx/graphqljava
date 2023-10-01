package com.example.graphql_tutorial.controller;

import com.example.graphql_tutorial.model.Account;
import com.example.graphql_tutorial.model.Customer;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
class AccountController {

    @BatchMapping
    Map<Customer, Account> account(List<Customer> customers) {
        var map = new HashMap<Customer, Account>();
        for (var c : customers)
            map.put(c, new Account(c.id()));
        return map;
    }

}
