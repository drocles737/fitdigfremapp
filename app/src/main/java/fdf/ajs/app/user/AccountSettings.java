package fdf.ajs.app.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import fdf.ajs.app.R;

public class AccountSettings extends Fragment {
    //Variabler
    Button accBtn, chg_pw, chg_email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_settings, container, false);

        accBtn = view.findViewById(R.id.accBtn);
        // Tilbage til brugermenu når man klikker på "Brugermenu" i kontoindstillinger
        accBtn.setOnClickListener(v -> getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.fragment_container)).commit());

        chg_pw = view.findViewById(R.id.chg_pw);
        chg_pw.setOnClickListener(v -> {
            FragmentTransaction fr = getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container, new chg_pw());
            fr.commit();
        });

        chg_email = view.findViewById(R.id.chg_email);
        chg_email.setOnClickListener(v -> {
            FragmentTransaction fr = getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container, new chg_email());
            fr.commit();
        });

        return view;
    }

}