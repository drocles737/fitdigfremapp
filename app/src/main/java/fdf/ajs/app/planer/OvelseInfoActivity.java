package fdf.ajs.app.planer;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.user.chg_email;
import fdf.ajs.app.user.chg_pw;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OvelseInfoActivity extends AppCompatActivity {
    //Variabler
    //OvelseNavn OvelseDesc OvelseReptitoner OvelseSet
    Intent intent;
    TextView Ovelsenavn, Ovelsedesc, OvelseRep, OvelseSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ovelsedescription_view_adapter);

        //Textviews is Layout
        Ovelsenavn = findViewById(R.id.OvelseNavn);
        Ovelsedesc = findViewById(R.id.OvelseDesc);
        OvelseRep = findViewById(R.id.OvelseRep); //parseofvalue
        OvelseSet = findViewById(R.id.OvelseSet); //parsevalue

        intent = getIntent();
        PlanRequest p = (PlanRequest) intent.getSerializableExtra("planId");
        //PlanRequest d = (PlanRequest) intent.getSerializableExtra("ovelseDesc");
        //PlanRequest r = (PlanRequest) intent.getSerializableExtra("repetitioner");
        //PlanRequest s = (PlanRequest) intent.getSerializableExtra("saet");


        String Navn = p.getNavn(); //Virker
        String Desc = p.getoevelseDesc(); //Virker
        int repetioner = p.getrepetitioner(); //setvalueof settextvalueof?
        int saet = p.getsaet(); //setvalueof settextvalueof?

        Ovelsenavn.setText(Navn);
        Ovelsedesc.setText(Desc);
        OvelseRep.setText(Integer.toString(repetioner));
        OvelseSet.setText(Integer.toString(saet));
        //Attempt to invoke virtual method 'java.lang.String fdf.ajs.app.planer.PlanRequest.getNavn()' on a null object reference



//        String Oid = intent.getStringExtra("exerciseID");
//        String ovnavn = intent.getStringExtra("navn");
//        String ovdesc = intent.getStringExtra("OevelseDesc");
//        String ovrep = intent.getStringExtra("repetitioner");
//        String ovset = intent.getStringExtra("saet");


        //int oid = Integer.parseInt(Oid);
        //getOvelseInfo(oid);
    }

//    private void getOvelseInfo(int OvelseId) {
//        Call<List<PlanRequest>> call = APIClient.getPlanService().getPlanInfo(OvelseId);
//        call.enqueue(new Callback<List<PlanRequest>>() {
//            @Override
//            public void onResponse(@NotNull Call<List<PlanRequest>> call, @NotNull Response<List<PlanRequest>> response){
//                List<PlanRequest> OvelseInfoList;
//                OvelseInfoList = response.body();
//
//                String[] Ovelseinfo = new String[OvelseInfoList.size()];
//
//                //OvelseInfoList.
//
//                //Foreach loop
//                for (int i = 0; i < OvelseInfoList.size(); i++) {
//                    Ovelseinfo[i] = OvelseInfoList.get(i).getNavn();
//                    Ovelseinfo[i] = OvelseInfoList.get(i).getoevelseDesc();
//                    Ovelseinfo[i] = String.valueOf(OvelseInfoList.get(i).getrepetitioner());
//                    Ovelseinfo[i] = String.valueOf(OvelseInfoList.get(i).getsaet());
//                     // OvelseSet.setText(OvelseInfoList.get(i).getSaet());
//                    //Ovelsenavn.setText(OvelseInfoList.get(i).getNavn());*
//                }
//
//                ListAdapter listAdapter = new ArrayAdapter<>(OvelseInfoActivity.this, R.layout.row_item, Ovelseinfo);
//
//                //OvelseSet.setText([Ovelseinfo.]);
//            }
//            @Override
//            public void onFailure(Call<List<PlanRequest>> call, Throwable t) {
//
//            }
//        });
    }





