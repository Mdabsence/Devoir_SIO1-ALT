package sio.devoir1sioalt;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;

public class DevoirController implements Initializable {

    @FXML
    private Button btnExo1;
    @FXML
    private AnchorPane apExo1;
    @FXML
    private AnchorPane apExo2;
    @FXML
    private AnchorPane apExo3;
    @FXML
    private Button btnExo2;
    @FXML
    private Slider sldNbLignes;
    @FXML
    private TextArea txtTriangle;
    @FXML
    private Button btnExo3;
    @FXML
    private Button btnDessiner;
    @FXML
    private TextField txtNbJours;
    @FXML
    private TextField txtNbEleves;
    @FXML
    private TextField txtCoutGlobal;
    @FXML
    private Button btnCalculer;
    @FXML
    private Button btnJouer;
    @FXML
    private TextArea txtResultatsTirages;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        apExo1.toFront();
    }

    @FXML
    public void btnExosMenuClicked(Event event)
    {
        if(event.getSource() == btnExo1)
        {
            apExo1.toFront();
        }
        else if(event.getSource() == btnExo2)
        {
            apExo2.toFront();
        }
        else
        {
            apExo3.toFront();;
        }
    }

    // Exercice n°1
    @FXML
    public void btnCalculerClicked(Event event)
    {
        if (txtNbJours.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choix du nombre de jours");
            alert.setContentText("Veuillez saisir le nombre de jours");
            alert.setHeaderText("");
            alert.showAndWait();
        }
        else if (txtNbEleves.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choix du nombre d'élèves");
            alert.setContentText("Veuillez saisir le nombre d'élèves");
            alert.setHeaderText("");
            alert.showAndWait();
        }
        else {
            int nbJours = Integer.parseInt(txtNbJours.getText());
            int nbEleves = Integer.parseInt(txtNbEleves.getText());
            double coutTrajet = 0;
            double coutNourriture = 3.50 * nbJours * nbEleves;
            double coutHebergement = 0;
            if (nbEleves <= 25){
                coutTrajet = nbEleves * 67.30;
            }
            else {
                coutTrajet = nbEleves * 61.00;
            }
            if (nbEleves <= 30){
                coutHebergement = 4.75 * nbJours * nbEleves;
            }
            else if (nbEleves <= 35){
                coutHebergement = 4.00 * nbJours * nbEleves;
            }
            else {
                coutHebergement = 3.50 *nbJours * nbEleves;
            }
            double coutGlobal = coutTrajet + coutNourriture + coutHebergement;
            txtCoutGlobal.setText(String.valueOf(coutGlobal));
        }
    }

    // Exercice n°2
    @FXML
    public void btnDessinerClicked(Event event)
    {
        txtTriangle.setText("");
        for (int i = 1; i <= sldNbLignes.getValue(); i++){
            for (int j = 1 + i; j <= sldNbLignes.getValue() + 1; j++){
                txtTriangle.setText(txtTriangle.getText() + i + "  ");
            }
            txtTriangle.setText(txtTriangle.getText() + "\n");
        }
    }

    // Exercice n°3
    @FXML
    public void btnJouerClicked(Event event)
    {
        txtResultatsTirages.setText("");
        int totalJ = 0;
        int totalO = 0;
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        while (totalJ <30 && totalO <30){
            int nb1J = (int)(Math.random() * range) + min;
            int nb2J = (int)(Math.random() * range) + min;
            if (nb1J != nb2J){
                totalJ = totalJ;
            }
            else if (nb1J == 3){
                totalJ = 0;
            }
            else if (nb1J == 6) {
                totalJ += 25;
            }
            else {
                totalJ += 5;
            }
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "NB1J = " + nb1J + " NB2J = " + nb2J + " Total = " + totalJ + "\n");
            int nb1O = (int)(Math.random() * range) + min;
            int nb2O = (int)(Math.random() * range) + min;
            if (nb1O != nb2O){
                totalO = totalO;
            }
            else if (nb1O == 3){
                totalO = 0;
            }
            else if (nb1O == 6) {
                totalO += 25;
            }
            else {
                totalO += 5;
            }
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "NB1O = " + nb1O + " NB2O = " + nb2O + " Total = " + totalO + "\n");
        }
        if (totalJ > totalO){
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "\nLe joueur à gagné la partie !");
        }
        else {
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "\nL'ordinateur à gagné la partie !");
        }
    }
}