package by.bsuir.xsdvalidator.parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.bsuir.xsdvalidator.exceptions.TechnicalException;
import by.bsuir.xsdvalidator.model.Flatiron;
import by.bsuir.xsdvalidator.model.Fridge;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DOMParser extends BaseParser {

    static Logger log = Logger.getLogger(DOMParser.class.getName());

    public void parseFlatirons(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = (Document) builder.parse(ClassLoader.getSystemResourceAsStream(filename));
            Element root = (Element) document.getDocumentElement();
            NodeList flatironsList = root.getElementsByTagName("flatirons").item(0).getChildNodes();
            for (int i = 0; i < flatironsList.getLength(); ++i) {
                Node flatironNode = flatironsList.item(i);
                NamedNodeMap flatironNodeAttr = flatironNode.getAttributes();

                Flatiron obj = new Flatiron();

                // getting data from attributes
                obj.setProducer(flatironNodeAttr.getNamedItem("producer").getNodeValue());
                obj.setModel(flatironNodeAttr.getNamedItem("model").getNodeValue());

                //getting data from child nodes
                Node flatironChildNode = flatironNode.getFirstChild();

                int readedNodesCount = 0;
                while( flatironChildNode != null) {
                    if (flatironChildNode instanceof Element)
                    {
                        if (readedNodesCount == 0) {
                            obj.setSoleplate(flatironChildNode.getFirstChild().getNodeValue());
                            readedNodesCount++;
                        }
                        if (readedNodesCount == 1) {
                            obj.setMaxPowerConsumption(Integer.parseInt(flatironChildNode.getFirstChild().getNodeValue()));
                            readedNodesCount++;
                        }
                        if (readedNodesCount == 2) {
                            obj.setWaterVolume(Integer.parseInt(flatironChildNode.getFirstChild().getNodeValue()));
                            readedNodesCount++;
                        }
                    }
                    flatironChildNode = flatironChildNode.getNextSibling();
                }
                flat.addElectricalAppliance(obj);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void parseFridges(String filename) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = (Document) builder.parse(ClassLoader.getSystemResourceAsStream(filename));
                Element root = (Element) document.getDocumentElement();
                NodeList fridgesList = root.getElementsByTagName("fridges").item(0).getChildNodes();
                for (int i = 0; i < fridgesList.getLength(); ++i) {
                    Node fridgeNode = fridgesList.item(i);
                    NamedNodeMap fridgeNodeAttr = fridgeNode.getAttributes();

                    Fridge obj = new Fridge();

                    // getting data from attributes
                    obj.setProducer(fridgeNodeAttr.getNamedItem("producer").getNodeValue());
                    obj.setModel(fridgeNodeAttr.getNamedItem("model").getNodeValue());

                    //getting data from child nodes
                    Node fridgeChildNode = fridgeNode.getFirstChild();

                    int readedNodesCount = 0;
                    while( fridgeChildNode != null) {
                        if (fridgeChildNode instanceof Element)
                        {
                            if (readedNodesCount == 0) {
                                obj.setMaxPowerConsumption(Integer.parseInt(fridgeChildNode.getFirstChild().getNodeValue()));
                                readedNodesCount++;
                            }
                            if (readedNodesCount == 1) {
                                try {
                                    obj.setConsumptionClass(fridgeChildNode.getFirstChild().getNodeValue());
                                } catch (TechnicalException e) {
                                    log.error(e.getMessage());
                                }
                                readedNodesCount++;
                            }
                            if (readedNodesCount == 2) {
                                obj.setVolume(Integer.parseInt(fridgeChildNode.getFirstChild().getNodeValue()));
                                readedNodesCount++;
                            }
                        }
                        fridgeChildNode = fridgeChildNode.getNextSibling();
                    }
                    flat.addElectricalAppliance(obj);
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
