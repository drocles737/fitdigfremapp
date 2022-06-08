package fdf.ajs.app.api;

import java.util.List;

import fdf.ajs.app.planer.BrugerOvelseRequest;
import fdf.ajs.app.planer.BrugerPlanRequest;
import fdf.ajs.app.planer.PlanRequest;
import fdf.ajs.app.planer.PlanerRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlanService {

    @GET("api/preplansession/Preplan/")
    Call<List<PlanerRequest>> getPlaner();

    @GET("api/pretraeningssession/Pretraeningsplan/{prePlanID}")
    Call<List<PlanRequest>> getPlanInfo(@Path("prePlanID") int prePlanID);

    //api/pretraeningsession/Pretraeningsplan/{prePlanID}

    // BRUGER PLANER
    //BrugerplanActivity.
    @GET("api/plansession/Userplan/User/{Storedid}") // den kan hente fra id 3 men ikke fra andre ID
    Call<List<BrugerPlanRequest>> getUserInfo(@Path("Storedid") int Storedid);

    //Henter Brugerens Øvelserne som sidder inde i Bruger planer.
    @GET("api/trainingsession/Traeningsplan/User/{planID}")
    Call<List<BrugerOvelseRequest>> getUserInfoplan(@Path("planID") int planID);

    // den viser en assertion error, så den bliver ikke populated
    //@GET("api/trainingsession/Oevelser/User/")
    //Call<List<BrugerOvelseRequest>> getUserInfoplan();
}
