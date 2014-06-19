package by.bsuir.electricalAppliances.modelAbstractions;

public abstract class ElectricalAppliance implements Comparable {

    protected  boolean isSwitchedOn;
    protected int maxPowerConsumption;

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

    public void setSwitchedOn(boolean flag) {
        this.isSwitchedOn = flag;
    }
    
    public void setMaxPowerConsumption(int maxPowerConsumption) {
        this.maxPowerConsumption = maxPowerConsumption; 
    }

    public Integer getMaxPowerConsumption() {
        return this.maxPowerConsumption;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public Integer getCurrentPowerConsumption() {
        if (isSwitchedOn) {
            return getMaxPowerConsumption();
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Object obj) {
        ElectricalAppliance entry = (ElectricalAppliance) obj;

        int result =  this.getMaxPowerConsumption() - entry.getMaxPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " isSwitchedOn = " + this.isSwitchedOn + " maxPowerConsumption = " + this.maxPowerConsumption;
    }

}
