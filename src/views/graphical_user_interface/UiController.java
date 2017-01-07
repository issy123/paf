/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.graphical_user_interface;

import views.command_line_interface.observer.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    public TextField wagonName;
    public ChoiceBox wagonTypes;
    public Button addWagonButton;
    public ChoiceBox wagonDropdown;
    public Button removeWagonButton;
    public TextField trainName;
    public Button createTrainButton;
    public Label trainLabel;
    private final CommandParser parser = CommandParser.getInstance();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerCreateTrainAction();
        registerAddWagonAction();
        registerRemoveWagonAction();
//        input.setOnKeyPressed((e) -> {
//            if (e.getCode().equals(KeyCode.ENTER)) {
//                String command = input.getText();
//                if(command.isEmpty()){
//                    return;
//                }
//                output(command);
//                String parse = parser.parse(command);
//                if(!parse.isEmpty()){
//                    output(parse);
//                }
//                input.setText("");
//            }
//        });
//        trainTabs.getTabs().get(0).setText("Unnamed train");
//        TrainFacade.getInstance().addObserver(new TabsObserver(trainTabs));
//        ObjectViewObserver objectViewObserver = new ObjectViewObserver(objectView);
//        objectViewObserver.update(TrainFacade.getInstance(), null);
//        TrainFacade.getInstance().addObserver(objectViewObserver);
////        Logger.addHandler(new LogHandler(this));
    }
    public void registerCreateTrainAction(){
        createTrainButton.setOnAction((e) -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message for you!");

            alert.showAndWait();
            System.out.println("create train button pressed");
        });
    }
    public void registerAddWagonAction(){
        addWagonButton.setOnAction((e) -> {
            System.out.println("add wagon button pressed");
        });
        
    }
    public void registerRemoveWagonAction(){
        removeWagonButton.setOnAction((e) -> {
            System.out.println("remove wagon button pressed");
        });
        
    }    
}
