package com.example.hiberspring.util;

import org.springframework.stereotype.Component;

import java.io.IOException;


public interface FileUtil {

    String readFile(String filePath) throws IOException;
}
