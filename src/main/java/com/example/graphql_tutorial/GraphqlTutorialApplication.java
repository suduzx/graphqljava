package com.example.graphql_tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.example.graphql_tutorial")
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class GraphqlTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlTutorialApplication.class, args);
    }

}
