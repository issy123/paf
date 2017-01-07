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
public class EmptyTrainNameDialog extends Dialog{
    public EmptyTrainNameDialog(){
        alert.setHeaderText("No train name given.");
        alert.setContentText("You have not given any train name. please give us a name to use.");
    }
}
