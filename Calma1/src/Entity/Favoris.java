/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ayedmouna
 */
public class Favoris {
     private int favoris_id;
    private int article_id;
    public Favoris( int favoris_id, int article_id) {
      
       this.favoris_id=favoris_id;
       this.article_id=article_id;
       
    }
    public Favoris(  int article_id) {
      
      
       this.article_id=article_id;
       
    }

    public int getFavoris_id() {
        return favoris_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setFavoris_id(int favoris_id) {
        this.favoris_id = favoris_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Favoris{" + "favoris_id=" + favoris_id + ", article_id=" + article_id + '}';
    }
    
}
