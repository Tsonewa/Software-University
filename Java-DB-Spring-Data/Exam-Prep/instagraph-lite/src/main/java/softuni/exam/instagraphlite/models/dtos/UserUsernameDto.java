package softuni.exam.instagraphlite.models.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserUsernameDto {

    @XmlElement
    private String username;

    public UserUsernameDto() {
    }

    public UserUsernameDto(String username) {
        this.username = username;
    }

    @NotNull
    @Size(min = 2, max = 18)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
