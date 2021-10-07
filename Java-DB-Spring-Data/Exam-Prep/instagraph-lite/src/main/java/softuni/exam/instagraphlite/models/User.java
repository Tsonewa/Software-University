package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String username;

    private String password;

    private Picture profilePicture;

    private List<Post> posts;

    public User() {
    }

    public User(String username, String password, Picture profilePicture, List<Post> posts) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.posts = posts;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToOne(targetEntity = Picture.class, optional = false)
    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }


    @OneToMany(mappedBy = "user", targetEntity = Post.class, fetch = FetchType.EAGER)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
