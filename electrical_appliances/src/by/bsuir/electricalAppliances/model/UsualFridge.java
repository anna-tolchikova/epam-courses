package by.bsuir.electricalAppliances.model;

import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

public class UsualFridge extends ElectricalAppliance {

    @Override
    public Integer getMaximumPowerConsumption(){
        return 200;
    }
}
