/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import service.servicePersonne;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class UserController implements Initializable {

    private TextField tfmail;
    @FXML
    private TextField tflogin1;
    @FXML
    private TextField tfmail1;
    @FXML
    private TextField tfmdp1;
    @FXML
    private Button btnajout1;
    @FXML
    private TextField tfprenom1;
    @FXML
    private Label result;
    @FXML
    private DatePicker tfdate1;
    @FXML
    private RadioButton tffemme;
    @FXML
    private RadioButton tfhomme;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Label lsignin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void iajout(ActionEvent event) throws IOException {
        servicePersonne ser = new servicePersonne();
        
            java.util.Date date = java.util.Date.from(tfdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sdate = new java.sql.Date(date.getTime());
            try {
                if (tffemme.isSelected())
                ser.ajouter(new Personne(tflogin1.getText(), tfprenom1.getText(), sdate, "femme", tfmdp1.getText(), tfmail1.getText(), null, "user"));
                else
                    ser.ajouter(new Personne(tflogin1.getText(), tfprenom1.getText(), sdate, "homme", tfmdp1.getText(), tfmail1.getText(), null, "user"));
            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "try again");
            }

//            ser.ajouter(new Personne(tflogin1.getText(),tfprenom1.getText(), date,(String) gender.getUserData() , tfmdp1.getText(), tfmail1.getText(), null, "user"));
            JOptionPane.showMessageDialog(null, "user added succesfully");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/authentifier.fxml"));
            Parent root = loader.load();
            tfmail1.getScene().setRoot(root);
        
    }

    @FXML
    private void cree(MouseEvent event) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../gui/authentifier.fxml"));
        Parent root = loader2.load();
        lsignin.getScene().setRoot(root);
    }

}
