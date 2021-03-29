/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Personne;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author safouane
 */
public class servicePersonne implements Iservice<Personne> {

    private Connection con = DataSource.getInstance().getConnection();

    private Statement ste;

    public servicePersonne() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public String im() {

        String s = "";
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File("C:\\Users\\safou\\Desktop"));
        int result = filechooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("image ajouter");
            File selectedfile = filechooser.getSelectedFile();
            String path = selectedfile.getAbsolutePath();
            s = path;
        } else {
            if (result == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "t as rien choisi");
            }
        }

        return s;

    }

    @Override
    public void ajouter(Personne t) throws SQLException {
//        t.setImage(im());
        String req1 = "INSERT INTO `personne` (`id`, `nom`, `mail`, `mdp`,`image`,`type`, `prenom`,`sex`,`date`) VALUES (NULL, '" + t.getNom() + "', '" + t.getMail() + "', '" + t.getMdp() + "', '" + t.getImage() + "', '" + t.getType() + "', '" + t.getPrenom() + "', '" + t.getSex() + "', '" + t.getDate() + "');";
        ste.executeUpdate(req1);
    }

    @Override
    public void supprimer(Personne t) throws SQLException {
        String req1 = "DELETE FROM `personne` WHERE (mail ='" + t.getMail() + "');";
        ste.executeUpdate(req1);
    }

    @Override
    public void update(Personne t) throws SQLException {
        //        t.setImage(im());
        t.setImage(null);
        String req1 = "UPDATE personne SET login ='" + t.getNom() + "', '" + t.getMail() + "', '" + t.getMdp() + "', '" + t.getImage() + "', '" + t.getType() + "', '" + t.getPrenom() + "', '" + t.getSex() + "', '" + t.getDate() + "' WHERE (mail ='" + t.getMail() + "') ;";
        ste.executeUpdate(req1);
    }

    @Override
    public List<Personne> readall1() throws SQLException {

        ObservableList<Personne> list = FXCollections.observableArrayList();
        String req2 = "select * from personne ORDER BY mail ";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            String image = rs.getString("image");
            String type = rs.getString("type");
            String prenom = rs.getString("prenom");
            String sex = rs.getString("sex");
            Date date = rs.getDate("date");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            Personne p = new Personne(nom, prenom, date, sex, mdp, mail, image, type);
            list.add(p);
        }

        return list;
    }

    @Override
    public List<Personne> readall2() throws SQLException {

        ObservableList<Personne> list = FXCollections.observableArrayList();
        String req2 = "select * from personne ORDER BY login ";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            String image = rs.getString("image");
            String type = rs.getString("type");
            String prenom = rs.getString("prenom");
            String sex = rs.getString("sex");
            Date date = rs.getDate("date");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            Personne p = new Personne(nom, prenom, date, sex, mdp, mail, image, type);
            list.add(p);
        }

        return list;
    }

    @Override
    public List<Personne> readall() throws SQLException {

        ObservableList<Personne> list = FXCollections.observableArrayList();
        String req2 = "select * from personne";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            String image = rs.getString("image");
            String type = rs.getString("type");
            String prenom = rs.getString("prenom");
            String sex = rs.getString("sex");
            Date date = rs.getDate("date");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            Personne p = new Personne(nom, prenom, date, sex, mdp, mail, image, type);
            list.add(p);
        }

        return list;
    }

    @Override
    public List<Personne> readall4(String mail1) throws SQLException {

        ObservableList<Personne> list = FXCollections.observableArrayList();
        String req2 = "select * FROM `personne` WHERE (mail ='" + mail1 + "');";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            String image = rs.getString("image");
            String type = rs.getString("type");
            String prenom = rs.getString("prenom");
            String sex = rs.getString("sex");
            Date date = rs.getDate("date");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            Personne p = new Personne(nom, prenom, date, sex, mdp, mail, image, type);
            list.add(p);
        }

        return list;
    }

    @Override
    public String login(String mail, String pass) {

        try {
            String sql = "SELECT * FROM personne WHERE mail = '" + mail + "' AND mdp = '" + pass + "';";
            ResultSet resultSet = ste.executeQuery(sql);

            if (resultSet.next()) {

                return ("exist et " + resultSet.getString("type"));

            } else {
                return ("non exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return ("non exist");
        }

    }

}
