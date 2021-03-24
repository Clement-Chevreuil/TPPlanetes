package com.example.listeplanetes;

        import java.util.ArrayList;

public class Planete {

    private String nom;
    private int poid;

    public Planete(String nom, int poid)
    {
        this.nom = nom;
        this.poid =  poid;
    }
    public Planete()
    {

    }

    public Planete(String nom)
    {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public float getPoid() {
        return poid;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }
}
