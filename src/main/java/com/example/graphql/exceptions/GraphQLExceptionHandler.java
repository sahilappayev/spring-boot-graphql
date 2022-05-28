package com.example.graphql.exceptions;


import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQLExceptionHandler {

    @ExceptionHandler({GraphQLException.class, RuntimeException.class})
    public ThrowableGraphQLError handle(RuntimeException e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(Exception.class)
    public ThrowableGraphQLError handle(Exception e) {
        return new ThrowableGraphQLError(e, "Internal Server Error!");
    }

}
