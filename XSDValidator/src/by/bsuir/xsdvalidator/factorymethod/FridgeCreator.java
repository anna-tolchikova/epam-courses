package by.bsuir.xsdvalidator.factorymethod;

import by.bsuir.xsdvalidator.model.Fridge;

public class FridgeCreator extends Creator {

    @Override
    public Fridge factoryMethod() {
        return new Fridge();
    }
}
