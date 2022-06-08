package fdf.ajs.app.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.user.HomeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends Fragment {
    //Variabler
    EditText email, password;
    Button loginBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        email = view.findViewById(R.id.etEmail);
        password = view.findViewById(R.id.etPassword);
        loginBtn = view.findViewById(R.id.btnLogin);
        //Login knap hvor den går ned og tjekker om der er skrevet noget i textfelterne.
        loginBtn.setOnClickListener(v -> {

            if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){

                Toast.makeText(getContext(),"Email og password er påkrævet!", Toast.LENGTH_LONG).show();
            }
            else {
                // Proceed to login
                login();
            }
        });
        return view;
    }
    //Login funktionen som går ind og laver en post request via vores api og logger os ind.
    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setCurrentPassword(password.getText().toString());
        //Api kald
        Call<LoginResponse> loginResponseCall = APIClient.getUserService().userLogin(loginRequest.getEmail(), loginRequest.getCurrentPassword());
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful() && response.body() != null){
                    Toast.makeText(getContext(), "Du er logget ind", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();

                    // Create a Session
                    SessionManager sessionManager = new SessionManager(getContext());
                    sessionManager.createLoginSession(String.valueOf(loginResponse.getUserID()), loginResponse.getEmail());

                    new Handler().postDelayed(() -> startActivity(new Intent(getContext(), HomeActivity.class).putExtra("data", loginResponse.getFornavn())), 50);
                }
                else {
                    Toast.makeText(getContext(), "Email eller password er forkert", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                //Toast.makeText(getActivity(), "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), "Email eller password er forkert prøv igen", Toast.LENGTH_LONG).show();
            }
        });
    }
}