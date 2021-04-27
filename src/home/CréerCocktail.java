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
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;


public class CréerCocktail extends Barman implements Initializable{

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button btnCocktail;

    @FXML
    private Button btnBoissonAlco;

    @FXML
    private Button btnBoissonNonAlco;

    @FXML
    private Button btnBarmanManager;

    @FXML
    private Button btnCreerCocktail;

    @FXML
    private Button btnQuitter;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox pnItems;

    @FXML
    private VBox pnItems1;

    @FXML
    private Button btnAjouterBoissonCocktail;

    @FXML
    private Button btnAccederContenuCocktail;

    @FXML
    private TableView<boissonNonAlcoolisee> TableBoissonNonAlco;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colNom;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colDegreSucre;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colPrix;

    @FXML
    private TableColumn<boissonNonAlcoolisee, String> colQuantite;

    @FXML
    private TableView<boissonAlcoolisee> TableBoissonAlco;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colNomAlco;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colDegreAlcoolAlco;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colPrixAlco;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colQuantiteAlco;

    @FXML
    void btnAccederContenuCocktail(ActionEvent event) throws IOException {

    }

    @FXML
    void btnAjouterBoissonCocktail(ActionEvent event) throws IOException {

    }

    @FXML
    void btnBarmanManager(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("BarmanManager.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnBoissonAlco(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("BoissonAlco.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnBoissonNonAlco(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("BoissonNonAlco.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnCocktail(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("CocktailController.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnCreerCocktail(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("CréerCocktail.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @Override
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

        chargerBoissonAlcoolisee("./BoissonAlcoolisee.txt");
        //chargerBoissonNonAlcoolisee("./BoissonNonAlcoolisee.txt");
        ObservableList<boissonAlcoolisee> listeAl = FXCollections.observableArrayList(getBoissonAlcoolisee());
        TableBoissonAlco.setEditable(true);
        colNomAlco.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colDegreAlcoolAlco.setCellValueFactory(new PropertyValueFactory<>("degreAlcool"));
        colPrixAlco.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        colQuantiteAlco.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        TableBoissonAlco.setItems(listeAl);
    }

    @FXML
    void btnQuitter(ActionEvent event) {
        Stage stage = (Stage) btnBarmanManager.getScene().getWindow();
        stage.close();
    }

}

