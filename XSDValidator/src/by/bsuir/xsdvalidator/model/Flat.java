package by.bsuir.xsdvalidator.model;

import by.bsuir.xsdvalidator.modelabstractions.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Iterator;

public class Flat {
    
    private ArrayList<ElectricalAppliance> electricalAppliances;

    public Flat(){
        electricalAppliances = new ArrayList<ElectricalAppliance>() ;
    }

    public ArrayList<ElectricalAppliance> getElectricalAppliances() {
        return electricalAppliances;
    }

    public void addElectricalAppliance(ElectricalAppliance newObject){
        electricalAppliances.add(newObject);

    }

    public void addElectricalAppliances(ArrayList<ElectricalAppliance> newList){
        electricalAppliances.addAll(newList);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;

        Flat flat = (Flat) o;

        if (!electricalAppliances.equals(flat.electricalAppliances)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return electricalAppliances.hashCode();
    }

    @Override
    public String toString() {
        Iterator<ElectricalAppliance> iter = electricalAppliances.iterator();
        String result = "";
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            result += item;
        }
        return result;
    }
}
