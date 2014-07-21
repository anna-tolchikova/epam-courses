package by.bsuir.xsdvalidator.model;

import by.bsuir.xsdvalidator.modelabstractions.ElectricalAppliance;

public class Flatiron extends ElectricalAppliance {

    private String soleplate;   // материал подошвы утюга
    private int waterVolume;

    public Flatiron() {
        super();
    }

    public Flatiron(String soleplate) {
        super();
        this.soleplate = soleplate;
    }

    public Flatiron(boolean isSwithedOn, String soleplate) {
        super(isSwithedOn);
        this.soleplate = soleplate;
    }

    public Flatiron(boolean isSwithedOn, int maxPowerConsumption, String soleplate) {
        super(isSwithedOn, maxPowerConsumption);
        this.soleplate = soleplate;
    }

    public Flatiron(boolean isSwithedOn, int maxPowerConsumption, String soleplate, String producer) {
        super(isSwithedOn, maxPowerConsumption, producer);
        this.soleplate = soleplate;
    }

    public Flatiron(boolean isSwitchedOn, int maxPowerConsumption, String producer, String model, int waterVolume, String soleplate) {
        super(isSwitchedOn, maxPowerConsumption, producer, model);
        this.waterVolume = waterVolume;
        this.soleplate = soleplate;
    }

    public String getSoleplate() {
        return soleplate;
    }

    public void setSoleplate(String soleplate) {
        this.soleplate = soleplate;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(int waterVolume) {
        this.waterVolume = waterVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flatiron flatiron = (Flatiron) o;

        if (waterVolume != flatiron.waterVolume) return false;
        if (!soleplate.equals(flatiron.soleplate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = soleplate.hashCode();
        result = 31 * result + waterVolume;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " soleplate = " + soleplate + "water volume = " + waterVolume + "\n";
    }


}
