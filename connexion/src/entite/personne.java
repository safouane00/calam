/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.InputStream;

/**
 *
 * @author safouane
 */
public class personne {
    private int id ;
    private String login ; 
    private String mdp ;
    private String mail ;
    private InputStream image ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public personne(String login, String mdp, String mail, InputStream image) {
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
        this.image = image;
    }

    public personne(int id, String login, String mdp, String mail, InputStream image) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
        this.image = image;
    }

    @Override
    public String toString() {
        return "personne{" + "id=" + id + ", login=" + login + ", mdp=" + mdp + ", mail=" + mail + ", image=" + image + '}';
    }



    
  
    

  
    
    
    
    
}
