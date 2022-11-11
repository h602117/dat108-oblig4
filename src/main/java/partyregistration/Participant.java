package partyregistration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class Participant {

    @Id
    @NotNull
    @Pattern(regexp = "\\d{8}", message = "must be 8 digits")
    private String phonenumber;

    @NotNull
    @Pattern(regexp = "([A-ZÆØÅ][a-zæøå-]+\s?)+", message = "names starting with upper case then lowercase and dash, separated by space")
    private String firstname;

    @NotNull
    @Pattern(regexp = "[A-ZÆØÅ][a-zæøå-]+", message = "one name starting with upper case then lowercase and dash, no spaces")
    private String lastname;

    @NotNull
    private String passHash;

    @NotNull
    private String passSalt;

    @NotNull
    @Pattern(regexp = "[MF]", message = "either M (male) or F (female)")
    private String gender;

    public Participant() {
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
