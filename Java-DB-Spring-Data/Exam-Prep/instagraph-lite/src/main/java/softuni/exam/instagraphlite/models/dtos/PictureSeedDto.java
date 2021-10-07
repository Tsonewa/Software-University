package softuni.exam.instagraphlite.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PictureSeedDto {
@Expose
private String path;
@Expose
private Double size;

    public PictureSeedDto() {
    }

    public PictureSeedDto(String path, Double size) {
        this.path = path;
        this.size = size;
    }

    @NotBlank
    @NotNull
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @NotNull
    @Min(500)
    @Max(60000)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
