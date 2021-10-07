package com.example.airlpane.models.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsSeedDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeoff;
    @XmlElement(name = "from-town")
    private TownFromTownNameDto fromTown;
    @XmlElement(name = "to-town")
    private TownToTownNameDto toTown;
    @XmlElement(name = "passenger")
    private PassengerEmailDto passenger;
    @XmlElement
    private PlaneRegisterNumberDto plane;

    public TicketsSeedDto() {
    }

    public TicketsSeedDto(String serialNumber, BigDecimal price, String takeoff, TownFromTownNameDto fromTown, TownToTownNameDto toTown, PassengerEmailDto passenger, PlaneRegisterNumberDto plane) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.takeoff = takeoff;
        this.fromTown = fromTown;
        this.toTown = toTown;
        this.passenger = passenger;
        this.plane = plane;
    }

    public PlaneRegisterNumberDto getPlane() {
        return plane;
    }

    public void setPlane(PlaneRegisterNumberDto plane) {
        this.plane = plane;
    }

    @Size(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public TownFromTownNameDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownFromTownNameDto fromTown) {
        this.fromTown = fromTown;
    }

    public TownToTownNameDto getToTown() {
        return toTown;
    }

    public void setToTown(TownToTownNameDto toTown) {
        this.toTown = toTown;
    }

    public PassengerEmailDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEmailDto passenger) {
        this.passenger = passenger;
    }
}
