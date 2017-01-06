/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.command_line_interface;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javafx.scene.control.TextArea;

/**
 *
 * @author ismail
 */
public class LogHandler extends Handler{
    UiController uiController;
    public LogHandler(UiController uiController){
        this.uiController = uiController;
    }
    @Override
    public void publish(LogRecord record) {
        this.uiController.output(record.getMessage());
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
    
}
