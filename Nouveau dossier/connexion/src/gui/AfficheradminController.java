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
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.servicePersonne;

/**
 * FXML Controller class
 *
 * @author safouane
 */
public class AfficheradminController implements Initializable {

    @FXML
    private Label lajoutet;
    @FXML
    private ListView<String> lview;
    @FXML
    private ImageView img;
    @FXML
    private Label lexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                        Image image = new Image("/gui/crrrrcwusax.jpeg");
        img.setImage(image);
        servicePersonne ser = new servicePersonne();
        ObservableList<Personne> list;
//        ObservableList<String> listss = null ;
        ObservableList<String> listss = FXCollections.observableArrayList();
//
        try {
            list = (ObservableList<Personne>) ser.readall();

            int i = 0;
            while (i != list.size()) {
                listss.add(list.get(i).getMail());
                lview.setItems(listss);
                i++;
            }
            // TODO
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
    }

    @FXML
    private void ajout(MouseEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutadmin.fxml"));
            Parent root = loader.load();
            lajoutet.getScene().setRoot(root);
    }

    @FXML
    private void afficher(MouseEvent event) throws SQLException, IOException {

        System.out.println(lview.selectionModelProperty().getValue().getSelectedItem());

        String mail = lview.selectionModelProperty().getValue().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/updateadmin.fxml"));
        Parent root = loader.load();
        lajoutet.getScene().setRoot(root);
//        user1.tafficher(mail);
        UpdateadminController dtp = loader.getController();

        dtp.tafficher(mail);
    }

    @FXML
    private void exit(MouseEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/authentifier.fxml"));
        Parent root = loader.load();
        lajoutet.getScene().setRoot(root);
        
    }

}
