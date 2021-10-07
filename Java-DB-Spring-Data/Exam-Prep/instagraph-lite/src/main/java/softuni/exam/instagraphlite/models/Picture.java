package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    private String path;

    private Double size;

    private List<User> user;

    private List<Post> posts;

    public Picture() {
    }

    public Picture(String path, Double size, List<User> user, List<Post> posts) {
        this.path = path;
        this.size = size;
        this.user = user;
        this.posts = posts;
    }

    @Column(nullable = false, unique = true)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(nullable = false)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @OneToMany(mappedBy = "profilePicture", cascade = CascadeType.MERGE)
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "picture", targetEntity = Post.class, cascade = CascadeType.MERGE)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
