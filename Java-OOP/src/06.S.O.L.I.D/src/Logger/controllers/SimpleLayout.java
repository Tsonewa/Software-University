package Logger.controllers;

import Logger.enums.ReportLevel;
import Logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String data, ReportLevel reportLevel, String massage) {
        return String.format("%s - %s - %s", data, reportLevel, massage);
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
