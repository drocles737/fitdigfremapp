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


public class chg_pw extends Fragment {
    //Variabler
    Button cancel_btn, chg;
    EditText curr_pw, new_pw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chg_pw, container, false);

        // Tilbage til brugermenu hvis "Annuller"-knap klikkes på
        cancel_btn = view.findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(v -> getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fragment_container)).commit());

        curr_pw = view.findViewById(R.id.curr_pw);
        new_pw = view.findViewById(R.id.new_pw);

        chg = view.findViewById(R.id.chg);
        chg.setOnClickListener(v -> {
        updatePassword();
        });
        return view;
    }

    private void updatePassword() {
        SessionManager sessionManager = new SessionManager(getContext());
        HashMap<String, String> userDetails = sessionManager.getUserDetailsFromSession();
        String storedID = userDetails.get(SessionManager.KEY_USERID);

        int Userid = Integer.parseInt(storedID);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId(Userid);
        loginRequest.setCurrentPassword(curr_pw.getText().toString());
        loginRequest.setpassword(new_pw.getText().toString());

        //loginRequest.getNewPassword(), loginRequest.getCurrentPassword())
        // har lavet om på current password og new password
        assert storedID != null;
        Call<Void> loginResponseCall = APIClient.getUserService().update_pw(loginRequest);
        loginResponseCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(getContext(), "Password er ændret!", Toast.LENGTH_LONG).show();
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new AccountSettings());
                    fr.commit();
                }
                else {
                    Toast.makeText(getContext(), "Nuværende password er forkert.", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}