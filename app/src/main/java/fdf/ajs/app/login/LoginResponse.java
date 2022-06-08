package fdf.ajs.app.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    //Variabler
    private int userID;
    private String email, password, fornavn;

    @SerializedName("refreshToken")
    private String authToken;
    //UserID Get Set
    public int getUserID() {

        return userID;
    }

    public void setUserID(int userID) {

        this.userID = userID;
    }
    //Email Get Set
    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    //Password Get Set
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
    //Fornavn Get Set
    public String getFornavn() {

        return fornavn;
    }

    public void setFornavn(String fornavn) {

        this.fornavn = fornavn;
    }
    //Authtoken Get Set
    public String getAuthToken() {

        return authToken;
    }

    public void setAuthToken(String authToken) {

        this.authToken = authToken;
    }
}
