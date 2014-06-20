package by.bsuir.electricalAppliances;

import by.bsuir.electricalAppliances.builder.Director;
import by.bsuir.electricalAppliances.builder.ConcreteBuilder;
import by.bsuir.electricalAppliances.factoryMethod.Creator;
import by.bsuir.electricalAppliances.factoryMethod.FlatironCreator;
import by.bsuir.electricalAppliances.factoryMethod.FridgeCreator;
import by.bsuir.electricalAppliances.model.Flat;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.logging.Logger;
import by.bsuir.electricalAppliances.modelLogic.FlatLogic;
import by.bsuir.electricalAppliances.modelLogic.FlatSorting;
import java.util.ArrayList;
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
        for (int i = 0; i < 3 ; i++){
            int newPowerConsumption = 2000-200*i;

            ElectricalAppliance newFlatiron = flatironCreator.factoryMethod();
            newFlatiron.setMaxPowerConsumption(newPowerConsumption);
            
            newFlatirons.add(newFlatiron);
            newFridges.add(fridgeCreator.factoryMethod());
        }

        // build Flat
        director.constructFlat(newFlatirons, newFridges); //first - flatirons, than - fridges
       
        Flat flat = director.getFlat();
        
        FlatSorting flatSorting = new FlatSorting();
        log.info("Flat before sorting :\n" + flat);
        flatSorting.sortEachCategoryByPowerASC(flat);
        log.info("Flat after sorting :\n" + flat);

        FlatLogic flatLogic = new FlatLogic();
        log.info("Total power in flat = " + flatLogic.calculateTotalPower(flat));
        flatLogic.switchOnFlatiron(flat);
        log.info("Total power in flat = " + flatLogic.calculateTotalPower(flat));

      }

}
