package builder;

import factoryMethod.Factory;

public class EconomyBuilder extends BaseBuilder{

    public void addFlatirons (int count) {
        for (int i = 0; i < count; i++) {
            this.flat.addElectricalAppliance(Factory.getClassFromFactory("EconomyFlatiron"));
        }
    }

    public void addFridges (int count) {
        for (int i = 0; i < count; i++) {
            this.flat.addElectricalAppliance(Factory.getClassFromFactory("EconomyFridge"));
        }
    }
}
