package home;

import com.sun.org.apache.xml.internal.security.Init;
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


public class BoissonAlco extends Barman implements Initializable {

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
    private Pane pnlMenus;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox pnItems;

    @FXML
    private TableView<boissonAlcoolisee> TableBoissonAlco;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colNom;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colDegreAlcool;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colPrix;

    @FXML
    private TableColumn<boissonAlcoolisee, String> colQuantite;

    public void initialize(URL arg0, ResourceBundle arg1) {
        chargerBoissonAlcoolisee("./BoissonAlcoolisee.txt");
        System.out.println("heho");
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

    @FXML
    void btnQuitter(ActionEvent event) {
        Stage stage = (Stage) btnBarmanManager.getScene().getWindow();
        stage.close();
    }

}

