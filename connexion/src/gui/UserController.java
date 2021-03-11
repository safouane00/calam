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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.servicePersonne;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class UserController implements Initializable {

    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfmdp;
    @FXML
    private Button btnajout;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tflogin1;
    @FXML
    private TextField tfmail1;
    @FXML
    private TextField tfmdp1;
    @FXML
    private Button btnajout1;
    @FXML
    private TextField tftype1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void iajout(ActionEvent event) throws SQLException, IOException {
        servicePersonne ser = new servicePersonne();
        ser.ajouter(new Personne(tflogin1.getText(), tfmdp1.getText(), tfmail1.getText(), null, "user"));
        JOptionPane.showMessageDialog(null, "user added succesfully");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Authentifier.fxml"));
            Parent root = loader.load();
            tfmail.getScene().setRoot(root);
    }



}
