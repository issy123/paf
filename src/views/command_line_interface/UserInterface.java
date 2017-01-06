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
        primaryStage.setHeight(445);
        primaryStage.setWidth(800);
        primaryStage.setMaxHeight(445);
        primaryStage.setMaxWidth(950);
    }
}
