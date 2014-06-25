package by.bsuir.electricalappliances;

import by.bsuir.electricalappliances.builder.Director;
import by.bsuir.electricalappliances.builder.ConcreteBuilder;
import by.bsuir.electricalappliances.exceptions.TechnicalException;
import by.bsuir.electricalappliances.factorymethod.Creator;
import by.bsuir.electricalappliances.factorymethod.FlatironCreator;
import by.bsuir.electricalappliances.factorymethod.FridgeCreator;
import by.bsuir.electricalappliances.model.Flat;
import by.bsuir.electricalappliances.model.Fridge;
import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
import java.util.logging.Logger;
import by.bsuir.electricalappliances.modelLogic.FlatLogic;
import by.bsuir.electricalappliances.modelLogic.FlatSearch;
import by.bsuir.electricalappliances.modelLogic.FlatSorting;
import java.util.ArrayList;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());

        // concrete creators
        Creator flatironCreator = new FlatironCreator();
        Creator fridgeCreator = new FridgeCreator();

        // concrete products from factory method
        ArrayList<ElectricalAppliance> newFlatirons = new ArrayList<ElectricalAppliance>();
        ArrayList<ElectricalAppliance> newFridges = new ArrayList<ElectricalAppliance>();

        //initialize array lists for builder

        try {
            for (int i = 0; i < 3; i++) {
                int newPowerConsumption = 2000 - 200 * i;
                ElectricalAppliance newFlatiron = flatironCreator.factoryMethod();
                newFlatiron.setMaxPowerConsumption(newPowerConsumption);
                newFlatirons.add(newFlatiron);

                newFridges.add(fridgeCreator.factoryMethod());
            }
        } catch (TechnicalException ex) {
            log.log(Level.SEVERE, ex.getMessage());
        }


        // build Flat with builder
        director.constructFlat(newFlatirons, newFridges); //first - flatirons, than - fridges

        Flat flat = director.getFlat();

        // sorting
        FlatSorting flatSorting = new FlatSorting();
        log.info("Flat before sorting :\n" + flat);
        flatSorting.sortAppliancesByMaxPower(flat);
        log.info("Flat after sorting by max power consumption:\n" + flat);

        // calculate total power of working appliances
        FlatLogic flatLogic = new FlatLogic();
        log.info("Total power in flat (default) = " + flatLogic.calculateTotalPower(flat));
        flatLogic.switchOnFlatiron(flat);
        flatLogic.switchOnFridge(flat);
        log.info("Total power in flat (with working flatiron and fridge) = " + flatLogic.calculateTotalPower(flat));

        // sorting by current power consumption
        flatSorting.sortAppliancesByCurrentPower(flat);
        log.info("Flat after sorting by current power consumption:\n" + flat);

        //search  by max consumption
        FlatSearch flatSearch = new FlatSearch();
        try {
            log.info(" electrical appliances in range of power consumption from 1700 to 2000 :\n" + flatSearch.findAppliancesByMaxPowerConsumpitonRange(flat, 1700, 2000));
        } catch (TechnicalException ex) {
           log.log(Level.SEVERE, ex.getMessage());
        }


        //demonstration of incorrect class parameter by creating Fridge object
        try {
                Fridge fridge = (Fridge) fridgeCreator.factoryMethod(); //???????
                fridge.setMaxPowerConsumption(1000); // class D
                fridge.setConsumptionClass("A");
        } catch (TechnicalException ex) {
            log.log(Level.SEVERE, ex.getMessage());
        }

        //demonstration of incorrect max power consumption parameter by creating Fridge object
        try {
                Fridge fridge = (Fridge) fridgeCreator.factoryMethod(); //???????
                fridge.setConsumptionClass("A"); // <=550
                fridge.setMaxPowerConsumption(1000); 
        } catch (TechnicalException ex) {
            log.log(Level.SEVERE, ex.getMessage());
        }

        //demonstration  of incorrect range by search
        try {
            log.info(" electrical appliances in range of current power consumption from 2000 to 1700 :\n" + flatSearch.findAppliancesByCurrentPowerConsumpitonRange(flat, 2000, 1700));
        } catch (TechnicalException ex) {
           log.log(Level.SEVERE, ex.getMessage());
        }



    }
}
