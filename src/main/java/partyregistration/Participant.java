package partyregistration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant {

    @Id
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String passHash;
    private String passSalt;
    private String gender;

    public Participant() {
    }

    public Participant(String firstname, String lastname, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public Participant(String phonenumber, String firstname, String lastname, String passHash, String passSalt, String gender) {
        this.phonenumber = phonenumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passHash = passHash;
        this.passSalt = passSalt;
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

    public String getPassHash() {
        return this.passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getPassSalt() {
        return this.passSalt;
    }

    public void setPassSalt(String passSalt) {
        this.passSalt = passSalt;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
