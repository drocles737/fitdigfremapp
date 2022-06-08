package fdf.ajs.app.planer;

import java.io.Serializable;
//denner er til øvelserne
public class BrugerOvelseRequest implements Serializable {
    //Variabler
    int planID, repetitioner, saet;
    float nuvaerendeVaegt, startVaegt;
    String navn, oevelseDesc;

    public BrugerOvelseRequest(int planID, String navn, int repetitioner, int saet, String oevelseDesc, float nuvaerendeVaegt, float startVaegt) {
        super();
        this.planID = planID;
        this.navn = navn;
        this.oevelseDesc = oevelseDesc;
        this.repetitioner = repetitioner;
        this.saet = saet;
        this.nuvaerendeVaegt = nuvaerendeVaegt;
        this.startVaegt = startVaegt;
    }
    //Constructor
    public BrugerOvelseRequest()
    {}

    public float getnuvaerendeVaegt() {
        return nuvaerendeVaegt;
    }

    public void setnuvaerendeVaegt(float nuvaerendeVaegt) {
        this.nuvaerendeVaegt = nuvaerendeVaegt;
    }

    public float getstartVaegt() {
        return startVaegt;
    }

    public void setstartVaegt(float startVaegt) {
        this.startVaegt = startVaegt;
    }

    public int getrepetitioner() {
        return repetitioner;
    }

    public void setrepetitioner(int repetitioner) {
        this.repetitioner = repetitioner;
    }

    public int getsaet() {
        return saet;
    }

    public void setsaet(int saet) {
        this.saet = saet;
    }

    public String getoevelseDesc() {
        return oevelseDesc;
    }

    public void setoevelseDesc(String oevelseDesc) {
        this.oevelseDesc = oevelseDesc;
    }

    public int getplanID() { return planID;}

    public void setplanID(int planID) { this.planID = planID;}

    public String getNavn() {return navn;}

    public void setnavn(String navn){
        this.navn = navn;
    }
}

