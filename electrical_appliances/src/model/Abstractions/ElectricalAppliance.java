package model.Abstractions;

public abstract class ElectricalAppliance implements Comparable {

    boolean isSwitchedOn;

    public ElectricalAppliance() {
        this.isSwitchedOn = false;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public void setSwitchedOn(boolean flag) {
        this.isSwitchedOn = flag;
    }

    public final Integer getCurrentPowerConsumption() {
        if (isSwitchedOn) {
            return getMaximumPowerConsumption();
        } else {
            return 0;
        }
    }

    public Integer getMaximumPowerConsumption() {
        return 0;
    }

    @Override
    public int compareTo(Object obj) {
        ElectricalAppliance entry = (ElectricalAppliance) obj;

        int result =  this.getMaximumPowerConsumption() - entry.getMaximumPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }

}
