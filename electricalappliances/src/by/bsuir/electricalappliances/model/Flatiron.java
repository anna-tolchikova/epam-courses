package by.bsuir.electricalappliances.model;

import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;

public class Flatiron extends ElectricalAppliance {

    private String soleplate;   // материал подошвы утюга

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


    public String getSoleplate() {
        return soleplate;
    }

    public void setSoleplate(String soleplate) {
        this.soleplate = soleplate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flatiron other = (Flatiron) obj;
        if ((this.soleplate == null) ? (other.soleplate != null) : !this.soleplate.equals(other.soleplate)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.soleplate != null ? this.soleplate.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString() + " soleplate = " + soleplate + "\n";
    }


}
