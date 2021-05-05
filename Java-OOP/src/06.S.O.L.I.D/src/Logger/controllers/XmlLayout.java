package Logger.controllers;

import Logger.enums.ReportLevel;
import Logger.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String data, ReportLevel reportLevel, String massage) {
        return String.format("<log>%n" +
                "<date>%s</date> %n" +
                "<level>%s</level> %n" +
                "<message>%s %n" +
                "</log>", data, reportLevel.toString(), massage);
    }

    @Override
    public String getType() {
        return "XmlLayout";
    }
}
