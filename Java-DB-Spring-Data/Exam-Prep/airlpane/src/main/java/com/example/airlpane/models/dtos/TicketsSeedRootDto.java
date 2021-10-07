package com.example.airlpane.models.dtos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsSeedRootDto {

    @XmlElement(name = "ticket")
    private List<TicketsSeedDto> tickets;

    public TicketsSeedRootDto() {
    }

    public TicketsSeedRootDto(List<TicketsSeedDto> tickets) {
        this.tickets = tickets;
    }

    public List<TicketsSeedDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketsSeedDto> tickets) {
        this.tickets = tickets;
    }
}
