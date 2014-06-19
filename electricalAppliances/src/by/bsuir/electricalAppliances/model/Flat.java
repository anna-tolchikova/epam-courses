package by.bsuir.electricalAppliances.model;

import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Iterator;

public class Flat {
    
    ArrayList<ElectricalAppliance> flatirons;
    ArrayList<ElectricalAppliance> fridges;

    public Flat(){
        this.flatirons = new ArrayList<ElectricalAppliance>() ;
        this.fridges = new ArrayList<ElectricalAppliance>() ;
    }

    public ArrayList<ElectricalAppliance> getFlatirons() {
        return flatirons;
    }

    public ArrayList<ElectricalAppliance> getFridges() {
        return fridges;
    }

    public void addFlatiron(ElectricalAppliance newObject){
        this.flatirons.add(newObject);
    }

    public void addFridge(ElectricalAppliance newObject){
        this.fridges.add(newObject);
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
        if (this.flatirons != other.flatirons && (this.flatirons == null || !this.flatirons.equals(other.flatirons))) {
            return false;
        }
        if (this.fridges != other.fridges && (this.fridges == null || !this.fridges.equals(other.fridges))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.flatirons != null ? this.flatirons.hashCode() : 0);
        hash = 37 * hash + (this.fridges != null ? this.fridges.hashCode() : 0);
        return hash;
    }

   
//    @Override
//    public String toString() {
//        Iterator<ElectricalAppliance> iter = electricalAppliances.iterator();
//        String result = "";
//        while (iter.hasNext()) {
//            ElectricalAppliance item = iter.next();
//            result += item + "" + item.getMaxPowerConsumption();
//            System.out.println("power = ");
//        }
//        return result;
//    }


}
