package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;

public class TestCommand implements Command {


    private static final ResponseContext REDIRECT
            = new ResponseContextImpl(PathToPages.HOME_REDIRECT, ResponseContext.ResponseType.REDIRECT);



    @Override
    public ResponseContext execute(RequestContext requestContext) {
        String num1 = requestContext.getParamMap().get("num1");
        String num2 = requestContext.getParamMap().get("num2");

        requestContext.setAttribute("num1", num1);
        requestContext.setAttribute("num2", num2);
        requestContext.setAttribute("result", Integer.parseInt(num1) + Integer.parseInt(num2));
//        if ((Integer.parseInt(num1) + Integer.parseInt(num2)) == 10) {
//            return REDIRECT;
//        }


        System.out.println("BBBBBBBBBBBBBBBb");
        return null;
    }
}
