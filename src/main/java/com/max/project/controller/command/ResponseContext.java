package com.max.project.controller.command;

public interface ResponseContext {

    enum ResponseType {
        FORWARD,
        REDIRECT
    }

    String getPage();

    ResponseType getResponseType();

}
