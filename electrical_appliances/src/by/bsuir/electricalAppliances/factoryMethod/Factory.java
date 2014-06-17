package by.bsuir.electricalAppliances.factoryMethod;

import by.bsuir.electricalAppliances.model.EconomyFlatiron;
import by.bsuir.electricalAppliances.model.EconomyFridge;
import by.bsuir.electricalAppliances.model.UsualFlatiron;
import by.bsuir.electricalAppliances.model.UsualFridge;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

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
