package fdf.ajs.app.signup;

public class RegisterResponse {
    //Variabler
    private String email, password, fName, lName;
    private int rolle;

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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getRolle() {return rolle;}

    public void setRolle(int rolle) { this.rolle = rolle;}
}
