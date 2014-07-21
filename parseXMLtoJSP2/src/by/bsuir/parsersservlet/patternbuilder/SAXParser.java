package by.bsuir.parsersservlet.patternbuilder;

import by.bsuir.parsersservlet.exceptions.SAXTerminatorException;
import by.bsuir.parsersservlet.exceptions.TechnicalException;
import by.bsuir.parsersservlet.model.Flatiron;
import by.bsuir.parsersservlet.model.Fridge;
import by.bsuir.parsersservlet.modelabstractions.ElectricalAppliance;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.util.EnumSet;

public class SAXParser extends BaseParser {

    static Logger log = Logger.getLogger(SAXParser.class);
    private Handler handler;



    public class Handler extends DefaultHandler {

        private ElectricalAppliance electricalAppliance;
        private EnumSet<FlatironEnum> flatironInfo;
        private EnumSet<FridgeEnum> fridgeInfo;
        private FlatironEnum currentFlatironEnum;
        private FridgeEnum currentFridgeEnum;
        private String classForParsing;

        public Handler() {
            flatironInfo = EnumSet.range(FlatironEnum.SOLEPLATE, FlatironEnum.WATER_VOLUME);
            fridgeInfo = EnumSet.range(FridgeEnum.POWER, FridgeEnum.VOLUME);
        }

        public void setClassForParsing(String classForParsing) {
            this.classForParsing = classForParsing;
        }

        @Override
        public void startDocument() throws SAXException {
            log.info("Start parse XML...");
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) throws SAXException {

//            log.info("start = " + localName);

            if ("flatirons".equals(classForParsing)) {
                if ("flatiron".equals(localName)) {
                    electricalAppliance = new Flatiron();
                    electricalAppliance.setProducer(attrs.getValue(1));
                    electricalAppliance.setModel(attrs.getValue(2));
                } else if(this.contains("flatirons", localName)){
                    FlatironEnum temp = FlatironEnum.valueOf(localName.toUpperCase());
                    if (flatironInfo.contains(temp)) {
                        currentFlatironEnum = temp;
                    }
                }
            }

            else if ("fridges".equals(classForParsing)) {
                if ("fridge".equals(localName)) {
                    electricalAppliance = new Fridge();
                    electricalAppliance.setProducer(attrs.getValue(1));
                    electricalAppliance.setModel(attrs.getValue(2));
                } else if(this.contains("fridges", localName)){
                    electricalAppliance = new Fridge();
                    FridgeEnum temp = FridgeEnum.valueOf(localName.toUpperCase());
                    if (fridgeInfo.contains(temp)) {
                        currentFridgeEnum = temp;
                    }
                }
            }


        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if ("flatirons".equals(classForParsing)) {

                String xmlInfo = new String(ch, start, length).trim();
                if (currentFlatironEnum != null) {
                    switch (currentFlatironEnum) {
                        case SOLEPLATE:
                            ((Flatiron) electricalAppliance).setSoleplate(xmlInfo);
                            break;
                        case FLATIRON_POWER:
                            ((Flatiron) electricalAppliance).setMaxPowerConsumption(Integer.parseInt(xmlInfo));
                            break;
                        case WATER_VOLUME:
                            ((Flatiron) electricalAppliance).setWaterVolume(Integer.parseInt(xmlInfo));
                            break;
                        default:
                            throw new EnumConstantNotPresentException(
                                    currentFlatironEnum.getDeclaringClass(), currentFlatironEnum.name());
                    }
                }
                currentFlatironEnum = null;
            }

            else if ("fridges".equals(classForParsing)) {

                String xmlInfo = new String(ch, start, length).trim();
                if (currentFridgeEnum != null) {
                    switch (currentFridgeEnum) {
                        case POWER:
                            ((Fridge) electricalAppliance).setMaxPowerConsumption(Integer.parseInt(xmlInfo));
                            break;
                        case POWER_CONSUMPTION_CLASS:
                            try {
                                ((Fridge) electricalAppliance).setConsumptionClass(xmlInfo);
                            } catch (TechnicalException e) {
                                log.error(e.getMessage());
                            }
                            break;
                        case VOLUME:
                            ((Fridge) electricalAppliance).setVolume(Integer.parseInt(xmlInfo));
                            break;
                        default:
                            throw new EnumConstantNotPresentException(
                                    currentFridgeEnum.getDeclaringClass(), currentFridgeEnum.name());
                    }
                }
                currentFridgeEnum = null;
            }

        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

            if ("flatirons".equals(classForParsing)) {

                if ("flatirons".equals(localName)) {
                    throw new SAXTerminatorException("End parsing of electrical appliances:" + classForParsing);
                }

                else if ("flatiron".equals(localName)) {
                    flat.addElectricalAppliance(electricalAppliance);
                }
            }

            else if ("fridges".equals(classForParsing)) {

                if ("fridges".equals(localName)) {
                    throw new SAXTerminatorException("End parsing of electrical appliances:" + classForParsing);
                }

                if ("fridge".equals(localName)) {
                    flat.addElectricalAppliance(electricalAppliance);
                }
            }
        }

        @Override
        public void endDocument() {
            log.info("End parse XML.");
        }

        private boolean contains(String where, String value) {

            boolean contains = false;

            switch(where) {
                case "fridges" :
                    for (FridgeEnum fe: fridgeInfo) {
                        if(fe.getXmlInfo().equals(value)) {
                            contains = true;
                            break;
                        }
                    }
                    break;
                case "flatirons" :
                    for (FlatironEnum fe: flatironInfo) {
                        if(fe.getXmlInfo().equals(value)) {
                            contains = true;
                            break;
                        }
                    }
                    break;
                default:
                    log.error("There is no available group");
            }
            return contains;
        }
    }

    public SAXParser() {
        handler = new Handler();
    }

    public void parseFlatirons(String filename) {

        XMLReader reader = null;
        File f = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            handler.setClassForParsing("flatirons");
            reader.setContentHandler(handler);
            f = new File(filename);
            reader.parse(new InputSource(new InputStreamReader(new FileInputStream(f))));
        } catch (SAXException | IOException e) {
            log.error(e.getMessage());
        }

    }

    public void parseFridges(String filename) {

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            handler.setClassForParsing("fridges");
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new InputStreamReader(new FileInputStream(new File(filename)))));
        } catch (SAXException | IOException e) {
            log.error(e.getMessage());
        }


    }

}
