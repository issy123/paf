/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.command_line_interface;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import javafx.scene.Parent;
import mechanics.CommandParser;

/**
 *
 * @author ismail
 */
public class UserInterface extends Application{
    private mechanics.Main mechanics = new mechanics.Main();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        mechanics.start();
        FXMLLoader loader = new FXMLLoader(new URL("file:src/views/command_line_interface/ui.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Commandline interface");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        primaryStage.setHeight(500);
        primaryStage.setWidth(800);
        primaryStage.setMaxHeight(520);
        primaryStage.setMaxWidth(950);
        
        CommandParser.getInstance().parse("delete train tr1");
        CommandParser.getInstance().parse("new train train1");
        CommandParser.getInstance().parse("new train train1");
        CommandParser.getInstance().parse("remove wagon1 from train1");
        CommandParser.getInstance().parse("new wagon wagon1");
        CommandParser.getInstance().parse("new wagon wagon1");
        CommandParser.getInstance().parse("add wagon1 to train1");
        CommandParser.getInstance().parse("new passenger wagon passenger1");
        CommandParser.getInstance().parse("add passenger1 to train1");
        CommandParser.getInstance().parse("new freight wagon freight1");
        CommandParser.getInstance().parse("new freight wagon freight1");
        CommandParser.getInstance().parse("add freight1 to train1");
        CommandParser.getInstance().parse("add freight1 to train1");
        CommandParser.getInstance().parse("getnumseats wagon wagon1");
    }
}
