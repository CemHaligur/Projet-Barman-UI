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

public class AjouterBoissonStage2NonAlco extends Barman implements Initializable {

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
    private TextField textNom;

    @FXML
    private TextField textPrix;

    @FXML
    private Button btnValiderNomPrix;

    @FXML
    private TextField textQuantite;

    @FXML
    private TableView<boissonNonAlcoolisee> TableBoissonNonAlco;

    @FXML
    private TableColumn<boissonNonAlcoolisee,String> colNom;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colDegreSucre;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colPrix;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colQuantite;

    @FXML
    private TextField textDegreSucre;

    @FXML
    private Label lberrorNom;

    @FXML
    private Label lberrorPrix;

    @FXML
    private Label lberrorQuantité;

    @FXML
    private Label lberrorDegreSucre;

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


    public void initialize(URL arg0, ResourceBundle arg1) {
        chargerBoissonNonAlcoolisee("./BoissonNonAlcoolisee.txt");
        //chargerBoissonNonAlcoolisee("./BoissonNonAlcoolisee.txt");
        ObservableList<boissonNonAlcoolisee> listeNonAl = FXCollections.observableArrayList(getBoissonNonAlcoolisee());
        TableBoissonNonAlco.setEditable(true);
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colDegreSucre.setCellValueFactory(new PropertyValueFactory<>("degreSucre"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        TableBoissonNonAlco.setItems(listeNonAl);
    }

    @FXML
    void btnValiderNomPrix(ActionEvent event) {
        boolean b1=emptyTextField(textNom,lberrorNom, "Attention ! champ vide");
        boolean b2=emptyTextField(textDegreSucre,lberrorDegreSucre, "Attention ! rentrez une nombre");
        boolean b4=notNumberTextField(textPrix,lberrorPrix, "Attention ! rentrez une nombre");
        boolean b5=notNumberTextField(textQuantite,lberrorQuantité, "Attention ! rentrez une nombre");

        if (!b1 && !b2 && !b4 && !b5){

            boissonNonAlcoolisee b = new boissonNonAlcoolisee(textNom.getText(),Float.parseFloat(textPrix.getText()),Float.parseFloat(textQuantite.getText()), Float.parseFloat(textDegreSucre.getText()));
            ajouterBoissonNonAlcoolisee(b);
            sauvegarderBoissonNonAlcoolisee("./BoissonNonAlcoolisee.txt");
            TableBoissonNonAlco.getItems().add(b);
            textNom.setText("");
            textPrix.setText("");
            textQuantite.setText("");
            lberrorNom.setText("");
            lberrorPrix.setText("");
            lberrorQuantité.setText("");
            lberrorDegreSucre.setText("");

        }
    }

}
