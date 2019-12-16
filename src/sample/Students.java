package sample;

import javafx.beans.property.SimpleStringProperty;

public class Students {
    private SimpleStringProperty firstName,id, email, tnumber;

    public Students(String firstName, String id, String email, String tnumber) {
        this.firstName = new SimpleStringProperty(firstName);
        this.id = new SimpleStringProperty(id);
        this.email = new SimpleStringProperty(email);
        this.tnumber = new SimpleStringProperty(tnumber);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getTnumber() {
        return tnumber.get();
    }

    public SimpleStringProperty tnumberProperty() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber.set(tnumber);
    }
}
