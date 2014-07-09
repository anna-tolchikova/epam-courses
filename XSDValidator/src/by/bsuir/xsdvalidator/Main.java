package by.bsuir.xsdvalidator;


import by.bsuir.xsdvalidator.exceptions.TechnicalException;
import by.bsuir.xsdvalidator.factorymethod.Creator;
import by.bsuir.xsdvalidator.factorymethod.FlatironCreator;
import by.bsuir.xsdvalidator.factorymethod.FridgeCreator;
import by.bsuir.xsdvalidator.model.Flat;
import by.bsuir.xsdvalidator.model.Fridge;
import by.bsuir.xsdvalidator.modelabstractions.ElectricalAppliance;
import by.bsuir.xsdvalidator.modellogic.FlatLogic;
import by.bsuir.xsdvalidator.modellogic.FlatSearch;
import by.bsuir.xsdvalidator.modellogic.FlatSorting;
import by.bsuir.xsdvalidator.parsers.Director;
import by.bsuir.xsdvalidator.parsers.SAXParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
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
    static Properties prop = new Properties();

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
        try {
            prop.load(new InputStreamReader(new FileInputStream("src" + File.separatorChar + "resources" + File.separatorChar + "properties.properties"),"UTF-8"));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
    }

    public static void main(String[] args){

        String filename = prop.getProperty("xmlDataFileName");
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
            log.error("идентификатор не распознан " + e.getMessage());
        } catch (SAXNotSupportedException e) {
            log.error("неподдерживаемая операция "  + e.getMessage());
        } catch (SAXException e) {
            log.error("глобальная SAX ошибка "  + e.getMessage());
        } catch (IOException e) {
            log.error("ошибка I/O потока "  + e.getMessage());
        }
        log.info("проверка " + filename + " завершена");

        Director DOMdirector = new Director(new by.bsuir.xsdvalidator.parsers.DOMParser());
        //Director SAXdirector = new Director(new by.bsuir.xsdvalidator.parsers.SAXParser());

        // build Flat with builder
        String f = "../../../../../" + filename;
        log.info(f);

        DOMdirector.constructFlat(f);

//        SAXdirector.constructFlat(filename);

        Flat DOMflat = DOMdirector.getFlat();
//        Flat SAXflat = SAXdirector.getFlat();

        log.info("Flat, parsed with DOM:\n" + DOMflat);
//        log.info("Flat, parsed with SAX:\n" + SAXflat);

//
//
//        public class BookMain {
//
//            private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";
//
//            public static void main(String[] args) throws JAXBException, IOException {
//
//                ArrayList<Book> bookList = new ArrayList<Book>();
//
//                // create books
//                Book book1 = new Book();
//                book1.setIsbn("978-0060554736");
//                book1.setName("The Game");
//                book1.setAuthor("Neil Strauss");
//                book1.setPublisher("Harpercollins");
//                bookList.add(book1);
//
//                Book book2 = new Book();
//                book2.setIsbn("978-3832180577");
//                book2.setName("Feuchtgebiete");
//                book2.setAuthor("Charlotte Roche");
//                book2.setPublisher("Dumont Buchverlag");
//                bookList.add(book2);
//
//                // create bookstore, assigning book
//                Bookstore bookstore = new Bookstore();
//                bookstore.setName("Fraport Bookstore");
//                bookstore.setLocation("Frankfurt Airport");
//                bookstore.setBookList(bookList);
//
//                // create JAXB context and instantiate marshaller
//                JAXBContext context = JAXBContext.newInstance(Bookstore.class);
//                Marshaller m = context.createMarshaller();
//                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//                // Write to System.out
//                m.marshal(bookstore, System.out);
//
//                // Write to File
//                m.marshal(bookstore, new File(BOOKSTORE_XML));
//
//                // get variables from our xml file, created before
//                System.out.println();
//                System.out.println("Output from our XML File: ");
//                Unmarshaller um = context.createUnmarshaller();
//                Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));
//                ArrayList<Book> list = bookstore2.getBooksList();
//                for (Book book : list) {
//                    System.out.println("Book: " + book.getName() + " from "
//                            + book.getAuthor());
//                }
//            }
//        }





    }
}
