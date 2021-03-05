/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Shop.Produit;
import Entities.Shop.Util.connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zribioussama
 */
public class serviceProduit implements IServices{
    
     Connection c = connexion.getInstance().getConnection();
        Statement st;
        
        public void ajouterProduit(Produit p) throws SQLException
        {
           
                st = c.createStatement();
                String req = "INSERT INTO Produit VALUES(null,"+ p.getName()+",'"+p.getPrice()+"','"+ p.getStock()+  ")";

                st.executeUpdate(req);
      
        }
    

    public void modifierProduit(int pid, String name, double price, int stock) throws SQLException {

           
            PreparedStatement pst = c.prepareStatement("update Produit set  name=?, price=?, stock=? where PID=?");
            pst.setString(1,name);
            pst.setDouble(2,price);
            pst.setInt(3,stock);
            pst.setInt(4,pid);
            
            pst.execute();
    }        
     
    public void afficherProduit() throws SQLException{
            PreparedStatement pt;
        
                pt = c.prepareStatement("SELECT * FROM Produit");

                ResultSet rs = pt.executeQuery();

                while (rs.next()){
                    System.out.printf("PID num %d , produit %s pour %f dt valable %d jours %n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
                }
           
        }
    
    public void supprimerEnseignant( int pid) throws SQLException{
            PreparedStatement pt;
            
                pt = c.prepareStatement("DELETE FROM Produit WHERE PID =?");
                pt.setInt(1,pid);
                pt.execute();
           
        }
    

    public void rechercherProduit(int pid) throws SQLException{

            PreparedStatement ps ;
      
                ps= c.prepareStatement("SELECT * FROM Produit WHERE PID =?");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    System.out.println("Le produit sous ID num  "+rs.getInt(1)+" ,  "+rs.getString(2));
                }
            

        }

    @Override
    public void ajouterProduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierProduit(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficherProduit(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rechercherProduit(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}