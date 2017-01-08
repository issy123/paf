/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.command_line_interface;

import views.shared.observer.TabsObserver;
import views.command_line_interface.observer.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;

/**
 *
 * @author ismail
 */
public class UiController implements Initializable {
    public TextArea objectView;
    public TextArea commandOutput;
    public TabPane trainTabs;
    public TextField input;
    private final CommandParser parser = CommandParser.getInstance();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        input.setOnKeyPressed((e) -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                String command = input.getText();
                if(command.isEmpty()){
                    return;
                }
                output(command);
                String parse = parser.parse(command);
                if(!parse.isEmpty()){
                    output(parse);
                }
                input.setText("");
            }
        });
        trainTabs.getTabs().get(0).setText("Unnamed train");
        TrainFacade.getInstance().addObserver(new TabsObserver(trainTabs));
        ObjectViewObserver objectViewObserver = new ObjectViewObserver(objectView);
        objectViewObserver.update(TrainFacade.getInstance(), null);
        TrainFacade.getInstance().addObserver(objectViewObserver);
        Logger.addHandler(new LogHandler(this));
    }
    
    public void output(String text){
        if(commandOutput.getText().isEmpty()){
            commandOutput.setText(text);
        }else{
            commandOutput.appendText("\n" + text);
        }
        commandOutput.selectPositionCaret(commandOutput.getLength()); 
        commandOutput.deselect(); 
    }
    
}
