package fdf.ajs.app.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import fdf.ajs.app.R;
import fdf.ajs.app.login.SessionManager;
import fdf.ajs.app.planer.BrugerPlanActivity;
import fdf.ajs.app.planer.PlanerActivity;
import fdf.ajs.app.planer.EditOvelser;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Variabler
    TextView user, storedDetail;
    private DrawerLayout drawer;
    Button planerBtn, prePlanerBtn, accountBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        planerBtn = findViewById(R.id.userPlanBtn);
        prePlanerBtn = findViewById(R.id.prePlanBtn);
        accountBtn = findViewById(R.id.accountBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        user = findViewById(R.id.user);
        storedDetail = findViewById(R.id.storedDetail);

        Intent intent = getIntent();

        // Shared Preferences/Session stuff
        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> userDetails = sessionManager.getUserDetailsFromSession();

        String storedEmail = userDetails.get(SessionManager.KEY_USERID);
        storedDetail.setText(storedEmail);

        // End Shared Preferences/Session stuff
        if (intent.getExtras() != null) {

            String passedUser = intent.getStringExtra("data");
            user.setText(passedUser);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);


        Menu menu = navigationView.getMenu();

        // Henter menu items og opdatere "login" til "logud" når man er logget ind
        MenuItem nav_update = menu.findItem(R.id.nav_login);
        nav_update.setTitle("Log ud");

        // Fjerner "signup" fra burger-menuen når man er logget ind
        MenuItem nav_remove = menu.findItem(R.id.nav_signup);
        nav_remove.setVisible(false);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();


        // Brugermenu knapper

        planerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {  Editovelser();  }
        });


        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new AccountSettings());
                fragmentTransaction.commit();
            }
        });

        // Logger ud gennem brugermenu
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Afslutter session via shared preferences
                SessionManager sessionManager = new SessionManager(getApplicationContext());
                sessionManager.sessionLogout();
                finish();
            }
        });


        prePlanerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanerActivity();
            }
        });

    }

    public void Editovelser()
    {
        Intent intent = new Intent(this, BrugerPlanActivity.class);
        startActivity(intent);
    }

    public void PlanerActivity() {
        Intent intent = new Intent(this, PlanerActivity.class);
        startActivity(intent);
    }

//    Burger-menu items for brugere
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_home:

                break;

//          reverter tilbage til MainActivity med det aktive login fragment aka logger ud
            case R.id.nav_login:

                // Afslutter session via shared preferences
                SessionManager sessionManager = new SessionManager(this);
                sessionManager.sessionLogout();
                this.finish();
                break;

        }
        return true;
    }
}