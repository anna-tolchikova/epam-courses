package by.bsuir.electricalAppliances.model;

import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

public class UsualFlatiron extends ElectricalAppliance{

    @Override
    public Integer getMaximumPowerConsumption(){
        return 1600;
    }
}
