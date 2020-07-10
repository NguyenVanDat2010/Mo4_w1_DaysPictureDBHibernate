package days.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long score;
    private String author;
    private String feedback;
    private Long likes;

    @CreationTimestamp
    private Timestamp created_at;

    @UpdateTimestamp
    private Timestamp updated_at;



    public Picture() {
    }

    public Picture(Long id, Long score, String author, String feedback, Long likes) {
        this.id = id;
        this.score = score;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
    }

    public Picture(Long score, String author, String feedback, Long likes) {
        this.score = score;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }
}
