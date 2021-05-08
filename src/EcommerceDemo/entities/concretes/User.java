package EcommerceDemo.entities.concretes;

import EcommerceDemo.entities.abstracts.Entity;

public class User implements Entity {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String verificationCode;
    private boolean status;

//    public User(int id, String firstName, String lastName, String email, String password, boolean status) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.status = status;
//    }

    public User(int id, String firstName, String lastName, String email, String password, String verificationCode, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.status = status;
    }

    public User(String email, String password){
        this.email = email;
        this.password=password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
