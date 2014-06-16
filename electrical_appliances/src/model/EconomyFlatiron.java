package model;

import model.Abstractions.ElectricalAppliance;

public class EconomyFlatiron extends ElectricalAppliance{

    @Override
    public Integer getMaximumPowerConsumption(){
        return 1200;
    }


}
