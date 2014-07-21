package by.bsuir.parsersservlet.patterncommand;

import by.bsuir.parsersservlet.logic.LoginLogic;
import by.bsuir.parsersservlet.resourceManagers.ConfigurationManager;
import by.bsuir.parsersservlet.resourceManagers.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        System.out.println("Login = " + login + " Pass = " + pass);
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
