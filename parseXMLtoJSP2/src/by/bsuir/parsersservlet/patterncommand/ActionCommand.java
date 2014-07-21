package by.bsuir.parsersservlet.patterncommand;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    String execute(HttpServletRequest request);

}
