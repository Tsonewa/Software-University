package Logger.interfaces;

public interface Logger {

    void logInfo(String data, String massage);
    void logWarning(String data, String massage);
    void logError(String data, String massage);
    void logCritical(String data, String massage);
    void logFatal(String data, String massage);
    void addAppender(Appender appender);
}
