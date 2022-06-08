package fdf.ajs.app.signup;

import java.io.Serializable;

public class RegisterRequest implements Serializable {

    //Variabler
    //private int userID;
    private String fornavn, efternavn, email, password, conf_password;
    private int rolle = 1;

    public RegisterRequest() {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.email = email;
        this.password = password;
        this.conf_password = conf_password;
        this.rolle = rolle;
    }

   /* public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }*/



    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConf_password() {
        return conf_password;
    }

    public void setConf_password(String conf_password) {
        this.conf_password = conf_password;
    }

    public int getRolle() { return rolle; }

    public void setRolle(int rolle) { this.rolle = rolle;}
}

