/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Shop.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zribioussama
 */
public class connexion {
  
    String url = "jdbc:mysql://localhost:3306/Calma";
    String login = "root";
    String pwd = "";
    public  static connexion db;
    public Connection con;
    
        public connexion() {
            
         
        try {
            con = DriverManager.getConnection(url,login,pwd);
        } catch (SQLException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                System.out.println("connexion etablie");
            
        }

        public Connection  getConnection()
        {
            return con;
        }
        
        public static connexion getInstance()
        {if(db==null)
            db=new connexion();
            return db;
        }
     
}


