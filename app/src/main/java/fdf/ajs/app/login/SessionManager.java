package fdf.ajs.app.login;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    //Session Manager klassen laver en session når man logger ind

    SharedPreferences userSession;
    SharedPreferences.Editor editor;
    Context context;
    //Variablerne som Session Manageren populater.
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERID = "UserID";
    public static final String KEY_EMAIL = "email";
    //Starter Sessionmanager.
    public SessionManager(Context _context) {
        context = _context;
        userSession = context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE);

        editor = userSession.edit();
    }
    //Opretter login sessionen
    public void createLoginSession(String UserID, String email) {

        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERID, UserID);
        editor.putString(KEY_EMAIL, email);

        editor.commit();
    }
    //læser og putter alle detaljerne ned i Key_userid og Email
    public HashMap<String, String> getUserDetailsFromSession() {
        HashMap<String, String> userDetails = new HashMap<String, String>();

        // Get and store all details into userDetails
        userDetails.put(KEY_USERID, userSession.getString(KEY_USERID, null));
        userDetails.put(KEY_EMAIL, userSession.getString(KEY_EMAIL, null));

        return userDetails;
    }

    public boolean checkLogin(){
        // Isn't set to true but will return its value
        if(userSession.getBoolean(IS_LOGIN, true)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void sessionLogout() {
        editor.clear();
        editor.commit();
    }

}
