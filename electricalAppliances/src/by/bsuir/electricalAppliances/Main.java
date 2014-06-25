package by.bsuir.electricalappliances;

import by.bsuir.electricalappliances.builder.Director;
import by.bsuir.electricalappliances.builder.ConcreteBuilder;
import by.bsuir.electricalappliances.exceptions.LogicalException;
import by.bsuir.electricalappliances.exceptions.TechnicalException;
import by.bsuir.electricalappliances.factoryMethod.Creator;
import by.bsuir.electricalappliances.factoryMethod.FlatironCreator;
import by.bsuir.electricalappliances.factoryMethod.FridgeCreator;
import by.bsuir.electricalappliances.model.Flat;
import by.bsuir.electricalappliances.model.Fridge;
import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
import java.util.logging.Logger;
import by.bsuir.electricalappliances.modelLogic.FlatLogic;
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

        FlatSorting flatSorting = new FlatSorting();
        log.info("Flat before sorting :\n" + flat);
        flatSorting.sortAppliancesByPowerASC(flat);
        log.info("Flat after sorting :\n" + flat);

        FlatLogic flatLogic = new FlatLogic();
        log.info("Total power in flat (default) = " + flatLogic.calculateTotalPower(flat));
        flatLogic.switchOnFlatiron(flat);
        log.info("Total power in flat (with working flatiron) = " + flatLogic.calculateTotalPower(flat));

        //demonstration of incorrect parameters by creating Fridge objects
        try {
                Fridge fridge = (Fridge) fridgeCreator.factoryMethod(); //???????
                fridge.setMaxPowerConsumption(1000); // class D
                fridge.setConsumptionClass("B");
        } catch (TechnicalException ex) {
            log.log(Level.SEVERE, ex.getMessage());
        }

    }
}
