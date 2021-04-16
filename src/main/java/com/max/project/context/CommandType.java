package com.max.project.context;

import com.max.project.controller.command.Command;
import com.max.project.controller.command.impl.AddNoteCommand;
import com.max.project.controller.command.impl.AdminCabinetPageCommand;
import com.max.project.controller.command.impl.AllUsersPageCommand;
import com.max.project.controller.command.impl.DeleteNoteCommand;
import com.max.project.controller.command.impl.DeleteUserCommand;
import com.max.project.controller.command.impl.EditNodeCommand;
import com.max.project.controller.command.impl.EditUserCommand;
import com.max.project.controller.command.impl.HomePageCommand;
import com.max.project.controller.command.impl.SignInPageCommand;
import com.max.project.controller.command.impl.SignInUserCommand;
import com.max.project.controller.command.impl.SignOutUserCommand;
import com.max.project.controller.command.impl.SignUpPageCommand;
import com.max.project.controller.command.impl.SignUpUserCommand;
import com.max.project.controller.command.impl.UserCabinetPageCommand;
import com.max.project.controller.command.impl.UserEditPageCommand;

public enum CommandType {

    HOME_PAGE("home", new HomePageCommand()),
    SIGN_IN_PAGE("signIn-page", new SignInPageCommand()),
    SIGN_UP_PAGE("signUp-page", new SignUpPageCommand()),
    SIGN_UP_USER("signUpUser", new SignUpUserCommand()),
    ADMIN_CABINET_PAGE("admin-cabinet", new AdminCabinetPageCommand()),
    SIGN_IN_USER("signInUser", new SignInUserCommand()),
    SIGN_OUT_USER("signOutUser", new SignOutUserCommand()),
    USER_CABINET_PAGE("user-cabinet", new UserCabinetPageCommand()),
    USER_EDIT_PAGE("user-edit", new UserEditPageCommand()),
    EDIT_USER("editUser", new EditUserCommand()),
    DELETE_USER("deleteUser", new DeleteUserCommand()),
    ADD_NOTE("addNote", new AddNoteCommand()),
    EDIT_NOTE("editNote", new EditNodeCommand()),
    DELETE_NOTE("deleteNote", new DeleteNoteCommand()),
    ALL_USERS_PAGE("all-users", new AllUsersPageCommand()),
    SEARCH_USER_PAGE("search-user", null);


    ///

    private final String url;
    private final Command command;

    CommandType(final String url, final Command command) {
        this.url = url;
        this.command = command;
    }

    public String getUrl() {
        return url;
    }

    public Command getCommand() {
        return command;
    }

}
