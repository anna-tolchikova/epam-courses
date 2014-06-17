package by.bsuir.electricalAppliances.builder;

import by.bsuir.electricalAppliances.factoryMethod.Factory;

public class UsualBuilder extends BaseBuilder{

    public void addFlatirons (int count) {
        for (int i = 0; i < count; i++) {
            flat.addElectricalAppliance(Factory.getClassFromFactory("UsualFlatiron"));
        }
    }

    public void addFridges (int count) {
        for (int i = 0; i < count; i++) {
            flat.addElectricalAppliance(Factory.getClassFromFactory("UsualFridge"));
        }
    }
}
