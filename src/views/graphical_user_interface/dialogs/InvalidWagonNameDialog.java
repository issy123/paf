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
public class InvalidWagonNameDialog extends Dialog{
    public InvalidWagonNameDialog(){
        alert.setHeaderText("The wagon name given is invalid.");
        alert.setContentText("You have given an invalid wagon name. Please use only alphabetic characters and numbers");
    }
}
