/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Article;
import java.io.File;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author ayedmouna
 */
public interface IService <T>{
    public void ajouter(T t);
    public void supprimer(T t);
    public void update(T t);
    public List<T> rechercher(String title);

    public List<T> afficher();
    public List<T> trier_article();
   // public void file(File f, T t);
    public List<T> mostliked();
    
}
