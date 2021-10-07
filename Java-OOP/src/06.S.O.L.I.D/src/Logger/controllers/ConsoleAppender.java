package Logger.controllers;

import Logger.enums.ReportLevel;
import Logger.interfaces.Layout;
import Logger.src.AbstractAppender;

public class ConsoleAppender extends AbstractAppender {

public ConsoleAppender(ReportLevel reportLevel, Layout layout){
    super(reportLevel,layout);
}

    @Override
    protected String getType() {
        return "ConsoleAppender";
    }

    @Override
    public void append(String data, ReportLevel reportLevel, String massage) {
        System.out.println(this.getLayout().format(data, reportLevel, massage));
        this.incrementAppendsCount();
    }
}
