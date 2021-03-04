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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
 @Override
    public void ajouter(personne t) throws SQLException {

         String req1 = "INSERT INTO `personne` (`id`, `login`, `mail`, `mdp`) VALUES (NULL, '"+t.getLogin()+"', '"+t.getMail()+"', '"+t.getMdp()+"');";
        ste.executeUpdate(req1);    
    }

    @Override
    public void supprimer(personne t) throws SQLException {
        String req1 = "DELETE FROM `personne` WHERE (id ='"+t.getId()+"');";
        ste.executeUpdate(req1);
}
    @Override
    public void update(personne t) throws SQLException {
        String req1 = "UPDATE personne SET login ='"+t.getLogin()+"' ,mail ='"+t.getMail()+"', mdp ='"+t.getMdp()+"' WHERE (id ='"+t.getId()+"' ) ;";
        ste.executeUpdate(req1);      }

    @Override
    public List<personne> readall() throws SQLException {
        
        List<personne> list=new ArrayList<>();
        String req2 = "select * from personne";

      
            ResultSet rs = ste.executeQuery(req2);
            while (rs.next()) {
                int id = rs.getInt(1);
                String login = rs.getString("login");
                String mail = rs.getString(3);
                String mdp = rs.getString("mdp");
               // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
              personne p=new personne(id, login, mail , mdp);
            list.add(p);
            }
        
        return list;
    }

}
