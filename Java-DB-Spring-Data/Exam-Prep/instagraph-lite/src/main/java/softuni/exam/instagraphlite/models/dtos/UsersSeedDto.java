package softuni.exam.instagraphlite.models.dtos;

import com.google.gson.annotations.Expose;
import softuni.exam.instagraphlite.models.Picture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsersSeedDto {

    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String profilePicture;

    public UsersSeedDto() {
    }

    public UsersSeedDto(String username, String password, String profilePicture) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 18)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @NotBlank
    @Size(min = 4)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
