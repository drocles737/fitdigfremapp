package fdf.ajs.app.planer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.login.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrugerOvelseActivity extends AppCompatActivity {
    //Variabler
    ListView BrugerOvPlan;
    Button Btnfordig;
//    Integer planId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelser);
        BrugerOvPlan = findViewById(R.id.brugerOvPlan);
        Btnfordig = findViewById(R.id.btnfordigOvelse);


        //BrugerOvPlan = findViewById(R.id.lis)

//        Btnfordig.setOnClickListener((v -> finish()));
//        SessionManager sessionManager = new SessionManager((getApplicationContext()));
//        HashMap<String, String> userDetails = sessionManager.getUserDetailsFromSession();
//        String storedID = userDetails.get(SessionManager.KEY_USERID);
//        assert storedID != null;
//        int Storedid = Integer.parseInt(storedID);


        Intent intent = getIntent();
        String id = intent.getStringExtra("planID"); //skiftet til stort D

        int pid = Integer.parseInt(id);
        getBrugerOvelseLister(pid); //pid

    }
    private void getBrugerOvelseLister(int planID)  {  //planID
        Call<List<BrugerOvelseRequest>> call = APIClient.getPlanService().getUserInfoplan(planID); //Planid
       // Call<List<BrugerOvelseRequest>> call = APIClient.getPlanService().;
        Toast.makeText(getApplicationContext(), "Brugerøvelser", Toast.LENGTH_LONG).show();
        call.enqueue(new Callback<List<BrugerOvelseRequest>>() {
            @Override
            public void onResponse(@NotNull Call<List<BrugerOvelseRequest>> call, @NotNull Response<List<BrugerOvelseRequest>> response) {
                List<BrugerOvelseRequest> PlanerList;
                PlanerList = response.body();

                String[] planer = new String[PlanerList.size()];

                //Foreach loop
                for (int i = 0 ; i < PlanerList.size(); i++) {
                    planer[i] = PlanerList.get(i).getNavn(); //skiftet til lille n
                }

                ListAdapter listAdapter = new ArrayAdapter<>(BrugerOvelseActivity.this, R.layout.row_item, planer);
                BrugerOvPlan.setAdapter(listAdapter);


//                BrugerOvPlan.setOnItemClickListener((parent, view, position, id) -> {
//
//                    Intent intent = new Intent(BrugerOvelseActivity.this, OvelseInfoActivity.class);
//                    BrugerOvelseRequest p = PlanerList.get(position);
//                    intent.putExtra("planId", p);  //lav så det kan transporter data. //få lav det så Stringvalueof til rep og saet.
//
//                    startActivity(intent);
//                });
            }
            public void onFailure(@NotNull Call<List<BrugerOvelseRequest>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Virker ikke", Toast.LENGTH_LONG).show();
            }
        });
    }
}