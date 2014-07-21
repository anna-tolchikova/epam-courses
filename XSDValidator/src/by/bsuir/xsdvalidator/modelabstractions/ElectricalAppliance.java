package by.bsuir.xsdvalidator.modelabstractions;

import by.bsuir.xsdvalidator.exceptions.LogicalException;
import by.bsuir.xsdvalidator.exceptions.TechnicalException;

public abstract class ElectricalAppliance implements Comparable<ElectricalAppliance> {

    protected  boolean isSwitchedOn;
    protected int maxPowerConsumption;
    protected String producer;
    protected String model;

    public ElectricalAppliance() {
        this.isSwitchedOn = false;
    }

    public ElectricalAppliance(boolean isSwitchedOn) {
        this.isSwitchedOn = isSwitchedOn;
    }

    public ElectricalAppliance(boolean isSwitchedOn, int maxPowerConsumption) {
        this.isSwitchedOn = isSwitchedOn;
        this.maxPowerConsumption = maxPowerConsumption;
    }

    public ElectricalAppliance(boolean isSwitchedOn, int maxPowerConsumption, String producer) {
        this.isSwitchedOn = isSwitchedOn;
        this.maxPowerConsumption = maxPowerConsumption;
        this.producer = producer;
    }

    protected ElectricalAppliance(boolean isSwitchedOn, int maxPowerConsumption, String producer, String model) {
        this.isSwitchedOn = isSwitchedOn;
        this.maxPowerConsumption = maxPowerConsumption;
        this.producer = producer;
        this.model = model;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public void setSwitchedOn(boolean flag) {
        this.isSwitchedOn = flag;
    }

    public Integer getMaxPowerConsumption() {
        return this.maxPowerConsumption;
    }

    public void setMaxPowerConsumption(int maxPowerConsumption){
        this.maxPowerConsumption = maxPowerConsumption; 
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCurrentPowerConsumption() {
        if (isSwitchedOn) {
            return getMaxPowerConsumption();
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(ElectricalAppliance obj) {
        int result =  this.getMaxPowerConsumption() - obj.getMaxPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }

    @Override
    public String toString() {
        return " isSwitchedOn = " + this.isSwitchedOn + " maxPowerConsumption = " + this.maxPowerConsumption + " producer = " + this.producer;
    }

}
