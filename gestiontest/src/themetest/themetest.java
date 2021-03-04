/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themetest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import java.sql.ResultSet;

/**
 *
 * @author Matoussi
 */
public class themetest {

    private int id_themetest;
    private String nom;
    private Connection dbconx;
    
    
    public themetest(int id_themetest, String nom){
        this.id_themetest = id_themetest;
        this.nom = nom;
    }

    public themetest() {
        this.dbconx = DataSource.getInstance().getCnx();
    }

    public int getId_themetest() {
        return id_themetest;
    }

    public void setId_themetest(int id_themetest) {
        this.id_themetest = id_themetest;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "themetest{" + "id_themetest=" + id_themetest + ", nom=" + nom + '}';
    }
    

    public int getIdByName(String name) {
        try {
            String requete = "SELECT id_themetest FROM themetest WHERE nom = ? ";
            PreparedStatement pst = this.dbconx.prepareStatement(requete);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(themetest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
