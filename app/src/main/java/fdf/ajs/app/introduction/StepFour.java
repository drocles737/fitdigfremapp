package fdf.ajs.app.introduction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fdf.ajs.app.R;


public class StepFour extends Fragment {



    public StepFour() {
    }

    //Funktion til fjerde fragment i opstart.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.intro_step_four, container, false);

        // viser fragmentet i frameview

        Button btnFragment=(Button) view.findViewById(R.id.btnfragmentfinish4);
        TextView btnFragmentexit=(TextView) view.findViewById(R.id.btnfragmentexit4);

        // knap til at lukke fragment ned
        btnFragment.setOnClickListener(v -> container.removeView(view));

        return view;
    }
}