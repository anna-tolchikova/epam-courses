package model;

import model.Abstractions.ElectricalAppliance;

public class UsualFlatiron extends ElectricalAppliance{

    @Override
    public Integer getMaximumPowerConsumption(){
        return 1600;
    }
}
