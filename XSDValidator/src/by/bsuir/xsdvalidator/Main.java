package by.bsuir.xsdvalidator;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/**
 *
 * @author Ann
 */
public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args){
        String filename = "electricalappliances.xml";
        DOMParser parser = new DOMParser();
        try {
            // установка обработчика ошибок
            //parser.setErrorHandler(new MyErrorHandler("log.txt"));
            // установка способов проверки с использованием XSD
            parser.setFeature(
                    "http://xml.org/sax/features/validation", true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema", true);
            parser.parse(filename);
        } catch (SAXNotRecognizedException e) {
            log.error("идентификатор не распознан" + e.getMessage());
        } catch (SAXNotSupportedException e) {
            log.error("неподдерживаемая операция"  + e.getMessage());
        } catch (SAXException e) {
            log.error("глобальная SAX ошибка "  + e.getMessage());
        } catch (IOException e) {
            log.error("ошибка I/O потока"  + e.getMessage());
        }
        log.info("проверка " + filename + " завершена");
    }
}
