/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Lenovo
 */
public class Prevod {
    private int idj;
    private int ids;
    private int id;
    private String rec;

    public Prevod() {
    }

    public Prevod(int id, int idj, int ids, String rec) {
        this.idj = idj;
        this.ids = ids;
        this.id = id;
        this.rec = rec;
    }

    public int getIdj() {
        return idj;
    }

    public void setIdj(int idj) {
        this.idj = idj;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    @Override
    public String toString() {
        return "Prevod{" + "idj=" + idj + ", ids=" + ids + ", id=" + id + ", rec=" + rec + '}';
    }
    
    
}
