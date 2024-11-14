/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import domain.Jezik;
import domain.Prevod;
import domain.SRB_REC;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Controller {
    DBBroker dbb;
    private static Controller instance;
    public static Controller getInstance()
    {
        if(instance==null)
        {
            instance=new Controller();
        }
        return instance;
    }
    private Controller()
    {
        dbb=new DBBroker();   
    }

    public List<SRB_REC> vratiListuReci() {
        return dbb.vratiListuReci();
    }
    
    public List<Prevod> vratiListuPrevoda(SRB_REC s)
    {
        return dbb.vratiListuPrevoda(s);
    }

    public List<Prevod> vratiListuPrevoda() {
        return dbb.vratiListuPrevoda1();
    }

    public List<Jezik> vratiListuJezika() {
        return dbb.vratiListuJezika();
    }
    
    public List<Prevod> vratiListuPrevoda(Jezik j, SRB_REC s) {
        return dbb.vratiListuPrevoda2(j, s);
    }

    public void dodajNoviJezik(String rec, String s, Jezik jezik) {
        dbb.dodajNoviJezik(rec, s, jezik);
    }

    public void obrisiOdabranuRed(Prevod p) {
        dbb.obrisiOdabranuRed(p);
    }

}
