package by.bsuir.electricalAppliances.builder;

import by.bsuir.electricalAppliances.model.Flat;

public class Director {
    private BaseBuilder flatBuilder;

    public void setFlatBuilder(BaseBuilder flatBuilder) {
        this.flatBuilder = flatBuilder;
    }

    public Flat getFlat() {
         return flatBuilder.getFlat();
    }

    public void constructFlat(int flatironsCount, int fridgesCount) {
        flatBuilder.createNewFlat();
        flatBuilder.addFlatirons(flatironsCount);
        flatBuilder.addFridges(fridgesCount);
        
    }

}
