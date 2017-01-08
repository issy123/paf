/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.graphical_user_interface;

import views.shared.observer.TabsObserver;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import mechanics.CommandParser;
import mechanics.TrainFacade;
import model.Wagon;
import views.graphical_user_interface.dialogs.*;

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
    public Button deleteTrainButton;
    public TextField trainName;
    public Button createTrainButton;
    public Label trainLabel;
    public TabPane trainTabs;
    public TrainFacade trainFacade = TrainFacade.getInstance();
    public Dialog invalidTrainNameDialog = new InvalidTrainNameDialog();
    public Dialog emptyTrainNameDialog = new EmptyTrainNameDialog();
    public Dialog invalidWagonNameDialog = new InvalidWagonNameDialog();
    public Dialog emptyWagonNameDialog = new EmptyWagonNameDialog();
    public Dialog noWagonSelectedDialog = new NoWagonSelectedDialog();
    private final CommandParser parser = CommandParser.getInstance();
    private String currentTrain;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerCreateTrainAction();
        registerAddWagonAction();
        registerRemoveWagonAction();
        registerDeleteTrainAction();
        registerChangeTabAction();
        trainTabs.getTabs().get(0).setText("Unnamed train");
        trainFacade.addObserver(new TabsObserver(trainTabs));
        wagonTypes.setItems(FXCollections.observableArrayList(
                new KeyValuePair("", "Wagon"),
                new KeyValuePair(" freight", "Freight wagon"),
                new KeyValuePair(" passenger", "Passenger wagon")
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
                if(newTrainName.isEmpty()){
                    emptyTrainNameDialog.show();
                }else if(!isValidName(newTrainName)){
                    invalidTrainNameDialog.show();
                }
                
                trainName.setText("");
                return;
            }
            parser.parse("new train " + newTrainName);
            if(trainFacade.getTrains().size() != 0){
                addWagonButton.setDisable(false);
                deleteTrainButton.setDisable(false);
                displayCurrentTrainName();
            }
            trainName.setText("");
        });
    }
    public void registerAddWagonAction(){
        addWagonButton.setOnAction((e) -> {
            String newWagonName = this.wagonName.getText().trim();
            //check if name has no spaces and only contains letters and numbers
            if(newWagonName.isEmpty() || !isValidName(newWagonName)){
                if(newWagonName.isEmpty()){
                    emptyWagonNameDialog.show();
                }else if(!isValidName(newWagonName)){
                    invalidWagonNameDialog.show();
                }
                
                wagonName.setText("");
                return;
            }
            KeyValuePair wagonType = (KeyValuePair) wagonTypes.getSelectionModel().getSelectedItem();
            parser.parse("new" + wagonType.getKey() + " wagon " + newWagonName);
            parser.parse("add " + newWagonName + " to " + trainTabs.getSelectionModel().getSelectedItem().getText());
            wagonName.setText("");
            updateWagonsList();
        });
        
    }
    public void registerRemoveWagonAction(){
        removeWagonButton.setOnAction((e) -> {
            String wagonName = wagonDropdown.getSelectionModel().getSelectedItem().toString();
            if(wagonName == null){
                noWagonSelectedDialog.show();
                return;
            }
            parser.parse("remove " + wagonName + " from " + currentTrain);
            updateWagonsList();
        });
        
    }
    public void registerDeleteTrainAction(){
        deleteTrainButton.setOnAction((e) -> {
            parser.parse("delete train " + currentTrain);
        });
        
    }
    public void registerChangeTabAction(){
        trainTabs.getSelectionModel().selectedItemProperty().addListener((e) ->{
            displayCurrentTrainName();
        });
    }
    public void displayCurrentTrainName(){
            currentTrain = trainTabs.getSelectionModel().getSelectedItem().getText();
            trainLabel.setText("Train: " + currentTrain);
        
    }
    public void updateWagonsList(){
        wagonDropdown.getItems().clear();
        List<Wagon> wagons = trainFacade.getTrain(currentTrain).getWagons();
        if(wagons.isEmpty()){
            removeWagonButton.setDisable(true);
        }else{
            removeWagonButton.setDisable(false);
        }
        for(int i = 0; i < wagons.size();i++){
            wagonDropdown.getItems().add(wagons.get(i).getName());
        }
    }
    
    public boolean isValidName(String s){
        String pattern= "^[a-zA-Z0-9]{2,}$";
        return s.matches(pattern);
    }
}
