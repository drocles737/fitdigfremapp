package fdf.ajs.app.planer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.login.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import fdf.ajs.app.login.LoginRequest;
import fdf.ajs.app.login.LoginResponse;

public class BrugerPlanActivity extends AppCompatActivity {
    //Variabler
    ListView UserPlanList;
    Integer planID;
    Button btnSort, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelseliste);

       UserPlanList = findViewById(R.id.ovPlanlistview);
       btnBack = findViewById(R.id.btnBackov);
//      Intent intent = getIntent();
//        String id = intent.getStringExtra("planId");
//
//         int uid = Integer.parseInt(id); //problemet opstår når   java.lang.RuntimeException: Unable to start activity ComponentInfo
//         getbrugerPlaner(uid);
//
        SessionManager sessionManager = new SessionManager((getApplicationContext()));
        HashMap<String, String> userDetails = sessionManager.getUserDetailsFromSession();
        String storedID = userDetails.get(SessionManager.KEY_USERID);
        assert storedID != null;
        int Storedid = Integer.parseInt(storedID);

        getbrugerPlaner(Storedid);
        btnBack.setOnClickListener(v -> finish());
        //java.lang.RuntimeException: Unable to start activity ComponentInfo{fdf.ajs.app/fdf.ajs.app.planer.BrugerPlanActivity}: java.lang.NumberFormatException: s == null1)

    }

    private void getbrugerPlaner(int Storedid){ //brugerID                          //Bruger
        Call<List<BrugerPlanRequest>> call = APIClient.getPlanService().getUserInfo(Storedid);
        //Toast.makeText(getApplicationContext(), "This is only a test 2 ", Toast.LENGTH_LONG).show();
        call.enqueue(new Callback<List<BrugerPlanRequest>>() {
            @Override
            public void onResponse(@NotNull Call<List<BrugerPlanRequest>> call, @NotNull Response<List<BrugerPlanRequest>> response) {
                List<BrugerPlanRequest> PlanList;
                PlanList = response.body();

                 // assert PlanList != null;
                //Log.d("testliste", String.valueOf(PlanerList));
                String[] planer = new String[PlanList.size()];
                //Integer[] test = new Integer[PlanerList.size()];

                //Foreach loop
                for (int i = 0; i < PlanList.size(); i++) {
                    planer[i] = PlanList.get(i).getPlanNavn();

                }
                ListAdapter listAdapter = new ArrayAdapter<>(BrugerPlanActivity.this, R.layout.row_item, planer);
                UserPlanList.setAdapter(listAdapter);

                UserPlanList.setOnItemClickListener((parent, view, position, id) -> {

                    planID = PlanList.get(position).getplanID();
                    String pid = String.valueOf(planID);

                    Intent intent = new Intent(BrugerPlanActivity.this, BrugerOvelseActivity.class);
                    intent.putExtra("planID", pid); //skiftet til stort D har lavet det om så det passer med api kald
//                  //Log.d("planid", "onResponse: " + pid);
                    startActivity(intent);
                });

            }

            @Override
            public void onFailure(@NotNull Call<List<BrugerPlanRequest>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Virker ikke", Toast.LENGTH_LONG).show();
            }
        });

    }
}