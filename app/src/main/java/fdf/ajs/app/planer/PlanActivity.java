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

import java.util.ArrayList;
import java.util.List;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.user.chg_email;
import fdf.ajs.app.user.chg_pw;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanActivity extends AppCompatActivity {


    //Dette her er preplan øvelser.
    //Variabler
    ListView lvPlan;
    Button btnDone;
    Integer planid, OvelseId, OvRep, OvSet;
    String Ovdesc, OvNavn;
    //List<PlanRequest> Ovrequest;
    //OvelseAdapter Ovadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        lvPlan = findViewById(R.id.lvPlan);
        Intent intent = getIntent();
        String id = intent.getStringExtra("planId"); // bliver brugt til at smide en extra string ind på callet i Userservice.
        //String Oid = intent.getStringExtra("OvelseId");

        int pid = Integer.parseInt(id);
        //int oid = Integer.parseInt(Oid);

        //Log.d("planid", "preplanId:" + pid);
        //mangler at putte øvelser ind her.
        getPrePlanInfo(pid); // putter flere information her op via planRequest ?
        Toast.makeText(getApplicationContext(), "Den virker ", Toast.LENGTH_LONG).show();
    }

    //Funktion til api Call
    private void getPrePlanInfo(int prePlanID) {
        Call<List<PlanRequest>> call = APIClient.getPlanService().getPlanInfo(prePlanID);
        call.enqueue(new Callback<List<PlanRequest>>() {
            @Override
            public void onResponse(@NotNull Call<List<PlanRequest>> call, @NotNull Response<List<PlanRequest>> response) {
                List<PlanRequest> PlanInfoList;
                PlanInfoList = response.body();
//                Ovadapter = new OvelseAdapter(Ovrequest, PlanActivity.this);
//                lvPlan.setAdapter(Ovadapter);

                String[] planInfo = new String[PlanInfoList.size()];

                //ArrayList<PlanRequest>planInfo = new ArrayList<>();

                 //Foreach Loop
                for (int i = 0; i < PlanInfoList.size(); i++) {
                    planInfo[i] = PlanInfoList.get(i).getNavn(); // Øvelse navn
//                    planInfo[i] = PlanInfoList.get(i).getoevelseDesc(); // Øvelse Desc
//                    planInfo[i] = String.valueOf(PlanInfoList.get(i).getrepetitioner()); //Øvelse rep
//                    planInfo[i] = String.valueOf(PlanInfoList.get(i).getsaet()); //Ovelse Rep
                }

                //planInfo[i] = PlanInfoList.get(i).getNavn();
                //planInfo[i] = PlanInfoList.get(i).getOevelseDesc();
                //planInfo[i] = String.valueOf(PlanInfoList.get(i).getRepetitioner());
                //planInfo[i] = String.valueOf(PlanInfoList.get(i).getSaet());

                ListAdapter listAdapter = new ArrayAdapter<>(PlanActivity.this, R.layout.row_item, planInfo); // lavet om fra Row_item
               // OvelseAdapter adapter = new OvelseAdapter(this,R.layout.ovelsedescription_view_adapter,PlanInfoList);
                lvPlan.setAdapter(listAdapter);

                lvPlan.setOnItemClickListener((parent, view, position, id) -> {

                    //OvelseId = PlanInfoList.get(position).getPrePlanID();
                    //String oid = String.valueOf(OvelseId); // laves til brug af ovelsenavn isteden for.

                    Intent intent = new Intent(PlanActivity.this, OvelseInfoActivity.class);
                    PlanRequest p = PlanInfoList.get(position);
                    intent.putExtra("planId", p); // planId
//                    intent.putExtra("oevelseDesc", p);
//                    intent.putExtra("repetitioner", p);
//                    intent.putExtra("saet", p);
                    startActivity(intent);

//                    intent.putExtra("exerciseID", oid); // ved ikke lige om den er nødvendig.
//                    intent.putExtra("navn", OvNavn);
//                    intent.putExtra("oevelseDesc", Ovdesc);
//                    intent.putExtra("repetitioner", OvRep);
//                    intent.putExtra("saet", OvSet);


                    //Log.d("test", "populate6: ");
                    //Log.d("planid", "onResponse: " + pid);
                    //startActivity(intent);
                });

//                planid = PlanInfoList.get(position).getPrePlanID();
//                                    String pid = String.valueOf(planid);
//
//                Toast.makeText(getApplicationContext(), "This is only a test ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NotNull Call<List<PlanRequest>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Listen kunne ikke hente lige nu prøv igen senere", Toast.LENGTH_LONG).show();
            }
        });
    }

}