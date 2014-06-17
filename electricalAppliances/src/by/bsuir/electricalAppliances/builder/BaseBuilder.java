/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.electricalAppliances.builder;

import by.bsuir.electricalAppliances.model.Flat;

/**
 *
 * @author Ann
 */
public abstract class BaseBuilder {
    protected Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void createNewFlat() {
        this.flat = new Flat();
    }

    public abstract void addFlatirons(int count);
    public abstract void addFridges(int count);
}
