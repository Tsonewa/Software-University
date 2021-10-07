package com.example.hiberspring.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XMLParser {

   <T> T fromFIle(String filepath, Class<T> tClass) throws JAXBException, FileNotFoundException;

   <T> void writeToFile(String filePath, T entity) throws JAXBException;
}
