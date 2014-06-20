package by.bsuir.electricalAppliances.model;

import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

public class Flatiron extends ElectricalAppliance {

    private String soleplate;   // материал подошвы утюга

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
        return super.toString() + " Soleplate = " + soleplate + "\n";
    }


}
