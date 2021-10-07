package Logger.src;

import Logger.core.EngineImpl;
import Logger.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


var reader = new BufferedReader(new InputStreamReader((System.in)));

        Logger logger = new MessageLogger();
        new EngineImpl(reader, logger).run();

        System.out.println(logger);
    }
}
