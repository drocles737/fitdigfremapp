package fdf.ajs.app.planer;

import java.io.Serializable;

public class PlanerRequest implements Serializable {

    //Variabler
    //Ikke røre ved json references
    int prePlanID;
    String prePlanNavn;

    public PlanerRequest(int prePlanID, String prePlanNavn) {
        super();
        this.prePlanID = prePlanID;
        this.prePlanNavn = prePlanNavn;
    }

    public int getPrePlanID() {
        return prePlanID;
    }

    public void setPrePlanID(int prePlanID) {
        this.prePlanID = prePlanID;
    }

    public String getPrePlanNavn() {
        return prePlanNavn;
    }

    public void setPrePlanNavn(String prePlanNavn) {
        this.prePlanNavn = prePlanNavn;
    }
}
