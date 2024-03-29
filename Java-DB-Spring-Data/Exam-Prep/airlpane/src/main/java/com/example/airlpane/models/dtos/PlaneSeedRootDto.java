package com.example.airlpane.models.dtos;

import com.example.airlpane.models.Plane;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneSeedRootDto {

    @XmlElement(name = "plane")
    private List<PlaneSeedDto> planes;

    public PlaneSeedRootDto() {
    }

    public PlaneSeedRootDto(List<PlaneSeedDto> planes) {
        this.planes = planes;
    }

    public List<PlaneSeedDto> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneSeedDto> planes) {
        this.planes = planes;
    }
}
