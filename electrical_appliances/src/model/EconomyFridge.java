package model;

import model.Abstractions.ElectricalAppliance;

public class EconomyFridge extends ElectricalAppliance {

    @Override
    public Integer getMaximumPowerConsumption(){
        return 100;
    }
}
