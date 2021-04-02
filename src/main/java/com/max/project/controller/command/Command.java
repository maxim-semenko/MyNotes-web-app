package com.max.project.controller.command;

public interface Command {

    ResponseContext execute(RequestContext requestContext);

}
