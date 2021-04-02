package com.max.project.controller.command;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface RequestContext {

    List<String> getParamList();

    Map<String, String> getParamMap();

    void setAttribute(String name, Object attr);

    HttpSession getHttpSession();
}
