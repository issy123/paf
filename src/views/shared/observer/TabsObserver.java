/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.shared.observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import mechanics.TrainFacade;
import mechanics.TrainFacadeException;
import model.Train;
import views.shared.TrainCanvas;

/**
 *
 * @author ismail
 */
public class TabsObserver  implements Observer {
    TabPane trainTabs;
    int trainSize = 0;
    public TabsObserver(TabPane trainTabs){
        this.trainTabs = trainTabs;
    }
    @Override
    public void update(Observable o, Object arg) {
        TrainFacade trainFacade = (TrainFacade) o;
        ArrayList<Train> trains = trainFacade.getTrains();
        if(trains.size() > trainSize){
            trainSize = trains.size();
            Train train = trains.get(trains.size() - 1);
            TrainCanvas canvas = new TrainCanvas(train);
            o.addObserver(canvas);
            canvas.update(null, null);
            if(trains.size() == 1){
                trainTabs.getTabs().get(0).setContent(canvas);
                trainTabs.getTabs().get(0).setText(train.getName());
                return;
            }
            createTab(train.getName(),canvas);
        }
        if(trains.size() < trainSize){
            trainSize = trains.size();
            if(trains.size() == 0){
                trainTabs.getTabs().get(0).setContent(null);
                trainTabs.getTabs().get(0).setText("Unnamed train");
                return;
            }
            ObservableList<Tab> tabs = trainTabs.getTabs();
            for(int i =0; i < tabs.size();i++){
                if(i > trains.size()-1 || !tabs.get(i).getText().equals(trains.get(i).getName())){
                    closeTab(tabs.get(i).getText());
                }
            }
        }
        //WHEN NEW TRAIN IS CREATED, create a new tab:
        /*
        addObserver(canvas);
        Tab tab = Main.getController().createTab(name, canvas);
        
        */
        
        //WHEN TRAIN IS DELETED, DELETE TAB:
        /*
                Main.getController().closeTab(arguments[0]);
        */
    }
    
    /**
     * Create a tab.
     * @param name The tab name.
     * @param canvas The drawable canvas.
     * @return The created tab.
     */
    public Tab createTab(String name, TrainCanvas canvas) {
        Tab tab = new Tab(name, canvas);
        tab.setOnCloseRequest((e) -> {
            TrainFacade.getInstance().removeTrain(name);
        });
        trainTabs.getTabs().add(tab);
        trainTabs.getSelectionModel().select(tab);
        return tab;
    }

    /**
     * Close a tab programmatically.
     * @param name The name of the tab.
     */
    public void closeTab(String name) {
        for(Tab tab : FXCollections.observableArrayList(trainTabs.getTabs())) {
            if (tab.getText().equals(name)) {
                trainTabs.getTabs().remove(tab);
            }
        }
    }
}
