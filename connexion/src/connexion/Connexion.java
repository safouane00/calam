/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import service.servicePersonne;
import entite.Personne;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 *
 * @author safouane
 */
public class Connexion {

    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/jdbc", pwd = "", login = "root";
    private static Statement ste;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        servicePersonne ser = new servicePersonne();
        String o = ser.im() ;
        Scanner sc = new Scanner(System.in);
        Personne p1 = new Personne("mohamed", "sana", "safouane", null,null);
        int x = 100;
        while (x != 0) {

            System.out.println("1. ajouter \n2. supp \n3.update \n4.afficher \n0.quitter \n ");

//            ser.im();
            x = sc.nextInt();

            String str = sc.nextLine();
            switch (x) {
                case 1: {

                    try {
                        System.out.println("entrer login");
                        p1.setLogin(sc.nextLine());
                        System.out.println("entrer mail");
                        p1.setMail(sc.nextLine());
                        System.out.println("entrer mdp");
                        p1.setMdp(sc.nextLine());
                        ser.ajouter(p1);
                        System.out.println("element insérer");
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                    break;
                }
                case 2:

                    try {
                        System.out.println("entrer id a supp");
                        p1.setId(sc.nextInt());
                        ser.supprimer(p1);
                        System.out.println("element supprimer");
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                    break;

                case 3:
                    try {
                        Scanner s = new Scanner(System.in);
                        Scanner y = new Scanner(System.in);
                        Scanner m = new Scanner(System.in);
                        System.out.println("entrer id a modifier");
                        p1.setId(s.nextInt());
                        System.out.println("entrer nouv login");
                        p1.setLogin(sc.nextLine());
                        System.out.println("entrer nouv mail");
                        p1.setMail(y.nextLine());
                        System.out.println("entrer nouv mdp");
                        p1.setMdp(m.nextLine());
                        ser.update(p1);
                        System.out.println("element modifier");
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                    break;

                case 4:
                    List<Personne> list = null;

                    System.out.println(" 1.trie par mail \n 2.trie par login \n 3.afficher tel qu'il est \n 4.afficher user specifier");
                    int y = sc.nextInt();
                    if (y == 1) {
                        try {
                            list = ser.readall1();
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    } else if (y == 2) {
                        try {
                            list = ser.readall2();
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    } else if (y == 3) {
                        try {
                            list = ser.readall();
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    } else if (y == 4) {
                        try {
                            Scanner s = new Scanner(System.in);
                            System.out.println("entrer mail");
                            String st = s.nextLine();
                            list = ser.readall4(st);
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    }

                    list.forEach((e) -> System.out.println(e));
                    break;

            }

        }

//        try {
//            ser.ajouter(p1);
//            System.out.println("element insérer");
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        List<personne> list = null;
//
//        try {
//            list = ser.readall();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//
//        list.forEach((e) -> System.out.println(e));
    }

}
