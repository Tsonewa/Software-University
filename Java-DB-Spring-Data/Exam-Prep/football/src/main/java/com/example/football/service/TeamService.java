package com.example.football.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface TeamService {

    String importTeams() throws IOException;

    boolean areImported();

    String readTeamsXmlFile() throws JAXBException, FileNotFoundException;
}
