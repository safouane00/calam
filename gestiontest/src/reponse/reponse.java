/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DataSource;

/**
 *
 * @author Matoussi
 */
public class reponse {

    private int id_reponse;
    private boolean libelle;
    private int id_question;
    private Connection dbconx;
    
    public reponse(int id_reponse, boolean libelle, int id_question){
        this.id_reponse = id_reponse;
        this.libelle = libelle;
        this.id_question = id_question;
    }

    public reponse() {
    }

    public void setId_question(int id_question) {
        this.dbconx = DataSource.getInstance().getCnx();
        this.id_question = id_question;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public boolean isLibelle() {
        return libelle;
    }

    public void setLibelle(boolean libelle) {
        this.libelle = libelle;
    }

    public int getId_question() {
        return id_question;
    }

    @Override
    public String toString() {
        return "reponse{" + "id_reponse=" + id_reponse + ", libelle=" + libelle + ", id_question=" + id_question + '}';
    }
    
    public int getResponseByQuestionId(int questionId) {
        try {
            String requete = "SELECT libelle FROM reponse WHERE id_question = ? ";
            PreparedStatement pst = this.dbconx.prepareStatement(requete);
            pst.setInt(1, questionId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int val = (rs.getBoolean(1)) ? 1 : 0;
                return val;
            }

            return -1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return -1;
    }
    
}
