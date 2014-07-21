package by.bsuir.parsersservlet.patternbuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.bsuir.parsersservlet.exceptions.TechnicalException;
import by.bsuir.parsersservlet.model.Flatiron;
import by.bsuir.parsersservlet.model.Fridge;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DOMParser extends BaseParser {

    static Logger log = Logger.getLogger(DOMParser.class);

    public void parseFlatirons(String filename) {

        File file = new File(filename);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = (Document) builder.parse(fis);
            Element root = (Element) document.getDocumentElement();
            NodeList flatironsList = root.getElementsByTagName("flatirons").item(0).getChildNodes();
            for (int i = 0; i < flatironsList.getLength(); ++i) {
                Node flatironNode = flatironsList.item(i);
                if (flatironNode instanceof Element) {

                    NamedNodeMap flatironNodeAttr = flatironNode.getAttributes();

                    Flatiron obj = new Flatiron();

                    // getting data from attributes
                    obj.setProducer(flatironNodeAttr.getNamedItem("producer").getNodeValue());
                    obj.setModel(flatironNodeAttr.getNamedItem("model").getNodeValue());

                    //getting data from child nodes
                    NodeList flatironChildNodes = flatironNode.getChildNodes();

                    int readedNodesCount = 0;
                    for (int j = 0; j < flatironChildNodes.getLength(); j++) {
                        Node flatironChildNode = flatironChildNodes.item(j);
                        if (flatironChildNode instanceof Element) {
                            if (readedNodesCount == 0) {
                                obj.setSoleplate(flatironChildNode.getTextContent());
                                readedNodesCount++;
                            } else if (readedNodesCount == 1) {
                                obj.setMaxPowerConsumption(Integer.parseInt(flatironChildNode.getTextContent()));
                                readedNodesCount++;
                            } else if (readedNodesCount == 2) {
                                obj.setWaterVolume(Integer.parseInt(flatironChildNode.getTextContent()));
                                readedNodesCount++;
                            }
                        }
                    }
                    flat.addElectricalAppliance(obj);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }


    public void parseFridges(String filename) {

        File file = new File(filename);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = (Document) builder.parse(fis);
                Element root = (Element) document.getDocumentElement();
                NodeList fridgesList = root.getElementsByTagName("fridges").item(0).getChildNodes();
                for (int i = 0; i < fridgesList.getLength(); ++i) {
                    Node fridgeNode = fridgesList.item(i);
                    if (fridgeNode instanceof Element) {
                        NamedNodeMap fridgeNodeAttr = fridgeNode.getAttributes();

                        Fridge obj = new Fridge();

                        // getting data from attributes
                        obj.setProducer(fridgeNodeAttr.getNamedItem("producer").getNodeValue());
                        obj.setModel(fridgeNodeAttr.getNamedItem("model").getNodeValue());

                        //getting data from child nodes
                        Node fridgeChildNode = fridgeNode.getFirstChild();

                        int readedNodesCount = 0;
                        while (fridgeChildNode != null) {
                            if (fridgeChildNode instanceof Element) {
                                if (readedNodesCount == 0) {
                                    obj.setMaxPowerConsumption(Integer.parseInt(fridgeChildNode.getFirstChild().getNodeValue()));
                                    readedNodesCount++;
                                }
                                else if (readedNodesCount == 1) {
                                    try {
                                        obj.setConsumptionClass(fridgeChildNode.getFirstChild().getNodeValue());
                                    } catch (TechnicalException e) {
                                        log.error(e.getMessage());
                                    }
                                    readedNodesCount++;
                                }
                                else if (readedNodesCount == 2) {
                                    obj.setVolume(Integer.parseInt(fridgeChildNode.getFirstChild().getNodeValue()));
                                    readedNodesCount++;
                                }
                            }
                            fridgeChildNode = fridgeChildNode.getNextSibling();
                        }
                        flat.addElectricalAppliance(obj);
                    }
                }
            } catch (ParserConfigurationException | SAXException | IOException  e) {
                log.error(e.getMessage());
            } finally {
            try {
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        }
}
