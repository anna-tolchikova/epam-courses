package by.bsuir.parsersservlet;

import by.bsuir.parsersservlet.commandfactory.ActionFactory;
import by.bsuir.parsersservlet.patterncommand.ActionCommand;
import by.bsuir.parsersservlet.resourceManagers.ConfigurationManager;
import by.bsuir.parsersservlet.resourceManagers.MessageManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParsersServlet extends javax.servlet.http.HttpServlet {

    private static Logger log = Logger.getLogger(ParsersServlet.class);
    static {
        new DOMConfigurator().doConfigure("/xml/log4j.xml", LogManager.getLoggerRepository());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {


        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        page = command.execute(request);
                                                        // page = null; // поэксперементировать!
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
        else {
            // установка страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",  // ?? 1)устанавливаем атрибут в сессию, почему не просто в request? 2) всегда возвращаемся стартовую..если хочу на ту, откуда пришла?
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException e) {
            log.error(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException e) {
            log.error(e.getMessage());
        }
    }
}
