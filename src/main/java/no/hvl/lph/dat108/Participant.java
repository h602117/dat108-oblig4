package no.hvl.lph.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant {

    @Id
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String password;
    private String gender;

    public Participant() {
    }

    public Participant(String firstname, String lastname, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public Participant(String phonenumber, String firstname, String lastname, String password, String gender) {
        this.phonenumber = phonenumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
