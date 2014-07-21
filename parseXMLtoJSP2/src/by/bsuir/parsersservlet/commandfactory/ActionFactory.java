package by.bsuir.parsersservlet.commandfactory;

import by.bsuir.parsersservlet.patterncommand.ActionCommand;
import by.bsuir.parsersservlet.patterncommand.EmptyCommand;
import by.bsuir.parsersservlet.patterncommand.enums.CommandEnum;
import by.bsuir.parsersservlet.resourceManagers.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {           // если команда не задана в текущем запросе
            return current;
        }

        try {                                               // получение объекта, соответствующего команде
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}