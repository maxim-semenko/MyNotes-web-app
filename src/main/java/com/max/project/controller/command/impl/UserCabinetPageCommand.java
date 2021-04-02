package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.entity.User;
import com.max.project.service.impl.NoteService;
import com.max.project.service.impl.UserService;

public class UserCabinetPageCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getHttpSession().getAttribute("user") != null) {
            User user = (User) requestContext.getHttpSession().getAttribute("user");
            requestContext.setAttribute("allUserNotes", NoteService.getInstance().selectAllByUserId(user.getId()));
        }
        return new ResponseContextImpl(PathToPages.USER_CABINET_PAGE, ResponseContext.ResponseType.FORWARD);
    }
}
