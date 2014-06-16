package factoryMethod;

import model.EconomyFlatiron;
import model.EconomyFridge;
import model.UsualFlatiron;
import model.UsualFridge;
import model.Abstractions.ElectricalAppliance;

public class Factory {
    private enum Classes { ECONOMYFLATIRON, USUALFLATIRON, ECONOMYFRIDGE, USUALFRIDGE}

    public static ElectricalAppliance getClassFromFactory(String id) {
        Classes className = Classes.valueOf(id.toUpperCase());
        
        switch (className) {
            case ECONOMYFLATIRON:
                return new EconomyFlatiron();
            case USUALFLATIRON:
                return new UsualFlatiron();
            case ECONOMYFRIDGE:
                return new EconomyFridge();
            case USUALFRIDGE:
                return new UsualFridge();
            default : throw new EnumConstantNotPresentException(Classes.class, className.name());

        }
    }
}
