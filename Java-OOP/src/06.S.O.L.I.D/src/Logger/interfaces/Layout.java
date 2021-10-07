package Logger.interfaces;

import Logger.enums.ReportLevel;

public interface Layout {

    String format(String data, ReportLevel reportLevel, String massage);

    String getType();
}
