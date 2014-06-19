package by.bsuir.electricalAppliances;

import by.bsuir.electricalAppliances.builder.Director;
import by.bsuir.electricalAppliances.builder.EconomyBuilder;
import by.bsuir.electricalAppliances.builder.ConcreteBuilder;
import by.bsuir.electricalAppliances.factoryMethod.Creator;
import by.bsuir.electricalAppliances.factoryMethod.FlatironCreator;
import by.bsuir.electricalAppliances.factoryMethod.FridgeCreator;
import by.bsuir.electricalAppliances.model.Flatiron;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.logging.Level;
import java.util.logging.Logger;
import by.bsuir.electricalAppliances.modelLogic.FlatLogic;
import java.util.ArrayList;
import org.apache.log4j.FileAppender;
import org.apache.log4j.SimpleLayout;

public class Main {
//    static Logger log = Logger.getLogger(String.valueOf(Main.class));
//    static {
//        log.setLevel(Level.INFO);
//        FileAppender appender = new FileAppender( new SimpleLayout(), "log.txt");
//        //logger.addAppender(appender);
//        //logger.setLevel(Level.DEBUG);
//    }

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());

        // concrete creators
        Creator flatironCreator = new FlatironCreator();
        Creator fridgeCreator = new FridgeCreator();

        // concrete products from factory method
        ArrayList<ElectricalAppliance> newFlatirons = new ArrayList<ElectricalAppliance>();
        ArrayList<ElectricalAppliance> newFridges = new ArrayList<ElectricalAppliance>();
        for (int i = 0; i < 3 ; i++){
            newFlatirons.add(flatironCreator.factoryMethod());
            newFridges.add(fridgeCreator.factoryMethod());
        }

        director.constructFlat(newFlatirons, newFridges); //first - flatirons, than - fridges
      

        FlatLogic flatLogic = new FlatLogic();

        flatLogic.setFlat(director.getFlat());
        
       // flatLogic.show();
        flatLogic.sortEachCategoryByPowerASC();
        //flatLogic.show();

        flatLogic.switchOnFlatiron();
        System.out.println("Total power in usual flat = " + flatLogic.calculateTotalPower());

      }

}
