package Logger.controllers;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.AppenderFactory;
import Logger.interfaces.Layout;

public class AppenderWorkshop implements AppenderFactory {

    @Override
    public Appender produce(String type, ReportLevel reportLevel, Layout layout) {
        return switch (type){
            case "ConsoleAppender" -> new ConsoleAppender(reportLevel, layout);
            case "FileAppender" -> new FileAppander(reportLevel, layout);
            default -> throw new IllegalStateException("Not valid type of appender for " + type + " param");
        };
    }
}
