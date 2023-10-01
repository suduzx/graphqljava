package com.example.graphql_tutorial.exception;

import java.util.Map;

public class AlreadyPresentException extends AbstractGraphQLException{
    public AlreadyPresentException(String message) {
        super(message);
    }

    public AlreadyPresentException(String message, Map<String, Object> additionParams) {
        super(message, additionParams);
    }
}
