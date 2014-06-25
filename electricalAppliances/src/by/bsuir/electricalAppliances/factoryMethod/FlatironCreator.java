package by.bsuir.electricalappliances.factoryMethod;

import by.bsuir.electricalappliances.model.Flatiron;

public class FlatironCreator extends Creator {

    @Override
    public Flatiron factoryMethod() {
        return new Flatiron();
    }
}
