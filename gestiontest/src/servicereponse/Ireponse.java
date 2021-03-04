/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicereponse;

import java.util.List;

/**
 *
 * @author Matoussi
 * @param <T>
 */
public interface Ireponse<T> {

    public void ajouter(T t);

    public void supprimer(T t);

    public void modifier(T t);

    public List<T> afficher();
}
