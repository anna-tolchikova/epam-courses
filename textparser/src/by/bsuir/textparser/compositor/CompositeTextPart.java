package by.bsuir.textparser.compositor;

import java.util.ArrayList;

public class CompositeTextPart implements Component {

    private ArrayList<Component> childParts = new ArrayList<Component>();

    public void print() {
        for (Component part : childParts) {
            part.print();
        }
    }

    public void add(Component part) {
        childParts.add(part);
    }
 
    public void remove(Component part) {
        childParts.remove(part);
    }
}
