package fdf.ajs.app.planer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import fdf.ajs.app.login.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditOvelser extends AppCompatActivity {


    ListView ovlistView;
    Button btntilfoj, btnanuller, btnopdater, btnSlet;
    TextView brugeridvis;

    //Integer BrugerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editovelse);


//      btntilfoj = findViewById(R.id.btntilfoj);
        btnanuller = findViewById(R.id.btnanuller);
//      btnopdater = findViewById(R.id.btnOpdater);
//      btnSlet = findViewById(R.id.btnSlet);
        ovlistView = findViewById(R.id.ovPlanlist);
        //brugeridvis = findViewById(R.id.BrugerIdvis);


        Intent intent = getIntent();
        String id = intent.getStringExtra("BrugerPlanId");

        //disse 2 er lige tage ud af spille kortene

        //int Bid = Integer.parseInt(id);
       // getBrugerIdOvelser(Bid);



        Toast.makeText(getApplicationContext(), "den virker", Toast.LENGTH_LONG).show();

        //int bid = Integer.parseInt(id);
        //getBrugerIdOvelser(bid);
//        SessionManager sessionManager = new SessionManager(this);
//        HashMap<String, String> userDetails = sessionManager.getUserDetailsFromSession();
//        String storedid = userDetails.get(SessionManager.KEY_USERID);
        //brugeridvis.setText(storedid);
        btnanuller.setOnClickListener(v -> finish());
    }

    //lav en ny get metode til Brugerovelser. Spørg Simon.
//    private void getBrugerIdOvelser(int brugerPlanId) {
//        Call<List<BrugerOvelseRequest>> Call = APIClient.getPlanService().getUserInfo(brugerPlanId);
//        Toast.makeText(getApplicationContext(), "det virker ", Toast.LENGTH_LONG).show();
//        Call.enqueue(new Callback<List<BrugerOvelseRequest>>() {
//            @Override
//            public void onResponse(@NotNull Call<List<BrugerOvelseRequest>> call, @NotNull Response<List<BrugerOvelseRequest>> response) {
//                List<BrugerOvelseRequest> Userinfolist;
//                Userinfolist = response.body();
//
//                String[] planInfo = new String[Userinfolist.size()];
//
//                // Ændre til for(:) (foreach)
//                for (int i = 0; i < Userinfolist.size(); i++) {
//                    planInfo[i] = Userinfolist.get(i).getNavn();
//                }
//                ListAdapter listAdapter = new ArrayAdapter<>(EditOvelser.this, R.layout.row_item, planInfo);
//                ovlistView.setAdapter(listAdapter);
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<List<BrugerOvelseRequest>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Virker ikke lige nu", Toast.LENGTH_LONG).show();
//            }
//        });
//
////        lavet et check når brugeren tilføjer en ny øvelse til listen at den går ind og checker om nuværende vægt er 1 eller null.
////        hvis den er null skal den sættes til 1 eller anden værdig så API'en ikke går i kluder.
////
////
////        lav et api put kald der kan gå ind og updater li  sterne i databasen med de nye øvelser.
////
////        lille fragment vindue til selve øvelserne til at kunne slette eller updater øvelse
//
//    }
}