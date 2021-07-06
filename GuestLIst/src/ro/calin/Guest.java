package ro.calin;

import java.io.Serializable;

public class Guest implements Serializable {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private static final long serialVersionUID = 1L;

    public Guest(String lastName, String firstName,String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Guest() {
        this.lastName = null;
        this.firstName = null;
        this.email = null;
        this.phoneNumber = null;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean hasSameName(String lastName, String firstName) {
        return this.lastName.equalsIgnoreCase(lastName) && this.firstName.equalsIgnoreCase(firstName);
    }

    @Override
    public String toString() {
        return  "Nume: '" + lastName  +
                ", prenume: " + firstName +
                ", email: " + email +
                ", numar telefon: " + phoneNumber;
    }

    public Guest partialSearch(String key) {
        Guest guest = new Guest();
        if (this.firstName.toLowerCase().contains(key.toLowerCase())) {
            guest.firstName = this.firstName;
        }
        if (this.lastName.toLowerCase().contains(key.toLowerCase())) {
            guest.lastName = this.lastName;
        }
        if (this.email.toLowerCase().contains(key.toLowerCase())) {
            guest.email = this.email;
        }
        if (this.phoneNumber.toLowerCase().contains(key.toLowerCase())) {
            guest.phoneNumber = this.phoneNumber;
        }
        return guest;
    }
}
