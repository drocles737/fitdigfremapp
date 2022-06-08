package fdf.ajs.app.signup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.api.UserService;
import fdf.ajs.app.login.Login;
import fdf.ajs.app.user.AccountSettings;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends Fragment {
    //Variabler
    EditText fName, lName, email, pw, conf_pw;
    Button btnRegister;
    UserService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        fName = view.findViewById(R.id.fName);
        lName = view.findViewById(R.id.lName);
        email = view.findViewById(R.id.regEmail);
        pw = view.findViewById(R.id.pw);
        conf_pw = view.findViewById(R.id.conf_pw);

        btnRegister = view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {

            if (TextUtils.isEmpty(fName.getText().toString()) || TextUtils.isEmpty(lName.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(pw.getText().toString()) || TextUtils.isEmpty(conf_pw.getText().toString())){

                Toast.makeText(getContext(),"Alle felter er påkrævet!", Toast.LENGTH_LONG).show();
            }
            else {
                // Proceed to register
                if(TextUtils.equals(pw.getText().toString(), conf_pw.getText().toString())) {
                    register();
                }
                else {
                    Toast.makeText(getContext(),"Passwords matcher ikke", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    public void register() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFornavn(fName.getText().toString());
        registerRequest.setEfternavn(lName.getText().toString());
        registerRequest.setEmail(email.getText().toString());
        registerRequest.setPassword(pw.getText().toString());
        //registerRequest.setConf_password(conf_pw.getText().toString());
        registerRequest.getRolle();

        Call<Void> registerResponseCall = APIClient.getUserService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(getContext(), "Du er oprettet!", Toast.LENGTH_LONG).show();

                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new Login());
                    fr.commit();
                }
                else {
                    Toast.makeText(getContext(), "Bruger kunne ikke oprettes", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(getActivity(), "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}

