package fdf.ajs.app.introduction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fdf.ajs.app.R;

public class StepOne extends Fragment {


    public StepOne() {
        // Required empty public constructor
    }


    //Funktion til at lave den første fragment som ses når appen åbnes
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.intro_step_one, container, false);

        // viser fragmentet i frameview
        Button btnFragment=(Button) view.findViewById(R.id.btnfragment1);
        TextView btnFragmentexit=(TextView) view.findViewById(R.id.btnfragmentexit1);

        // knap til at lukke fragment ned.
        btnFragmentexit.setOnClickListener(v -> container.removeView(view));

        // knap til næste fragment
        btnFragment.setOnClickListener(v -> {
            FragmentTransaction fr=getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,new StepTwo());
            fr.commit();
        });

        return view;
    }
}