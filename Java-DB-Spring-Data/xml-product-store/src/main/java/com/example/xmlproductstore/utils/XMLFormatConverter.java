package com.example.xmlproductstore.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Component("xml_format_converter")
public class XMLFormatConverter implements FormatConverter {

    private boolean prettyPrint = false;

    @Override
    public String serialize(Object obj) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();

            marshaller.marshal(obj, sw);

            return sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;    }

    @Override
    public void serialize(Object obj, String fileName) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

        Marshaller marshaller = jaxbContext.createMarshaller();
            FileWriter fw = new FileWriter(fileName);

            marshaller.marshal(obj, fw);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String data, Class<T> toType) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));

            return (T) unmarshaller.unmarshal(inputStream);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserializeFromFile(String fileName, Class<T> toType) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

      return (T) unmarshaller.unmarshal((new FileInputStream(fileName)));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void setPrettyPrint() {
        this.prettyPrint = true;
    }
}
