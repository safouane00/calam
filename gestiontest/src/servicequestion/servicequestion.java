/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicequestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import question.question;
import themetest.themetest;
import utils.DataSource;

/**
 *
 * @author Matoussi
 */
public class servicequestion implements Iquestion<question> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(question t) {
        try {
            String requete = "INSERT INTO question (libelle,id_themetest) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2, t.getId_themetest());
            pst.setString(1, t.getLibelle());
            pst.executeUpdate();
            System.out.println("Question ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(question t) {
        try {
            String requete = "DELETE FROM question WHERE id_question=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId_question());
            pst.executeUpdate();
            System.out.println("Question supprimée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(question t) {
        try {
            String requete = "UPDATE question SET libelle=? WHERE id_question =?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2, t.getId_question());
            pst.setString(1, t.getLibelle());
            pst.executeUpdate();
            System.out.println("Question modifiée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<question> afficher() {
        List<question> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM question";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new question(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public List<question> rechercher(String charac) {
        String requete = "select * from question where  id_themetest LIKE '%" + charac + "%'";
        List<question> listquestion = new ArrayList<>();
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rst = pst.executeQuery(requete);
            while (rst.next()) {
                question t = new question();
                t.setId_themetest(rst.getInt("id_themetest"));
                listquestion.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("aucun question disponible");
        }
        return listquestion;
    }
    

}
