package by.bsuir.electricalAppliances;

import by.bsuir.electricalAppliances.builder.Director;
import by.bsuir.electricalAppliances.builder.EconomyBuilder;
import by.bsuir.electricalAppliances.builder.UsualBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import by.bsuir.electricalAppliances.modelLogic.FlatLogic;
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
        Director usualDirector = new Director();
        Director econDirector = new Director();

        usualDirector.setFlatBuilder(new UsualBuilder());
        econDirector.setFlatBuilder(new EconomyBuilder());

        usualDirector.constructFlat(2, 2); //first - flatirons, than - fridges
        econDirector.constructFlat(2, 2);

        FlatLogic flatLogic = new FlatLogic();

        flatLogic.setFlat(usualDirector.getFlat());
        
        flatLogic.show();
        flatLogic.sortByPowerASC();
        flatLogic.show();

        flatLogic.switchOnElectricalAppliance();
        System.out.println("Total power in usual flat = " + flatLogic.getTotalPower());

        flatLogic.setFlat(econDirector.getFlat());
        System.out.println("Total power in econom flat = " + flatLogic.getTotalPower());
      }

}
