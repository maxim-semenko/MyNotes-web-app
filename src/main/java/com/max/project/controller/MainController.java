package com.max.project.controller;

import com.max.project.controller.command.Command;
import com.max.project.controller.command.CommandFactory;
import com.max.project.controller.command.ResponseContext;
import com.max.project.controller.command.impl.CustomRequestContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controller")
public class MainController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final Command command = CommandFactory.getCommand(req.getParameter("command"));
        final ResponseContext responseContext = command.execute(new CustomRequestContext(req));

        if (responseContext.getResponseType() == ResponseContext.ResponseType.REDIRECT) {
            resp.sendRedirect(req.getServletContext().getContextPath() + responseContext.getPage());
        } else {
            req.getRequestDispatcher(responseContext.getPage()).forward(req, resp);
        }
    }
}
