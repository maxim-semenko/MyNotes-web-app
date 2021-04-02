package com.max.project.context;

public class PathToPages {

    // Forward
    public static final String HOME_PAGE = "/WEB-INF/jsp/user/home.jsp";
    public static final String SIGN_IN_PAGE = "/WEB-INF/jsp/user/sign-in.jsp";
    public static final String SIGN_UP_PAGE = "/WEB-INF/jsp/user/sign-up.jsp";
    public static final String USER_CABINET_PAGE = "/WEB-INF/jsp/user/cabinet-user.jsp";
    public static final String USER_EDIT_PAGE = "/WEB-INF/jsp/user/cabinet-user-edit.jsp";
    public static final String ADMIN_CABINET_PAGE = "/WEB-INF/jsp/admin/cabinet-admin.jsp";


    // Redirect
    public static final String HOME_REDIRECT = "/controller?command=home";
    public static final String SIGN_IN_PAGE_REDIRECT = "/controller?command=signIn-page";
    public static final String USER_CABINET_PAGE_REDIRECT = "/controller?command=user-cabinet";
    public static final String ADMIN_CABINET_PAGE_REDIRECT = "/controller?command=admin-cabinet";
    public static final String USER_EDIT_PAGE_REDIRECT = "/controller?command=user-edit";


    public static final String TEST_REDIRECT = "/controller?command=signUp-page";

}
