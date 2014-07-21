package by.bsuir.xsdvalidator.factorymethod;

import by.bsuir.xsdvalidator.model.Flatiron;

public class FlatironCreator extends Creator {

    @Override
    public Flatiron factoryMethod() {
        return new Flatiron();
    }
}
