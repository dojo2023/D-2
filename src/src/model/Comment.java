package model;
import java.io.Serializable;

public class Comment implements Serializable {
    private int commentId;
    private int articleId;
    private String userId;
    private String commentDate;
    private String commentText;

    public Comment(){
        this.commentId = 0;
        this.articleId = 0;
        this.userId = "";
        this.commentDate = "";
        this.commentText = "";
    }
    public Comment(int commentId, int articleId, String userId, String commentDate, String commentText){
        this.commentId = commentId;
        this.articleId = articleId;
        this.userId = userId;
        this.commentDate = commentDate;
        this.commentText = commentText;
        }
    
    public int getCommentId(){
        return commentId;
    }
    public void setCommentId(int commentId){
        this.commentId = commentId;
    }
    public int getArticleId(){
        return articleId;
    }
    public void setArticleId(int articleId){
        this.articleId = articleId;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getCommentDate(){
        return commentDate;
    }
    public void setCommentDate(String commentDate){
        this.commentDate = commentDate;
    }
    public String getCommentText(){
        return commentText;
    }
    public void setCommentText(String commentText){
        this.commentText = commentText;
    }
}
