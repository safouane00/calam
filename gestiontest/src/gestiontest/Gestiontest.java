/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontest;

import static java.lang.Boolean.parseBoolean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import question.question;
import reponse.reponse;
import servicequestion.servicequestion;
import servicereponse.servicereponse;
import servicethemetest.servicethemetest;
import themetest.themetest;
import utils.DataSource;

/**
 *
 * @author Matoussi
 */
public class Gestiontest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("enter theme name:");
        Scanner in = new Scanner(System.in);
        String themeName = in.nextLine();
        servicethemetest insthemetest = new servicethemetest();
        themetest insttheme = new themetest();
        insttheme.setNom(themeName);
        insthemetest.ajouter(insttheme);

        System.out.println("entrer un question");
        Scanner on = new Scanner(System.in);
        String qst = on.nextLine();
        servicequestion insservquestion = new servicequestion();
        int idTheme = insttheme.getIdByName(themeName);
        System.out.println(idTheme);
        question insquestion = new question(idTheme, qst);
        insservquestion.ajouter(insquestion);

        List<String> questions = new ArrayList<>();
        questions = insquestion.getQuestions(idTheme);
        servicereponse insservrep = new servicereponse();
        reponse insrep = new reponse();
        int answer = 0;
        for (int i = 0; i < questions.size(); i++) {
            String question = questions.get(i);
            int idQst = insquestion.getIdByLibelle(question);
            insrep.setId_question(idQst);

            System.out.println(question);
            System.out.println("entrer votre reponse: enter 0 pour non et 1 pour oui");
            Scanner rp = new Scanner(System.in);
            String rep = rp.nextLine();

            insrep.setLibelle(parseBoolean(rep));
            insservrep.ajouter(insrep);

            if (parseBoolean(rep)) {
                answer += 1;
            }
        }
        float score = answer / questions.size();
        if (score > (questions.size() / 2)) {
            System.out.println("you are happy");
        } else {
            System.out.println("you are sad");
        }
//**************************************
//        servicethemetest st = new servicethemetest();
//        st.ajouter(new themetest(1,"social life"));
//        st.modifier(new themetest(1, "Home life"));
//        st.supprimer(new themetest(1, ""));
//        st.afficher().forEach(System.out::println);
//        servicereponse sr = new servicereponse();
//        System.out.println(sr.nbOUIReponseTotal());
//        sr.ajouter(new reponse(1, true));
//        servicequestion sq = new servicequestion();
//        question qst = new question(6, "fathi");
//        sq.ajouter(qst);
//       sq.afficher().forEach(System.out::println);
//        sq.ajouter(new question(1, "question1"));
//        sq.rechercher("6").forEach(System.out::println);
//        DataSource connection = new DataSource();
//        themetest tt = new themetest();
//        System.out.println(tt.getidbyname("social life"));
    }

}
