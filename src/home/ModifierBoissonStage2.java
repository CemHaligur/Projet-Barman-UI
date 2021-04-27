package home;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ModifierBoissonStage2 {

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
    private VBox pnItems;

    @FXML
    private Button btnValiderNomBoisson;

    @FXML
    void btnAjouterBoisson(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AjouterBoissonStage1.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void btnModifierBoisson(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("ModifierBoisson.fxml"));
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

    @FXML
    void btnValiderNomBoisson(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AjouterBoissonStage3.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
