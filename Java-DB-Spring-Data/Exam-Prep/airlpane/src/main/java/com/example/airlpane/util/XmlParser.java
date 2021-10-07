package com.example.airlpane.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

   <T> T fromFIle(String filepath, Class<T> tClass) throws JAXBException, FileNotFoundException;

   <T> void writeToFile(String filePath, T entity) throws JAXBException;
}
