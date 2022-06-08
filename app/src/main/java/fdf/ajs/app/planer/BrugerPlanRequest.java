package fdf.ajs.app.planer;

import java.io.Serializable;
//denne her er til brugerplanerne
public class BrugerPlanRequest implements Serializable {
    //Variabler
    int planID;
    String planNavn;

    public BrugerPlanRequest(int planID, String planNavn) {
        super();
        this.planID = planID;
        this.planNavn = planNavn;
    }

    public BrugerPlanRequest()
    { }

    public int getplanID() { return planID;} // bliver brugt ligesom den anden i preplaner.

    public void setPlanID(int planID) { this.planID = planID;}

    public String getPlanNavn() {return  planNavn;}

    public void setPlanNavn(String planNavn) { this.planID = planID; }

}
