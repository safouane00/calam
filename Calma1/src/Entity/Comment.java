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
public class Comment {
    private int comment_id;
    private String content;
    private int article_id;
    public Comment (int comment_id,String content,int article_id){
        this.comment_id=comment_id;
        this.content=content;
        this.article_id=article_id;
        
    }
     public Comment (String content,int article_id){
      
        this.content=content;
        this.article_id=article_id;
        
    }

    @Override
    public String toString() {
        return "Comment{" + "comment_id=" + comment_id + ", content=" + content + ", article_id=" + article_id + '}';
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public String getContent() {
        return content;
    }

    public int getArticle_id() {
        return article_id;
    }
   
    
}
