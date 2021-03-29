/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Personne;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import service.servicePersonne;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class User1Controller implements Initializable {

    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfmdp;
    @FXML
    private Button taff;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private TableView<Personne> table;
    @FXML
    private TableColumn<Personne, String> ttype;
    @FXML
    private TableColumn<Personne, Integer> tid;
    @FXML
    private TableColumn<Personne, String> tlogin;
    @FXML
    private TableColumn<Personne, String> tmail;
    @FXML
    private TextField tflogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void tafficher(ActionEvent event) throws SQLException {
        servicePersonne ser = new servicePersonne();
        ObservableList<Personne> list;

        list = (ObservableList<Personne>) ser.readall4(tfmail.getText());
        tmail.setCellValueFactory(new PropertyValueFactory<Personne, String>("mail"));
        tlogin.setCellValueFactory(new PropertyValueFactory<Personne, String>("login"));
        tid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
        ttype.setCellValueFactory(new PropertyValueFactory<Personne, String>("type"));

        table.setItems(list);
    }

    @FXML
    private void update(ActionEvent event) {
        servicePersonne ser = new servicePersonne();
        try {
            ser.update(new Personne(tflogin.getText(), tfmdp.getText(), tfmail.getText(), null, "user"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "user updated succesfully");

    }

    @FXML
    private void delete(ActionEvent event) {
        servicePersonne ser = new servicePersonne();
        try {
            ser.supprimer(new Personne(tflogin.getText(), tfmdp.getText(), tfmail.getText(), null, null));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "user deleted succesfully");
    }

}
