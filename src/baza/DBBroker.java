/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domain.Jezik;
import domain.Prevod;
import domain.SRB_REC;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class DBBroker {

    public List<SRB_REC> vratiListuReci() {
        List<SRB_REC> srbrec=new ArrayList<>();
        try {
            String upit="SELECT * FROM SRB_REC";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String naziv=rs.getString("naziv");
                SRB_REC srb=new SRB_REC(id, naziv);
                srbrec.add(srb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return srbrec;
    }

    public List<Prevod> vratiListuPrevoda(SRB_REC s) {
        List<Prevod> srbrec=new ArrayList<>();
        try {
            String upit="SELECT * FROM Prevod WHERE ids=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, s.getId());
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                int idj=rs.getInt("idj");
                int ids=rs.getInt("ids");
                String naziv=rs.getString("rec");
                Prevod rec=new Prevod(id,idj,ids, naziv);
                srbrec.add(rec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return srbrec;
    }

    public List<Prevod> vratiListuPrevoda1() {
        List<Prevod> srbrec=new ArrayList<>();
        try {
            String upit="SELECT * FROM Prevod";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next())
            {
                int id=rs.getInt("id");
                int idj=rs.getInt("idj");
                int ids=rs.getInt("ids");
                String naziv=rs.getString("rec");
                Prevod rec=new Prevod(id,idj,ids, naziv);
                srbrec.add(rec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return srbrec;
    }

    public List<Jezik> vratiListuJezika() {
        List<Jezik> listaJezika=new ArrayList<>();
        try {
            String upit="SELECT * FROM Jezik";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String naziv=rs.getString("naziv");
                String skraceni=rs.getString("skraceni_naziv");
                Jezik j=new Jezik(id, naziv, skraceni);
                listaJezika.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaJezika;
    }

    public List<Prevod> vratiListuPrevoda2(Jezik j, SRB_REC s) {
        List<Prevod> srbrec=new ArrayList<>();
        try {
            String upit="SELECT * FROM Prevod WHERE idj=? AND ids=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, j.getId());
            ps.setInt(2, s.getId());
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                int idj=rs.getInt("idj");
                int ids=rs.getInt("ids");
                String naziv=rs.getString("rec");
                Prevod rec=new Prevod(id,idj,ids, naziv);
                srbrec.add(rec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return srbrec;
    }

    public void dodajNoviJezik(String rec, String s, Jezik jezik) {
        List<Prevod> srbrec=new ArrayList<>();
        try {
            String upit1="SELECT max(id) AS max FROM SRB_REC";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs1=st.executeQuery(upit1);
            int max=0;
            while(rs1.next())
            {
                max=rs1.getInt("max");
                max++;
            }
            
            String upit2="INSERT INTO SRB_REC(id, naziv) VALUES(?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit2);
            ps.setInt(1, max);
            ps.setString(2, s);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            
            
            String upit6="SELECT max(id) AS max FROM Prevod";
            Statement st6=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs6=st.executeQuery(upit6);
            int max6=0;
            while(rs6.next())
            {
                max6=rs6.getInt("max");
                max6++;
            }
            
            String upit3="INSERT INTO PREVOD(id, idj, ids, rec) VALUES(?,?,?,?)";
            PreparedStatement ps1=Konekcija.getInstance().getConnection().prepareStatement(upit3);
            ps1.setInt(1, max6);
            int jez=jezik.getId();
            ps1.setInt(2, jez);
            ps1.setInt(3, max);
            ps1.setString(4, s);
            System.out.println(ps1.toString());
            ps1.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obrisiOdabranuRed(Prevod p) {
        try {
            String upit="DELETE FROM PREVOD WHERE ID=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}