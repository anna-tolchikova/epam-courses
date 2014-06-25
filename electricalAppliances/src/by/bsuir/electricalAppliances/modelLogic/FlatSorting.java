package by.bsuir.electricalappliances.modelLogic;

import by.bsuir.electricalappliances.model.Flat;
import java.util.Collections;

public class FlatSorting {

    public void sortAppliancesByPowerASC(Flat flat) {
        Collections.sort(flat.getElectricalAppliances());
    }


}
