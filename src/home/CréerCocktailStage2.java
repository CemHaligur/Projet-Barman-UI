package home;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.io.IOException;

public class CréerCocktailStage2 {

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
    private Button btnCommande;

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
    private Button btnCreerCocktail;

    @FXML
    private Button btnRevenirAjoutCocktail;

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
    void btnCommande(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Commande.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnQuitter(ActionEvent event) {
        Stage stage = (Stage) btnBarmanManager.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnCreerCocktail(ActionEvent event) {

    }


    @FXML
    void btnRevenirAjoutCocktail(ActionEvent event) {

    }

}

