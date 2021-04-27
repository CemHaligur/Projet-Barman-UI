package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class AjouterBoissonStage2Alco extends Barman implements Initializable {

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button btnAjouterBoisson;

    @FXML
    private Button btnSupprimerBoisson;

    @FXML
    private Button btnModifierBoisson;

    @FXML
    private Button btnRetourMenu;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button btnValiderNomPrix;

    @FXML
    private TableView<boissonAlcoolisee> TableBoissonAlco;

    @FXML
    private TextField textNom;

    @FXML
    private TextField textPrix;

    @FXML
    private TextField textQuantite;

    @FXML
    private TextField textDegreAlcool;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colNom;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colDegreAlcool;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colPrix;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colQuantite;

    @FXML
    private Label lberrorNom;

    @FXML
    private Label lberrorPrix;

    @FXML
    private Label lberrorDegreAlcool;

    @FXML
    private Label lberrorQuantité;

    @FXML
    void btnAjouterBoisson(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AjouterBoissonStage1.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnAlco(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AjouterBoissonStage2.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnModifierBoisson(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("ModifierBoisson.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnNonAlco(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AjouterBoissonStage2.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnRetourMenu(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("CocktailController.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnSupprimerBoisson(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("SupprimerBoisson.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    public boolean emptyTextField (TextField tf)
    {
        if (tf.getText().isEmpty())
            return true;
        else
            return false;

    }

    public boolean emptyTextField (TextField tf, Label lb, String msgerror)
    {
        if (!emptyTextField(tf))
            return false;
        else
        {
            lb.setText(msgerror);
            return true;
        }

    }

    public boolean notNumberTextField (TextField tf)
    {
        if (tf.getText().matches("-?\\d*")||tf.getText().matches("-?\\d+\\.\\d+"))
        {
            return false;
        }
        else
            return true;

    }
    public boolean notNumberTextField (TextField tf, Label lb, String msgerror)
    {
        if (notNumberTextField (tf))
        {
            lb.setText(msgerror);
            return true;
        }

        else if (Float.valueOf(tf.getText())<0)
        {
            lb.setText("value must be positif");
            return true;
        }
        else
            return false;

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        chargerBoissonAlcoolisee("./BoissonAlcoolisee.txt");
        //chargerBoissonNonAlcoolisee("./BoissonNonAlcoolisee.txt");
        ObservableList<boissonAlcoolisee> listeAl = FXCollections.observableArrayList(getBoissonAlcoolisee());
        TableBoissonAlco.setEditable(true);
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colDegreAlcool.setCellValueFactory(new PropertyValueFactory<>("degreAlcool"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        TableBoissonAlco.setItems(listeAl);
    }

    @FXML
    void btnValiderNomPrix(ActionEvent event) {
        boolean b1=emptyTextField(textNom,lberrorNom, "Attention ! champ vide");
        boolean b2=emptyTextField(textDegreAlcool,lberrorDegreAlcool, "Attention ! rentrez une nombre");
        boolean b4=notNumberTextField(textPrix,lberrorPrix, "Attention ! rentrez une nombre");
        boolean b5=notNumberTextField(textQuantite,lberrorQuantité, "Attention ! rentrez une nombre");

        if (!b1 && !b2 && !b4 && !b5){

            boissonAlcoolisee b = new boissonAlcoolisee(textNom.getText(),Float.parseFloat(textPrix.getText()),Float.parseFloat(textQuantite.getText()), Float.parseFloat(textDegreAlcool.getText()));
            ajouterBoissonAlcoolisee(b);
            sauvegarderBoissonAlcoolisee("./BoissonAlcoolisee.txt");
            TableBoissonAlco.getItems().add(b);
            textNom.setText("");
            textPrix.setText("");
            textQuantite.setText("");
            textDegreAlcool.setText("");
            lberrorNom.setText("");
            lberrorPrix.setText("");
            lberrorQuantité.setText("");
            lberrorDegreAlcool.setText("");

        }
    }

}

