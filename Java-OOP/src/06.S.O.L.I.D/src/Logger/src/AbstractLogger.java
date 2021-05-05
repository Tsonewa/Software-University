package Logger.src;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public  class AbstractLogger implements Logger {
    private List<Appender> appenders;

    public AbstractLogger(Appender... appenders){
        this.appenders = new ArrayList<>(Arrays.asList(appenders));
    }

    @Override
    public void logInfo(String data, String massage) {
        callAllAppenders(data, ReportLevel.INFO, massage);

    }

    @Override
    public void logWarning(String data, String massage) {
        callAllAppenders(data, ReportLevel.WARNING, massage);

    }

    @Override
    public void logError(String data, String massage) {
        callAllAppenders(data, ReportLevel.ERROR, massage);

    }

    @Override
    public void logCritical(String data, String massage) {
        callAllAppenders(data, ReportLevel.CRITICAL, massage);

    }

    @Override
    public void logFatal(String data, String massage) {
        callAllAppenders(data, ReportLevel.FATAL, massage);

    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    private void callAllAppenders(String data, ReportLevel reportLevel, String massage){
        for (Appender appender: this.appenders) {
            if (appender.getReportLevel().ordinal() <= reportLevel.ordinal()) {
                appender.append(data, reportLevel, massage);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info")
                .append(System.lineSeparator());

        builder.append(this.appenders.stream().map(Appender::toString).collect(Collectors.joining(System.lineSeparator())));

        return builder.toString();
    }
}
