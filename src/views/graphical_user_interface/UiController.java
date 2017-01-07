/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.graphical_user_interface;

import views.command_line_interface.observer.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    public TabPane trainTabs;
    public TrainFacade trainFacade = TrainFacade.getInstance();
    private final CommandParser parser = CommandParser.getInstance();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerCreateTrainAction();
        registerAddWagonAction();
        registerRemoveWagonAction();
        trainTabs.getTabs().get(0).setText("Unnamed train");
        trainFacade.addObserver(new TabsObserver(trainTabs));
        wagonTypes.setItems(FXCollections.observableArrayList(
                new KeyValuePair("1", "Wagon"),
                new KeyValuePair("2", "Freight wagon"),
                new KeyValuePair("3", "Passenger wagon")
            )
        );
        wagonTypes.getSelectionModel().selectFirst();
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
            String newTrainName = this.trainName.getText().trim();
            //check if name has no spaces and only contains letters and numbers
            if(newTrainName.isEmpty() || !isValidName(newTrainName)){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                if(newTrainName.isEmpty()){
                    alert.setHeaderText("No train name given.");
                    alert.setContentText("You have not given any train name. please give us a name to use.");
                }else if(!isValidName(newTrainName)){
                    alert.setHeaderText("The train name given is invalid.");
                    alert.setContentText("You have given an invalid train name. Please use only alphabetic characters and numbers");
                }

                alert.showAndWait();
                trainName.setText("");
                return;
            }
            parser.parse("new train " + trainName.getText());
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
    public boolean isValidName(String s){
        String pattern= "^[a-zA-Z0-9]{1,3}$";
        return s.matches(pattern);
    }
}
