package com.example.airlpane.service;

import com.example.airlpane.models.Town;

import java.io.IOException;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

    Town getTownByName(String town);
}
