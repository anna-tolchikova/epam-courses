package by.bsuir.textparser.composite;

import java.io.FileWriter;
import java.util.ArrayList;

public class CompositeTextPart implements Component {

    private ArrayList<Component> childParts = new ArrayList<Component>();

//    public void print() {
//        for (Component part : childParts) {
//            part.print();
//        }
//    }

    public ArrayList<Component> getChildParts() {
        return childParts;
    }

    public void add(Component part) {
        childParts.add(part);
    }
 
    public void remove(Component part) {
        childParts.remove(part);
    }

    public void clear() {
        childParts.clear();
    }

    @Override
    public void writeToFile(FileWriter fw) {
        for (Component part : childParts) {
            part.writeToFile(fw);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Component part : childParts) {
            result += part;
        }
        return result;
    }
}
