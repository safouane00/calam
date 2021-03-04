/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Comment;
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
public class ServiceComment implements IServiceComment<Comment>{
        Connection cnx = DataSource.getInstance().getCnx();
        @Override
        public void ajoutercomment(Comment t) {
        try {
            String requete = "INSERT INTO comment (comment_id,content,article_id) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getComment_id());
            pst.setString(2, t.getContent());
            pst.setInt(3, t.getArticle_id());
            pst.executeUpdate();
            System.out.println("comment ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

        @Override
        public void supprimercomment(Comment t) {
        try {
            String requete = "DELETE FROM comment WHERE comment_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getComment_id());
            pst.executeUpdate();
            System.out.println("comment supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
        @Override
    public void modifiercomment(Comment t) {
        try {
            String requete = "UPDATE comment SET content=?,article_id=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(3, t.getComment_id());
            pst.setString(1, t.getContent());
            pst.setInt(2, t.getArticle_id());
            pst.executeUpdate();
            System.out.println("Comment modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
        @Override
    public List<Comment> affichercomment() {
        List<Comment> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM comment";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt(1), rs.getString("content"), rs.getInt(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void update(Comment t) {
         try {
            String requete = "UPDATE comment SET content=?,article_id=? WHERE comment_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(3, t.getComment_id());
            pst.setString(1, t.getContent());
            pst.setInt(2, t.getArticle_id());
           



            pst.executeUpdate();
            System.out.println("Comment modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Comment> rechercher(int article_id) {
         ArrayList<Comment> list= new ArrayList<>();
            try {
               
            String requete = "SELECT * FROM comment WHERE article_id = '"+article_id+"'  ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt(1), rs.getString("content"), rs.getInt(3)));
            }
             
            System.out.println("Comment trouver dans l article" + list.get(0).getArticle_id());
              
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
             return list;
    }

    @Override
    public List<Comment> trier_comment() {
        List<Comment> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM comment order by article_id ASC ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt(1), rs.getString("content"), rs.getInt(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list; 
    }
    
}
