package Logger.interfaces;

import Logger.enums.ReportLevel;

public interface Appender {

    void append(String data, ReportLevel reportLevel, String massage);

    ReportLevel getReportLevel();
}
