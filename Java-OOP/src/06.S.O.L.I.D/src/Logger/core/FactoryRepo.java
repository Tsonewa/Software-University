package Logger.core;

import Logger.controllers.AppenderWorkshop;
import Logger.controllers.LayoutWorkshop;
import Logger.interfaces.AppenderFactory;
import Logger.interfaces.LayoutFactory;

public class FactoryRepo {
    private static AppenderFactory appenderFactory;
    private static LayoutFactory layoutFactory;

    private FactoryRepo(){};

    public static  AppenderFactory getAppenderFactory(){
        if(appenderFactory == null){
            return appenderFactory = new AppenderWorkshop();
        }
        return appenderFactory;
    }

    public static LayoutFactory getLayoutFactory() {
        if(layoutFactory == null){
            return layoutFactory = new LayoutWorkshop();
        }
        return layoutFactory;
    }
}
