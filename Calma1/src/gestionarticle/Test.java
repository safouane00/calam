/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarticle;

import Entity.Article;
import Entity.Comment;
import Entity.Favoris;
import Service.ServiceArticle;
import Utils.DataSource;
import Service.ServiceComment;
import Service.ServiceFavoris;
import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.Date;

import java.text.SimpleDateFormat;

/**
 *
 * @author ayedmouna
 */
public class Test {


    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
         Connection cnx = DataSource.getInstance().getCnx();
         ServiceArticle sp = new ServiceArticle();
         ServiceComment c= new ServiceComment();
         ServiceFavoris f = new ServiceFavoris();
      
         java.util.Date myDate = new java.util.Date("01/06/2020");
java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
 {
             File file = new File("stress.jpg");
       
        

     sp.ajouter(new Article( "article16","des16","img16",(sqlDate), 10));
      sp.afficher().forEach(System.out::println);
     sp.file(file, new Article( "Faire la sieste ","Sieste et paresse sont souvent associées de réduire le stress.","img16",(sqlDate), 4));
      Article a1= new Article(23,"Stress et anxité","le stress aujourd'hui","stress.jpg",(sqlDate), 25);
     Article a3= new Article(12,"a8","des8","img",sqlDate,8);
        sp.supprimer(a1);     
      
           c.ajoutercomment(new Comment("Cet article est très interessant, c'est une nouvelle approche. Qu'en est-il de l'aspect physiologie? ",22));
          c.affichercomment().forEach(System.out::println);
          Comment c1 =new Comment(2,"ce article bien",12);
           c.ajoutercomment(c1);
           c.supprimercomment(c1);
         f.ajouterfavoris(new Favoris(24));
          f.afficherfavoris().forEach(System.out::println);
          Favoris f1= new Favoris(2,13);
          //f.ajouterfavoris(23);
        f.supprimerfavoris(f1);
        c.update(c1);
        sp.update(a1);
         sp.rechercher("a5");
         c.rechercher(2);
        f.rechercher(2);
       
       sp.trier_article().forEach(System.out::println);
        c.trier_comment().forEach(System.out::println);
       
       sp.mostliked().forEach(System.out::println);
    }
    
    }

}