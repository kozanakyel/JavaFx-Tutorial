package propertiesandbindings;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Unlike with properties, the framework provides no concrete binding classes.
 * Therefore, all bindings are custom bindings, and there are several ways to create them:
 * •
 *  Extending an abstract base class, such as DoubleBinding
 * •
 *  Using factory methods in the utility class Bindings
 * •
 *  Using fluent API methods in the property and binding classes
 *
 *  Yani diyor ki, Bindings, abstracttır concrete değilidr.
 *  sen diyor ya extend et yada custom şekilde kullan diyor...
 *
 * */

public class BidirectionalBindingExample {
    public static void main(String[] args){
        System.out.println("Constructing two string property " +
                " objects");
        StringProperty prop1 = new SimpleStringProperty("");
        StringProperty prop2 = new SimpleStringProperty("");

        System.out.println("Calling bindBidirectional");
        prop2.bindBidirectional(prop1);

        System.out.println("prop1.isBound() = " + prop1.isBound());
        System.out.println("prop2.isBound() = " + prop2.isBound());

        System.out.println("Calling prop1.set(\"prop1 says: hi!\"");
        prop1.set("prop1 says hi!");
        System.out.println("prop2.get returned");
        System.out.println(prop2.get());

        System.out.println("Calling prop2.set(prop2.get()" +
                " + \"\\nprop2 says: Bye!\")");
        prop2.set(prop2.get() + "\nprop2 says: Bye!");
        System.out.println("prop1.get() returned:");
        System.out.println(prop1.get());

    }
}
