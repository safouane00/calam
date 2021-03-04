/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicethemetest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import themetest.themetest;
import utils.DataSource;

/**
 *
 * @author Matoussi
 */
public class servicethemetest implements Ithemetest<themetest> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(themetest t) {
        try {
            String requete = "INSERT INTO themetest (nom) VALUES (?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.executeUpdate();
            System.out.println("Théme ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(themetest t) {
        try {
            String requete = "DELETE FROM themetest WHERE id_themetest=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId_themetest());
            pst.executeUpdate();
            System.out.println("Théme supprimée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(themetest t) {
        try {
            String requete = "UPDATE themetest SET nom=? WHERE id_themetest=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2, t.getId_themetest());
            pst.setString(1, t.getNom());
            pst.executeUpdate();
            System.out.println("Théme modifiée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<themetest> afficher() {
        List<themetest> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM themetest";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new themetest(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

}
