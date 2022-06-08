package fdf.ajs.app.login;

public class LoginRequest {

    //Variabler.
    private String email, currentPassword, password, newEmail;
    private int userID;

    public LoginRequest()
    {
        this.email = email;
        this.password = password;
        this.currentPassword = currentPassword;
        this.newEmail = newEmail;
        this.userID = userID;
    }


    //UserID Get Set
    public int getUserID(){
        return userID;
    }
    public void setUserId(int userID)
    {
        this.userID = userID;
    }

    //Email Get Set
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    //newemail Get Set
    public String GetNewemail()
    {
        return newEmail;
    }
    public void setNewemail(String newemail)
    {
        this.newEmail = newemail;
    }

    ////CurrentPassword Get Set
    public String getCurrentPassword() {

        return currentPassword;
    }
    public void setCurrentPassword(String currentPassword) {

        this.currentPassword = currentPassword;
    }

    //Password Get Set
    public String getpassword() {

        return password;
    }

    public void setpassword(String password) {

        this.password = password;
    }
}