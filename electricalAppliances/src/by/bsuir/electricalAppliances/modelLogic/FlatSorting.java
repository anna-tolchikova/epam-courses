package by.bsuir.electricalAppliances.modelLogic;

import by.bsuir.electricalAppliances.model.Flat;
import java.util.Collections;

public class FlatSorting {

    public void sortEachCategoryByPowerASC(Flat flat) {
        sortFlatironsByPowerASC(flat);
        sortFridgesByPowerASC(flat);
    }

    public void sortFlatironsByPowerASC(Flat flat) {
        Collections.sort(flat.getFlatirons());
    }

    public void sortFridgesByPowerASC(Flat flat) {
        Collections.sort(flat.getFridges());
    }
}
