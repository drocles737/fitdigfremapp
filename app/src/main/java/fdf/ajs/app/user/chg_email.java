package fdf.ajs.app.user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.login.Login;
import fdf.ajs.app.login.LoginRequest;
import fdf.ajs.app.login.LoginResponse;
import fdf.ajs.app.login.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//lav sessionmanager til denne ?
//noget lignede til Loginresponse til denne klasse.


public class chg_email extends Fragment {

    //den virker, som en put men, api tager ikke fat i den. postman kan godt få det til at virke men der er stadig noget galt.
    //Der skal laves om til Body response isteden for.
    //Variabler
    Button cancel_btnn, chge;
    EditText curr_email, new_email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_chg_email, container, false);

        //tilbage til bruger menuen hvis der bliver trukket på annuller knappen
        cancel_btnn = view.findViewById(R.id.cancel_btnn);
        cancel_btnn.setOnClickListener(v -> getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fragment_container)).commit());

        curr_email = view.findViewById(R.id.curr_email);
        new_email = view.findViewById(R.id.new_email);

        chge = view.findViewById(R.id.chge);
        chge.setOnClickListener(v -> {
        updateemail();
        });

        return view;
    }

    public void updateemail() {
        SessionManager sessionManager = new SessionManager((getContext()));
        HashMap<String, String> userDetails = sessionManager.getUserDetailsFromSession();
        String storedID = userDetails.get(SessionManager.KEY_USERID);

        //der skal laves om på requestet da den ikke tager fat i id

        int Userid = Integer.parseInt(storedID);
        //Log.d("tag", storedID.toString());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId(Userid);
        loginRequest.setEmail(curr_email.getText().toString());
        loginRequest.setNewemail(new_email.getText().toString());

        assert storedID != null;                                                //lav om til update_email                                                   //getnewemail
        Call<Void> loginRequestCall = APIClient.getUserService().update_email(loginRequest); //(Integer.parseInt(storedID)
        loginRequestCall.enqueue(new Callback<Void>() { //LoginRequest
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if(response.isSuccessful()) //response.isSuccessful() && response.body() != null
                {
                    Toast.makeText(getContext(), "emailen er blevet ændret!", Toast.LENGTH_LONG).show();
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new AccountSettings());
                    fr.commit();
                }
                else
                {
                    int statuscode = response.code();
                    Log.d("tag", "statuscode" + statuscode);
                    Toast.makeText(getContext(), "emailen er forkert", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "den fejlede", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }
}