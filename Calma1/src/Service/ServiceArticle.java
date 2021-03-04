/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Article;
import Utils.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ayedmouna
 */
public class ServiceArticle implements IService<Article> {
   
        Connection cnx = DataSource.getInstance().getCnx();
        @Override
     public void ajouter(Article t) {
        try {
            String requete = "INSERT INTO article (title,description,image,date,nbr_like) VALUES ('" + t.getTitle()+ "','" + t.getDescription()+ "','" + t.getImage()+ "','" + t.getDate()+"','" + t.getNbr_like()+  "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("article ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        @Override
     public List<Article> afficher() {
        List<Article> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM article";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Article(rs.getInt(1), rs.getString("title"), rs.getString("description"),rs.getString("image"),rs.getDate("date"),rs.getInt(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
     
        
        
        @Override
        public void supprimer(Article t) {
        try {
            String requete = "DELETE FROM article WHERE article_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getArticle_id());
            pst.executeUpdate();
            System.out.println("Article supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public void update(Article t) {
        try {
            String requete = "UPDATE article SET title=?,description=? , image=?,date=?,nbr_like=? WHERE article_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(6, t.getArticle_id());
            pst.setString(1, t.getTitle());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getImage());
            pst.setDate(4, t.getDate());
            pst.setInt(5, t.getNbr_like());



            pst.executeUpdate();
            System.out.println("Article modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Article> rechercher(String title) {
         ArrayList<Article> list= new ArrayList<Article>();
            try {
               
            String requete = "SELECT * FROM article WHERE title = '"+title+"'  ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt(1), rs.getString("title"), rs.getString("description"),rs.getString("image"),rs.getDate("date"),rs.getInt(6)));
            }
             
            System.out.println("Article trouver ! son titre est"+list.get(0).getTitle());
              
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
             return list;
    }

    @Override
    public List<Article> trier_article() {
        List<Article> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM article order by date ASC ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt(1), rs.getString("title"), rs.getString("description"),rs.getString("image"),rs.getDate("date"),rs.getInt(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list; 
        }

     


    public void file(File f, Article t) {
        try{
           String requete = "INSERT INTO article (title,description,image,date,nbr_like) VALUES ('" + t.getTitle()+ "','" + t.getDescription()+ "','" + f.getPath()+ "','" + t.getDate()+"','" + t.getNbr_like()+  "')";
           Statement st = cnx.createStatement();
            st.executeUpdate(requete);
           System.out.println("article ajoutée !");

      } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
    }

   
    @Override
    public List<Article> mostliked() {
           
             ArrayList<Article> list= new ArrayList<>();
            try {
               
            String requete = "SELECT * FROM article WHERE nbr_like > 9 ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt(1), rs.getString("title"), rs.getString("description"),rs.getString("image"),rs.getDate("date"),rs.getInt(6)));
            }
             
            System.out.println("Articles les plus aimées !");
              
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
             return list;
            }
       
    
         

   

}