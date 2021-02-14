package propertiesandbindings;

import javafx.collections.*;

/**
 * The FXCollections utility class contains factory methods for creating observable
 * collections and arrays. They resemble the factory methods in java.util.Collections
 * except that they return observable collections and arrays. They are the only means
 * through which instances of system-provided observable collections and arrays are
 * created.
 * The FXCollections utility class also provides a few methods for manipulating the
 * ObservableList objects it creates. These include the copy(), fill(), replaceAll(),
 * reverse(), rotate(), shuffle(), and sort() methods. They perform the same
 * functionality as their java.util.Collections counterparts, except that they pay
 * attention to minimize the number of list change notifications generated.
 * */

public class FXCollectionsExample {
    public static void main(String[] args){
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableMap<String, String> map =
                FXCollections.observableHashMap();
        ObservableSet<Integer> set =
                FXCollections.observableSet();
        ObservableFloatArray array =
                FXCollections.observableFloatArray();

        list.addListener((ListChangeListener<String>) c -> {
            System.out.println("\tlist = " +
                    c.getList());
        });
        map.addListener((MapChangeListener<String, String>) c ->{
            System.out.println("\tmap = " +
                    c.getMap());
        });
        set.addListener((SetChangeListener<Integer>) c -> {
            System.out.println("\tset = " +
                    c.getSet());
        });
        array.addListener((observableArray,
                           sizeChanged, from, to) -> {
            System.out.println("\tarray = " +
                    observableArray);
        });

    }
}
