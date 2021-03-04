/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author ayedmouna
 */
public interface IServiceComment <Comment>{
     public void ajoutercomment(Comment t);
    public void supprimercomment(Comment t);
    public void modifiercomment(Comment t);
     public void update(Comment t);
         public List<Comment> rechercher(int article_id);


    public List<Comment> affichercomment();
     public List<Comment> trier_comment();
    
}
