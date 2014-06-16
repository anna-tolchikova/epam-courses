package model;

import model.Abstractions.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Iterator;

public class Flat {
    ArrayList<ElectricalAppliance> electricalAppliances;

    public Flat(){
        this.electricalAppliances = new ArrayList<ElectricalAppliance>() ;
    }

    public ArrayList<ElectricalAppliance> getElectricalAppliances() {
        return electricalAppliances;
    }

    public void addElectricalAppliance(ElectricalAppliance newObject){
        this.electricalAppliances.add(newObject);

    }

   


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flat other = (Flat) obj;
        if (this.electricalAppliances != other.electricalAppliances && (this.electricalAppliances == null || !this.electricalAppliances.equals(other.electricalAppliances))) {
            return false;
        }
        return true;
    }



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.electricalAppliances != null ? this.electricalAppliances.hashCode() : 0);
        return hash;
    }


}
