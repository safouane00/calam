/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import themetest.themetest;
import utils.DataSource;

/**
 *
 * @author Matoussi
 */
public class question {

    private String libelle;
    private int id_themetest;
    private Connection dbconx;
    private int id_question;

    public question(int id_themetest, String libelle) {
        this.dbconx = DataSource.getInstance().getCnx();
        this.id_themetest = id_themetest;
        this.libelle = libelle;
    }

    public question() {
    }
   

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_themetest() {
        return id_themetest;
    }

    public void setId_themetest(int id_themetest) {
        this.id_themetest = id_themetest;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    @Override
    public String toString() {
        return "question{" + "libelle=" + libelle + ", id_themetest=" + id_themetest + ", id_question=" + id_question + '}';
    }

    public List<String> getQuestions(int idTheme) {
        List<String> questions = new ArrayList<>();
        try {
            String requete = "SELECT * FROM question WHERE id_themetest = ? ";
            PreparedStatement pst = this.dbconx.prepareStatement(requete);
            pst.setInt(1, idTheme);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                questions.add(rs.getString("libelle"));
            }
            return questions;
        } catch (SQLException ex) {
            Logger.getLogger(question.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public int getIdByLibelle(String libelle) {
        try {
            String requete = "SELECT id_question FROM question WHERE libelle = ? AND id_themetest = ? ";
            PreparedStatement pst = this.dbconx.prepareStatement(requete);
            pst.setString(1, libelle);
            pst.setInt(2, this.getId_themetest());
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
