package com.example.airlpane.service.impl;

import com.example.airlpane.models.Ticket;
import com.example.airlpane.models.dtos.TicketsSeedRootDto;
import com.example.airlpane.models.dtos.TownFromTownNameDto;
import com.example.airlpane.models.dtos.TownToTownNameDto;
import com.example.airlpane.repository.PlaneRepository;
import com.example.airlpane.repository.TownRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.airlpane.repository.TicketRepository;
import com.example.airlpane.service.TicketService;
import com.example.airlpane.util.ValidationUtil;
import com.example.airlpane.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    public static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;
    private final TownRepository townRepository;
    private final PlaneRepository planeRepository;

    public TicketServiceImpl(ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper, TicketRepository ticketRepository, TownRepository townRepository, PlaneRepository planeRepository) {
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public boolean areImported() {

        return ticketRepository.count() < 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {

        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TicketsSeedRootDto ticketsSeedRootDto = xmlParser.fromFIle
                (TICKETS_FILE_PATH, TicketsSeedRootDto.class);

       ticketsSeedRootDto
                .getTickets()
                .stream()
                .filter(ticketsSeedDto -> {
                    boolean isValid = validationUtil.isValid(ticketsSeedDto)
                   //         && !isTownExist(ticketsSeedDto.getFromTown().getName());
                    //        && isFromTownExist(ticketsSeedDto.getFromTown().getName())
                      //      && isToTownExist(ticketsSeedDto.getToTown().getName());
                            && isTicketExist(ticketsSeedDto.getSerialNumber());

                    sb.append(isValid ?
                            String.format("Successfully import Ticket %s - %s",
                                    ticketsSeedDto.getFromTown(),
                                    ticketsSeedDto.getToTown())
                            : "Invalid Ticket")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(ticketsSeedDto -> {
                    Ticket ticket = modelMapper.map(ticketsSeedDto, Ticket.class);
//
//                    ticket.setFromTown(ticketRepository.findBySerialNumber(ticketsSeedDto.getSerialNumber()).getFromTown());
//                    ticket.setToTown(ticketRepository.findBySerialNumber(ticketsSeedDto.getSerialNumber()).getToTown());
//                    ticket.setPlane(planeRepository.findPlaneByRegisterNumber(ticketsSeedDto.getSerialNumber()));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String date = ticket.getTakeoff().format(formatter);

                    ticketsSeedDto.setTakeoff(date);

                    return ticketsSeedDto;
                }).map(
                        ticket -> modelMapper.map(ticket, Ticket.class)
                )
          .forEach(ticketRepository::save);

        return sb.toString();
    }

    private boolean isTownExist(String name){

        return ticketRepository.existsTicketByFromTownName(name);
    }

    private boolean isTicketExist(String serialNumber) {

    return ticketRepository.existsBySerialNumber(serialNumber);
    }

    private boolean isToTownExist(String name) {

        return townRepository.existsByName(name);
    }

    private boolean isFromTownExist(String name) {


        return townRepository.existsByName(name);
    }

}
