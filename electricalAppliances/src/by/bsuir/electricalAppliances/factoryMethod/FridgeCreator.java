package by.bsuir.electricalappliances.factoryMethod;

import by.bsuir.electricalappliances.model.Fridge;

public class FridgeCreator extends Creator {

    @Override
    public Fridge factoryMethod() {
        return new Fridge();
    }
}
