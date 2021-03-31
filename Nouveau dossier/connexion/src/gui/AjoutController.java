/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Personne;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import service.servicePersonne;
import javafx.collections.ObservableArray;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class AjoutController implements Initializable {

    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfmdp;
    @FXML
    private Button btnajout;

    @FXML
    private TableColumn<Personne, Integer> tid;
    @FXML
    private TableColumn<Personne, String> tlogin;
    @FXML
    private TableColumn<Personne, String> tmail;
    @FXML
    private Button taff;
    @FXML
    private TableView<Personne> table;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private TextField tftype;
    @FXML
    private Button btntriemail;
    @FXML
    private Button btntrielogin;
    @FXML
    private Button rech;
    @FXML
    private TableColumn<Personne, String> ttype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

  

    @FXML
    private void iajout(ActionEvent event) throws SQLException {
        servicePersonne ser = new servicePersonne();
        ser.ajouter(new Personne(tflogin.getText(),null, null,null , tfmdp.getText(), tfmail.getText(), null, "user"));
        JOptionPane.showMessageDialog(null, "user added succesfully");
    }

    @FXML
    private void tafficher(ActionEvent event) throws SQLException {
        servicePersonne ser = new servicePersonne();
        ObservableList<Personne> list;

        list = (ObservableList<Personne>) ser.readall();
        tmail.setCellValueFactory(new PropertyValueFactory<Personne, String>("mail"));
        tlogin.setCellValueFactory(new PropertyValueFactory<Personne, String>("login"));
        tid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
                ttype.setCellValueFactory(new PropertyValueFactory<Personne, String>("type"));

        table.setItems(list);

    }

    @FXML
    private void trielogin(ActionEvent event) throws SQLException {
        servicePersonne ser = new servicePersonne();
        ObservableList<Personne> list;

        list = (ObservableList<Personne>) ser.readall2();
        tmail.setCellValueFactory(new PropertyValueFactory<Personne, String>("mail"));
        tlogin.setCellValueFactory(new PropertyValueFactory<Personne, String>("login"));
        tid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
                ttype.setCellValueFactory(new PropertyValueFactory<Personne, String>("type"));

        table.setItems(list);

    }

    @FXML
    private void triemail(ActionEvent event) throws SQLException {
        servicePersonne ser = new servicePersonne();
        ObservableList<Personne> list;

        list = (ObservableList<Personne>) ser.readall1();
        tmail.setCellValueFactory(new PropertyValueFactory<Personne, String>("mail"));
        tlogin.setCellValueFactory(new PropertyValueFactory<Personne, String>("login"));
        tid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
        ttype.setCellValueFactory(new PropertyValueFactory<Personne, String>("type"));

        table.setItems(list);

    }

    @FXML
    private void recherche(ActionEvent event) throws SQLException {
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
            ser.update(new Personne(tflogin.getText(),null, null,null , tfmdp.getText(), tfmail.getText(), null, "user"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "user updated succesfully");
    }

    @FXML
    private void delete(ActionEvent event) {
        servicePersonne ser = new servicePersonne();
        try {

            ser.supprimer(new Personne(tflogin.getText(),null, null,null , tfmdp.getText(), tfmail.getText(), null, "user"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "user deleted succesfully");

    }

}
