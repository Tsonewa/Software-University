package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    private String caption;

    private User user;

    private Picture picture;

    public Post() {
    }

    public Post(String caption, User user, Picture picture) {
        this.caption = caption;
        this.user = user;
        this.picture = picture;
    }

    @Column(nullable = false)
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    @ManyToOne(targetEntity = User.class, optional = false, cascade = CascadeType.MERGE)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne(targetEntity = Picture.class, optional = false, cascade = CascadeType.MERGE)
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}