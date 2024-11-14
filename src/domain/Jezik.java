package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Jezik {
    private int id;
    private String naziv;
    private String skraceni;

    public Jezik() {
    }

    public Jezik(int id, String naziv, String skraceni) {
        this.id = id;
        this.naziv = naziv;
        this.skraceni = skraceni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkraceni() {
        return skraceni;
    }

    public void setSkraceni(String skraceni) {
        this.skraceni = skraceni;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
