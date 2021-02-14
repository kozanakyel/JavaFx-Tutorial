package masterui;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Callback;
import java.util.Objects;


public class Person {

    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty notes = new SimpleStringProperty(this, "notes", "sample note");

    public Person(){}
    public Person(String firstName, String lastName, String notes){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.notes.set(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString(){
        return firstName.get() + " " + lastName.get();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(notes, person.notes);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName,lastName,notes);
    }

    public static Callback<Person, Observable[]> extractor = p -> new Observable[]{p.lastNameProperty(), p.firstNameProperty()};
}
