/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Observable;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;

/**
 *
 * @author ismail
 */
public class Logger{
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger("logger");
        static {
        try {
//            Properties preferences = new Properties();
//            URL url = Logger.class.getClassLoader().getResource("logging.properties");
//            FileInputStream configFile = new FileInputStream(new File(url.toURI()));
//            preferences.load(configFile);
//            LogManager.getLogManager().readConfiguration(configFile);
            LOGGER.setUseParentHandlers(false);
//            LOGGER.addHandler(new FileHandler("console.log"));
//            LOGGER.addHandler(new TextAreaHandler());
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Log a message.
     * @param message The message to log.
     */
    public static void log(String message) {
        LOGGER.info(message);
    }
    public static void addHandler(Handler handler){
        LOGGER.addHandler(handler);
    }
}
