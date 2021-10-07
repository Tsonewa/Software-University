package Logger.controllers;

import Logger.enums.ReportLevel;
import Logger.interfaces.File;
import Logger.interfaces.Layout;
import Logger.src.AbstractAppender;

public class FileAppander extends AbstractAppender {
    private File file;

    public FileAppander(ReportLevel reportLevel, Layout layout) {
super(reportLevel, layout);
this.file = new LogFile();
}
    @Override
    protected String getType() {
        return "FileAppander";
    }

    @Override
    public void append(String data, ReportLevel reportLevel, String massage) {
    String formatted = this.getLayout().format(data, reportLevel, massage);
    this.file.write(formatted);
    super.incrementAppendsCount();
    }

    @Override
    public String toString() {
        return super.toString() + "File size: " + this.file.getSize();
    }
}
