package by.bsuir.electricalAppliances.model;

import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

public class EconomyFlatiron extends ElectricalAppliance{

    @Override
    public Integer getMaximumPowerConsumption(){
        return 1200;
    }


}