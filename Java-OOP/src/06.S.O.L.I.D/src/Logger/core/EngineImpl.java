package Logger.core;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Engine;
import Logger.interfaces.InputParser;
import Logger.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class EngineImpl implements Engine {

    private boolean isRunning;
    private BufferedReader reader;
    private Logger logger;

    public EngineImpl(BufferedReader reader, Logger logger){
        this.reader = reader;
        this.logger = logger;
    }

    @Override
    public void run() throws IOException {
        this.isRunning = true;
        String line = reader.readLine();
        addAppenders(Integer.parseInt(line));

        while (this.isRunning){
        line = reader.readLine();
            String[] parse = InputParser.parse(line);
            if(!parse[0].equals("END")){
                logMessage(parse);
            }
            this.isRunning = !parse[0].equals("END");
        }
    }

    private void logMessage(String[] args) {
       ReportLevel reportLevel = ReportLevel.valueOf(args[0]);
       String date = args[1];
       String msg = args[2];

        switch (reportLevel){
            case INFO -> logger.logInfo(date, msg);
            case WARNING -> logger.logWarning(date, msg);
            case ERROR -> logger.logError(date, msg);
            case CRITICAL -> logger.logCritical(date, msg);
            case FATAL -> logger.logFatal(date, msg);
            default -> throw new IllegalStateException("Unknown enum value for " + reportLevel);
        }
    }

    private void addAppenders(int n) throws IOException {

        while (n-- > 0){
            String[] tokens = reader.readLine().split("\\s+");

            ReportLevel reportLevel = tokens.length == 3
                    ? ReportLevel.valueOf(tokens[2].toUpperCase())
                    : ReportLevel.INFO;

            Appender appender = FactoryRepo.getAppenderFactory().produce(tokens[0],
                    reportLevel, FactoryRepo.getLayoutFactory().produce(tokens[1]));

            logger.addAppender(appender);
        }
    }
}
