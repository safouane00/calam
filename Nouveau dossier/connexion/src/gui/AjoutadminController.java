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
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import service.servicePersonne;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class AjoutadminController implements Initializable {

    @FXML
    private TextField tfprenom1;
    @FXML
    private TextField tflogin1;
    @FXML
    private TextField tfmail1;
    @FXML
    private Button btnajout1;
    @FXML
    private Label result;
    @FXML
    private DatePicker tfdate1;
    @FXML
    private RadioButton tffemme;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton tfhomme;
    @FXML
    private PasswordField tfmdp1;
    @FXML
    private Label lajoutet;
    @FXML
    private Label lcomptes;
    @FXML
    private TextField tftype;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("/gui/djjiiffbibz.jpeg");
        img.setImage(image);
    }

    @FXML
    private void iajout(ActionEvent event) throws IOException {

        servicePersonne ser = new servicePersonne();

        java.util.Date date = java.util.Date.from(tfdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sdate = new java.sql.Date(date.getTime());
        try {
            System.out.println(!tfprenom1.getText().isEmpty());
            if ((tffemme.isSelected()) && (!tfprenom1.getText().isEmpty()) && (!tflogin1.getText().isEmpty()) && (!tfmdp1.getText().isEmpty()) && (!tfmail1.getText().isEmpty()) && (!tftype.getText().isEmpty())) {
                ser.ajouter(new Personne(tflogin1.getText(), tfprenom1.getText(), sdate, "femme", tfmdp1.getText(), tfmail1.getText(), null, tftype.getText()));
                JOptionPane.showMessageDialog(null, "user added succesfully");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/afficheradmin.fxml"));
                Parent root = loader.load();
                tfmail1.getScene().setRoot(root);
            } else if ((tfhomme.isSelected()) && (!tfprenom1.getText().isEmpty()) && (!tflogin1.getText().isEmpty()) && (!tfmdp1.getText().isEmpty()) && (!tfmail1.getText().isEmpty()) && (!tftype.getText().isEmpty())) {
                ser.ajouter(new Personne(tflogin1.getText(), tfprenom1.getText(), sdate, "homme", tfmdp1.getText(), tfmail1.getText(), null, tftype.getText()));
                JOptionPane.showMessageDialog(null, "user added succesfully");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/afficheradmin.fxml"));
                Parent root = loader.load();
                tfmail1.getScene().setRoot(root);
            } else {
                JOptionPane.showMessageDialog(null, "remplir tout les champs");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "try again");
        }

//            ser.ajouter(new Personne(tflogin1.getText(),tfprenom1.getText(), date,(String) gender.getUserData() , tfmdp1.getText(), tfmail1.getText(), null, "user"));
    }

    @FXML
    private void cree(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/afficheradmin.fxml"));
        Parent root = loader.load();
        tfmail1.getScene().setRoot(root);
    }

    @FXML
    private void ajout(MouseEvent event) {
    }

    @FXML
    private void comptes(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/afficheradmin.fxml"));
        Parent root = loader.load();
        tfmail1.getScene().setRoot(root);
    }

}
