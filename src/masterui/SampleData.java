package masterui;

import javafx.collections.ObservableList;

public class SampleData {

    public static void fillSampleData(ObservableList<Person> backingList){
        backingList.add(new Person("kozn akyel", "akyel", "baktım sana bek"));
        backingList.add(new Person("maykıl", "kolasa", "notumuz bu kadara"));
        backingList.add(new Person("kalısm", "aknakdo", "almislaer buradan top"));
        backingList.add(new Person("sergen", "yalcin", "abi bu ne baldir anlatsan"));
    }
}
