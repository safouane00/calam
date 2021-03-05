/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.personne;
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
import javax.swing.JOptionPane;

/**
 *
 * @author safouane
 */
public class servicePersonne implements Iservice<personne> {

    private Connection con = DataSource.getInstance().getConnection();

    private Statement ste;

    public servicePersonne() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public InputStream im() {

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

        InputStream imgg = null;

        try {
            imgg = new FileInputStream(new File(s));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(servicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }

        return imgg;

    }

    @Override
    public void ajouter(personne t) throws SQLException {
        t.setImage(im());
        String req1 = "INSERT INTO `personne` (`id`, `login`, `mail`, `mdp`,`image`) VALUES (NULL, '" + t.getLogin() + "', '" + t.getMail() + "', '" + t.getMdp() + "', '" + t.getImage() + "');";
        ste.executeUpdate(req1);
    }

    @Override
    public void supprimer(personne t) throws SQLException {
        String req1 = "DELETE FROM `personne` WHERE (id ='" + t.getId() + "');";
        ste.executeUpdate(req1);
    }

    @Override
    public void update(personne t) throws SQLException {
        String req1 = "UPDATE personne SET login ='" + t.getLogin() + "' ,mail ='" + t.getMail() + "', mdp ='" + t.getMdp() + "' WHERE (id ='" + t.getId() + "' ) ;";
        ste.executeUpdate(req1);
    }

    @Override
    public List<personne> readall1() throws SQLException {

        List<personne> list = new ArrayList<>();
        String req2 = "select * from personne ORDER BY mail ";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String login = rs.getString("login");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            InputStream image = rs.getBinaryStream("image");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            personne p = new personne(id, login, mail, mdp, image);
            list.add(p);
        }

        return list;
    }

    @Override
    public List<personne> readall2() throws SQLException {

        List<personne> list = new ArrayList<>();
        String req2 = "select * from personne ORDER BY login ";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String login = rs.getString("login");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            InputStream image = rs.getBinaryStream("image");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            personne p = new personne(id, login, mail, mdp, image);
            list.add(p);
        }

        return list;
    }

    @Override
    public List<personne> readall() throws SQLException {

        List<personne> list = new ArrayList<>();
        String req2 = "select * from personne";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String login = rs.getString("login");
            String mail = rs.getString(3);
            String mdp = rs.getString("mdp");
            InputStream image = rs.getBinaryStream("image");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            personne p = new personne(id, login, mail, mdp, image);
            list.add(p);
        }

        return list;
    }

    @Override
    public List<personne> readall4(String mail1) throws SQLException {

        List<personne> list = new ArrayList<>();
        String req2 = "select * FROM `personne` WHERE (mail ='" + mail1 + "');";

        ResultSet rs = ste.executeQuery(req2);
        while (rs.next()) {
            int id = rs.getInt(1);
            String login = rs.getString("login");
            String mail = rs.getString("mail");
            String mdp = rs.getString("mdp");
            InputStream image = rs.getBinaryStream("image");
            // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
            personne p = new personne(id, login, mail, mdp, image);
            list.add(p);
        }

        return list;
    }

}
