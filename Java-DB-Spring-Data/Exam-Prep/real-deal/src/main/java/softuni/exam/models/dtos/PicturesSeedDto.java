package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class PicturesSeedDto {

    @Expose
    private String name;
    @Expose
    private String dateAndTime;
    @Expose
    private Long car;

    public PicturesSeedDto() {
    }

    public PicturesSeedDto(String name, String dateAndTime, Long car) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.car = car;
    }

    @Size(min = 2, max = 19)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}
