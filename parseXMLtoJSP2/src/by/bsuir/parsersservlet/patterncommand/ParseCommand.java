package by.bsuir.parsersservlet.patterncommand;

import by.bsuir.parsersservlet.model.Flat;
import by.bsuir.parsersservlet.patternbuilder.Director;
import by.bsuir.parsersservlet.patterncommand.enums.ParseCommandEnum;
import by.bsuir.parsersservlet.resourceManagers.ConfigurationManager;
import by.bsuir.parsersservlet.resourceManagers.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ParseCommand implements ActionCommand {
    static Logger log = Logger.getLogger(ParseCommand.class);


    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String filename = ConfigurationManager.getProperty("path.xml.xmldata");
        filename = request.getSession().getServletContext().getRealPath("") + filename ;
        System.out.println("FILENAME =" + filename);
        String parserType = request.getParameter("command");
        Director currentDirector;
        try {                                               // получение объекта Director, соответствующего типу выбранного парсера
            ParseCommandEnum currentEnum = ParseCommandEnum.valueOf(parserType.toUpperCase());
            currentDirector = currentEnum.getDirector();
            currentDirector.constructFlat(filename);
            Flat flat = currentDirector.getFlat();
            request.setAttribute("electricalAppliances", flat.getElectricalAppliances());
            page = ConfigurationManager.getProperty("path.page.main");
        } catch (IllegalArgumentException e) {
            page = ConfigurationManager.getProperty("path.page.main");
            request.setAttribute("wrongParserType", parserType
                    + MessageManager.getProperty("message.wrongparsertype"));
            return page;            // чтобы вернуться на эту же страницу
        }
        return page;
    }
}
