package com.example.listeplanetes;

import java.util.ArrayList;

public class Data {

    private ArrayList<String> nomListe;
    private ArrayList<Integer> poidListe ;
    private ArrayList<Planete> allData;

    public Data(ArrayList<String> nomListe, ArrayList<Integer> poidListe )
    {
        this.nomListe = nomListe;
        this.poidListe =  poidListe;
    }

    public Data(ArrayList<Planete> nomListe)
    {
        this.allData = allData;
    }

    public Data()
    {

    }

    public ArrayList<String> getListeNom() {
        return nomListe;
    }

    public ArrayList<Integer> getListePoid() {
        return poidListe;
    }

    public ArrayList<Planete> getAllData()
    {
        return allData;
    }

    public void setAllData(ArrayList<Planete> allData) {
        this.allData = allData;
    }

    public void setNomListe(ArrayList<String> nomListe) {
        this.nomListe = nomListe;
    }

    public void setPoidListe(ArrayList<Integer> poidListe) {
        this.poidListe = poidListe;
    }
}
