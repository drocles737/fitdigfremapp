package fdf.ajs.app.api;

import fdf.ajs.app.login.LoginRequest;
import fdf.ajs.app.login.LoginResponse;
import fdf.ajs.app.signup.RegisterRequest;
import fdf.ajs.app.signup.RegisterResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @POST("api/extract/User/authenticate/{email}/{password}")
    Call<LoginResponse> userLogin(@Path("email") String email, @Path("password") String password);
    //@FormUrlEncoded

    @PUT("api/extract/User/updatepassword/") // skal sendes i body og skal have fat i userID
    Call<Void> update_pw(@Body LoginRequest body); //userid skal sendes i body.
    //har skiftet om på curr_pw og new_pw

    @POST("api/extract/User/create/")
    Call<Void> registerUser(@Body RegisterRequest registerRequest);
    //@FormUrlEncoded

    @PUT("api/extract/User/updateemail/") // skal ændre i api og fordi det ser ud til at normal pratice siger man skal have {Userid} når man laver put. https://codinginflow.com/tutorials/android/retrofit/part-4-put-patch-delete-request //
    Call<Void> update_email(@Body LoginRequest body); //Userid skal sendes i body ligesom createuser.

    //Call<LoginRequest> update_email(@Path("UserID") int Userid, @Body LoginRequest body);

//    @PUT("api/extract/User/updateemail")
//    Call<LoginResponse> update_email(@Path("UserID") int UserID, @Path("email") String curr_email, @Path("newemail") String new_email);
}


//http://167.99.138.111:8080/FdfAPI/api/preplansession/Preplan/

    //@Field("new_pw") String new_pw
    //@Field("curr_pw") String curr_pw

// har