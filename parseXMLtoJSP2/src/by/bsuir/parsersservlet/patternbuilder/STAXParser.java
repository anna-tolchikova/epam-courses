package by.bsuir.parsersservlet.patternbuilder;

import by.bsuir.parsersservlet.exceptions.NoSuchApplianceTypeException;
import by.bsuir.parsersservlet.exceptions.TechnicalException;
import by.bsuir.parsersservlet.model.Flatiron;
import by.bsuir.parsersservlet.model.Fridge;
import by.bsuir.parsersservlet.modelabstractions.ElectricalAppliance;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.EnumSet;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class STAXParser extends BaseParser {

    private static Logger log = Logger.getLogger(STAXParser.class);

    private XMLInputFactory inputFactory;
    private EnumSet<FlatironEnum> flatironInfo;
    private EnumSet<FridgeEnum> fridgeInfo;

    public STAXParser() {
        this.inputFactory = XMLInputFactory.newInstance();
        flatironInfo = EnumSet.range(FlatironEnum.SOLEPLATE, FlatironEnum.WATER_VOLUME);
        fridgeInfo = EnumSet.range(FridgeEnum.POWER, FridgeEnum.VOLUME);
    }

    @Override
    public void parseFlatirons(String fileName) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(new File(fileName));
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if ("flatiron".equals(name)) {
                        Flatiron obj = (Flatiron) buildElectricalAppliance(reader, "flatirons");
                        flat.addElectricalAppliance(obj);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException | NoSuchApplianceTypeException e) {
            log.error(e.getMessage());
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public void parseFridges(String fileName) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(new File(fileName));
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if ("fridge".equals(name)) {
                        Fridge obj = (Fridge) buildElectricalAppliance(reader, "fridges");
                        flat.addElectricalAppliance(obj);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException | NoSuchApplianceTypeException e) {
            log.error(e.getMessage());
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }


    private ElectricalAppliance buildElectricalAppliance(XMLStreamReader reader, String applianceName) throws NoSuchApplianceTypeException {


        if ("flatirons".equals(applianceName)) {
            Flatiron obj = new Flatiron();

            obj.setProducer(reader.getAttributeValue(null, FlatironEnum.PRODUCER.getXmlInfo()));
            obj.setModel(reader.getAttributeValue(null, FlatironEnum.MODEL.getXmlInfo()));

            String name;
            try {
                while (reader.hasNext()) {
                    int type = reader.next();
                    switch (type) {
                        case XMLStreamConstants.START_ELEMENT:
                            name = reader.getLocalName();
                            switch (FlatironEnum.valueOf(name.toUpperCase())) {
                                case SOLEPLATE:
                                    obj.setSoleplate(getXMLText(reader));
                                    break;
                                case FLATIRON_POWER:
                                    name = getXMLText(reader);
                                    obj.setMaxPowerConsumption(Integer.parseInt(name));
                                    break;
                                case WATER_VOLUME:
                                    name = getXMLText(reader);
                                    obj.setWaterVolume(Integer.parseInt(name));
                                    break;
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            name = reader.getLocalName();
                            if (FlatironEnum.valueOf(name.toUpperCase()) ==
                                    FlatironEnum.FLATIRON) {
                                return obj;
                            }
                            break;
                    }
                }
            } catch (XMLStreamException e) {
                log.error(e.getMessage());
            }

        } else if ("fridges".equals(applianceName)) {
            Fridge obj = new Fridge();

            obj.setProducer(reader.getAttributeValue(null, FridgeEnum.PRODUCER.getXmlInfo()));
            obj.setModel(reader.getAttributeValue(null, FridgeEnum.MODEL.getXmlInfo()));

            String name;
            try {
                while (reader.hasNext()) {
                    int type = reader.next();
                    switch (type) {
                        case XMLStreamConstants.START_ELEMENT:
                            name = reader.getLocalName();
                            switch (FridgeEnum.valueOf(name.toUpperCase())) {
                                case POWER:
                                    name = getXMLText(reader);
                                    obj.setMaxPowerConsumption(Integer.parseInt(name));
                                    break;
                                case POWER_CONSUMPTION_CLASS:
                                    try {
                                        obj.setConsumptionClass(getXMLText(reader));
                                    } catch (TechnicalException e) {
                                        log.error(e.getMessage());
                                    }
                                    break;
                                case VOLUME:
                                    name = getXMLText(reader);
                                    obj.setVolume(Integer.parseInt(name));
                                    break;
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            name = reader.getLocalName();
                            if (FridgeEnum.valueOf(name.toUpperCase()) ==
                                    FridgeEnum.FRIDGE) {
                                return obj;
                            }
                            break;
                    }
                }
            } catch (XMLStreamException e) {
                log.error(e.getMessage());
            }

        } else
            throw new NoSuchApplianceTypeException("There is no such electrical appliance type in xml : " + applianceName);

        return null;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
