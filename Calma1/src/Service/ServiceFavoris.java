/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Comment;
import Entity.Favoris;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayedmouna
 */
public class ServiceFavoris implements IServiceFavoris<Favoris> {
            Connection cnx = DataSource.getInstance().getCnx();
            @Override
            public void ajouterfavoris(Favoris t) {
        try {
            String requete = "INSERT INTO favoris (favoris_id,article_id) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getFavoris_id());
            pst.setInt(2, t.getArticle_id());
            pst.executeUpdate();
            System.out.println("Favoris ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
            @Override
    public List<Favoris> afficherfavoris() {
        List<Favoris> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM favoris";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Favoris(rs.getInt(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
            @Override
    public void supprimerfavoris(Favoris t) {
        try {
            String requete = "DELETE FROM favoris WHERE favoris_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getFavoris_id());
            pst.executeUpdate();
            System.out.println("favoris supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
            @Override
        public void modifierfavoris( Favoris t) {
        try {
            String requete = "UPDATE favoris SET article_id=? WHERE favoris_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2, t.getFavoris_id());
            pst.setInt(1, t.getArticle_id());
            pst.executeUpdate();
            System.out.println("favoris modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Favoris> rechercher(int favoris_id) {
        ArrayList<Favoris> list= new ArrayList<Favoris>();
            try {
               
            String requete = "SELECT * FROM favoris WHERE favoris_id = '"+favoris_id+"'  ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Favoris(rs.getInt(1), rs.getInt(2)));
            }
             
            System.out.println("Favoris trouver !"+list.get(0).getFavoris_id());
              
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
             return list;
    }



    
}
