/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import service.servicePersonne;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class AuthentifierController implements Initializable {

    @FXML
    private PasswordField tmdp;
    @FXML
    private TextField tmail;
    @FXML
    private Label result;
    @FXML
    private Button btnlogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        servicePersonne ser = new servicePersonne();
        String bool = ser.login(tmail.getText(), tmdp.getText());
        if (bool.equals("exist et admin")) {
            result.setText("connected succefully admin");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Ajout.fxml"));
            Parent root = loader.load();
            tmail.getScene().setRoot(root);
            
        } else if (bool.equals("exist et user")) {
            result.setText("connected succefully user");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/user1.fxml"));
            Parent root = loader.load();
            tmail.getScene().setRoot(root);
            User1Controller dtp = loader.getController() ;
            dtp.tafficher(tmail.getText());
        } else {
            JOptionPane.showMessageDialog(null, " try again");
        }

    }

    @FXML
    private void cree(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/user.fxml"));
        Parent root = loader.load();
        tmail.getScene().setRoot(root);
    }

}
