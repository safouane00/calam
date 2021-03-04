/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicereponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reponse.reponse;
import themetest.themetest;
import utils.DataSource;

/**
 *
 * @author Matoussi
 */
public class servicereponse implements Ireponse<reponse> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(reponse t) {
        try {
            String requete = "INSERT INTO reponse (libelle, id_question) VALUE (?,?) ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setBoolean(1, t.isLibelle());
            pst.setInt(2, t.getId_question());
            pst.executeUpdate();
            System.out.println("Réponse ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(reponse t) {
        try {
            String requete = "DELETE FROM reponse WHERE id_reponse=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId_reponse());
            pst.executeUpdate();
            System.out.println("Réponse supprimée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(reponse t) {
        try {
            String requete = "UPDATE reponse SET libelle=? WHERE id_reponse=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2, t.getId_reponse());
            pst.setBoolean(1, t.isLibelle());
            pst.executeUpdate();
            System.out.println("Réponse modifiée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<reponse> afficher() {
        List<reponse> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reponse";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new reponse(rs.getInt(1), rs.getBoolean(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public int nbOUIReponseTotal() {
        int nb = 0;
        try {

            String requete = "SELECT count(*) FROM reponse WHERE libelle = 'oui' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                nb = result.getInt(1);
            }
            return nb;
        } catch (SQLException ex) {
            Logger.getLogger(servicereponse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;
    }
}
