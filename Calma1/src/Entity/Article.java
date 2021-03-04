/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ayedmouna
 */
public class Article {
     private int article_id;
    private String title;
    private String description;
     private int nbr_like;
    private String image;
    private Date date;
      public Article(int article_id, String title, String description,String image,Date date,int nbr_like) {
       this.article_id=article_id;
       this.title=title;
       this.description=description;
       this.image=image;
       this.date=date;
       this.nbr_like=nbr_like;
       
    }
   public Article( String title, String description,String image,Date date,int nbr_like) {
      
       this.title=title;
       this.description=description;
       this.image=image;
          this.date=date;
       this.nbr_like=nbr_like;
    
    }

    @Override
    public String toString() {
        return "Article{" + "article_id=" + article_id + ", title=" + title + ", description=" + description + ", nbr_like=" + nbr_like + ", image=" + image + ", date=" + date + '}';
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getNbr_like() {
        return nbr_like;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }


    
    
}
