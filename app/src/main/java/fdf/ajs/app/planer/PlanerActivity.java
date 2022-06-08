package fdf.ajs.app.planer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fdf.ajs.app.R;
import fdf.ajs.app.api.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanerActivity extends AppCompatActivity {
    //Variabler
    //dette her er Preplaner
    ListView listView;
    Button btnBack, btnSort;
//    List<PlanerRequest> planList = new ArrayList<>();
    Integer planId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_planer);
        super.onCreate(savedInstanceState);

        listView = findViewById(R.id.listview);
        btnBack = findViewById(R.id.btnBack);
        btnSort = findViewById(R.id.btnSort);
        getPrePlaner();
        btnBack.setOnClickListener(v -> finish());
    }

    //Metode til at hente preplaner fra databasen
    private void getPrePlaner() {
        Call<List<PlanerRequest>> call = APIClient.getPlanService().getPlaner();
        Toast.makeText(getApplicationContext(), "This is only a test ", Toast.LENGTH_LONG).show();
        call.enqueue(new Callback<List<PlanerRequest>>() {
            @Override
            public void onResponse(@NotNull Call<List<PlanerRequest>> call, @NotNull Response<List<PlanerRequest>> response) {
                List<PlanerRequest> PlanerList = response.body();
                assert PlanerList != null;
                String[] planer = new String[PlanerList.size()];

                //Foreach loop
                for (int i = 0; i < PlanerList.size(); i++) {
                    planer[i] = PlanerList.get(i).getPrePlanNavn();
                    //Planer[i] = PlanerList.get(i).getPrePlanID();
                }

                ListAdapter listAdapter = new ArrayAdapter<>(PlanerActivity.this, R.layout.row_item, planer);

                listView.setAdapter(listAdapter);

                listView.setOnItemClickListener((parent, view, position, id) -> {

                    planId = PlanerList.get(position).getPrePlanID();
                    String pid = String.valueOf(planId);

                    Intent intent = new Intent(PlanerActivity.this, PlanActivity.class);
                    intent.putExtra("planId", pid);
                    //Log.d("test", "populate6: ");
                    //Log.d("planid", "onResponse: " + pid);
                    startActivity(intent);
                });
            }

            @Override
            public void onFailure(@NotNull Call<List<PlanerRequest>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Virker ikke", Toast.LENGTH_LONG).show();
            }
        });
    }
}