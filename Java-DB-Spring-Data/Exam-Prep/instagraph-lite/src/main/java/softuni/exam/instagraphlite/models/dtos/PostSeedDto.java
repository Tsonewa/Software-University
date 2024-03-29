package softuni.exam.instagraphlite.models.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedDto {

    @XmlElement
    private String caption;
    @XmlElement
    private UserUsernameDto user;
    @XmlElement
    private PicturePathDto picture;

    public PostSeedDto() {
    }

    public PostSeedDto(String caption, UserUsernameDto user, PicturePathDto picture) {
        this.caption = caption;
        this.user = user;
        this.picture = picture;
    }

    @NotNull
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public UserUsernameDto getUser() {
        return user;
    }

    public void setUser(UserUsernameDto user) {
        this.user = user;
    }

    @NotNull
    public PicturePathDto getPicture() {
        return picture;
    }

    public void setPicture(PicturePathDto picture) {
        this.picture = picture;
    }
}
