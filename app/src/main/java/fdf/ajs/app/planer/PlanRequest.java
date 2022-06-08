package fdf.ajs.app.planer;

import java.io.Serializable;

public class PlanRequest implements Serializable {

   //Variabler
// Øvelser //Navn, NuvarendeVaegt, repetitioner, StartVaegt, Saet, oevelseDesc
    int prePlanID, repetitioner, saet;
    String navn, oevelseDesc;

    public PlanRequest(int prePlanID, int repetitioner, int saet, String navn, String oevelseDesc) {
        super();
        this.prePlanID = prePlanID;
        this.navn = navn;
        this.oevelseDesc = oevelseDesc;
        this.repetitioner = repetitioner;
        this.saet = saet;
    }

    //Constructor
    public PlanRequest(){}

    public int getrepetitioner() {
        return repetitioner;
    }

    public void setrepetitioner(int repetitioner) {
        repetitioner = repetitioner;
    }

    public int getsaet() {
        return saet;
    }

    public void setsaet(int saet) {
        saet = saet;
    }

    public String getoevelseDesc() {
        return oevelseDesc;
    }

    public void setOevelseDesc(String oevelseDesc) {
        oevelseDesc = oevelseDesc;
    }

    public int getPrePlanID() {
        return prePlanID;
    }

    public void setPrePlanID(int prePlanID) {
        this.prePlanID = prePlanID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
