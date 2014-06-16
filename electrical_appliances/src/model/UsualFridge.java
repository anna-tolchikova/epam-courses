package model;

import model.Abstractions.ElectricalAppliance;

public class UsualFridge extends ElectricalAppliance {

    @Override
    public Integer getMaximumPowerConsumption(){
        return 200;
    }
}
