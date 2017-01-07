/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.graphical_user_interface.dialogs;

import javafx.scene.control.Alert;

/**
 *
 * @author ismail
 */
public abstract class Dialog {
    protected Alert alert;
    Dialog(){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
    }
    public void show(){
        alert.showAndWait();
    }
}
