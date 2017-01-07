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
public class NoWagonSelectedDialog extends Dialog{
    public NoWagonSelectedDialog(){
        alert.setHeaderText("No wagon selected.");
        alert.setContentText("You have not selected a wagon from the dropdown. Select one");
    }
}
