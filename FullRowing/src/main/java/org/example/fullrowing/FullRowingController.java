package org.example.fullrowing;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import org.example.fullrowing.Model.Entities.DeportistasEntity;
import org.example.fullrowing.Model.FullRowingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FullRowingController {

    FullRowingModel model = new FullRowingModel();
    private int menuSelected = 1;
    private int optionSelected = 0;

//region Componentes FXML
    @FXML
    private GridPane gpLogin;
    @FXML
    private GridPane gpMenu;
    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField tpContrasena;


    @FXML
    private GridPane gpRowers;
    @FXML
    private GridPane gpRowersFields;
    @FXML
    private GridPane gpRowerOption;
    @FXML
    private ImageView btnAcceptRower;
    @FXML
    private ImageView btnDeclineRower;
    @FXML
    private ImageView btnEditRower;
    @FXML
    private ImageView btnAddRower;
    @FXML
    private ImageView btnSearchRower;
    @FXML
    private ImageView btnDeleteRower;
    @FXML
    private TextField tfIdDep;
    @FXML
    private TextField tfNombreDep;
    @FXML
    private TextField tfPrimerApellidoDep;
    @FXML
    private TextField tfSegundoApellidoDep;
    @FXML
    private TextField tfDniDep;
    @FXML
    private ComboBox cbGeneroDep;
    @FXML
    private TextField tfAnoNacDep;
    @FXML
    private CheckBox cbBancoFijoDep;
    @FXML
    private CheckBox cbBancoMovilDep;
    @FXML
    private Label lbCategoriaDep;


    @FXML
    private GridPane gpCoaches;
    @FXML
    private GridPane gpCoachFields;
    @FXML
    private GridPane gpCoachOption;
    @FXML
    private ImageView btnAcceptCoach;
    @FXML
    private ImageView btnDeclineCoach;
    @FXML
    private ImageView btnEditCoach;
    @FXML
    private ImageView btnAddCoach;
    @FXML
    private ImageView btnSearchCoach;

    @FXML
    private GridPane gpStatistics;
    @FXML
    private GridPane gpAssists;
    @FXML
    private GridPane gpInfo;
//endregion


    String usuario = "1";
    String contrasena = "1";

    @FXML
    public void initialize() {
        System.out.println("Componentes inicializados correctamente");

        startOptions();
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
        System.out.println("push");

        if((Objects.equals(tfUsuario.getText(), usuario)) && (Objects.equals(tpContrasena.getText(), contrasena))){
            fadeOutGridPane(gpLogin);
            fadeInGridPane(gpMenu);
            gpLogin.setDisable(true);

            System.out.println("Login correct");
        }
    }


//region GripPanels
    public void onRowersButtonClick(MouseEvent mouseEvent) {

        fadeInGridPane(gpRowers);
        startOptions();

        if(gpCoaches.isVisible()){
            fadeOutGridPane(gpCoaches);
        }
        if(gpStatistics.isVisible()){
            fadeOutGridPane(gpStatistics);
        }
        if(gpAssists.isVisible()){
            fadeOutGridPane(gpAssists);
        }
        if(gpInfo.isVisible()){
            fadeOutGridPane(gpInfo);
        }

        menuSelected = 1;
    }

    public void onCoachesButtonClick(MouseEvent mouseEvent) {

        fadeInGridPane(gpCoaches);
        startOptions();

        if(gpRowers.isVisible()){
            fadeOutGridPane(gpRowers);
        }
        if(gpStatistics.isVisible()){
            fadeOutGridPane(gpStatistics);
        }
        if(gpAssists.isVisible()){
            fadeOutGridPane(gpAssists);
        }
        if(gpInfo.isVisible()){
            fadeOutGridPane(gpInfo);
        }

        menuSelected = 2;
    }

    public void onStatisticsButtonClick(MouseEvent mouseEvent) {

        fadeInGridPane(gpStatistics);
        startOptions();

        if(gpCoaches.isVisible()){
            fadeOutGridPane(gpRowers);
        }
        if(gpCoaches.isVisible()){
            fadeOutGridPane(gpCoaches);
        }
        if(gpAssists.isVisible()){
            fadeOutGridPane(gpAssists);
        }
        if(gpInfo.isVisible()){
            fadeOutGridPane(gpInfo);
        }

        menuSelected = 3;
    }

    public void onAssistsButtonClick(MouseEvent mouseEvent) {

        fadeInGridPane(gpAssists);
        startOptions();

        if(gpCoaches.isVisible()){
            fadeOutGridPane(gpRowers);
        }
        if(gpStatistics.isVisible()){
            fadeOutGridPane(gpCoaches);
        }
        if(gpStatistics.isVisible()){
            fadeOutGridPane(gpStatistics);
        }
        if(gpInfo.isVisible()){
            fadeOutGridPane(gpInfo);
        }

        menuSelected = 4;
    }

    public void onInfoButtonClick(MouseEvent mouseEvent) {

        fadeInGridPane(gpInfo);
        startOptions();

        if(gpCoaches.isVisible()){
            fadeOutGridPane(gpRowers);
        }
        if(gpStatistics.isVisible()){
            fadeOutGridPane(gpCoaches);
        }
        if(gpAssists.isVisible()){
            fadeOutGridPane(gpStatistics);
        }
        if(gpAssists.isVisible()){
            fadeOutGridPane(gpAssists);
        }

        menuSelected = 5;
    }
//endregion

//region Botones menu options
    public void onAddRowerButtonClick(MouseEvent mouseEvent) {
        optionSelected = 1;

        btnAcceptRower.setVisible(true);
        btnDeclineRower.setVisible(true);
        btnEditRower.setVisible(false);
        btnAddRower.setVisible(false);
        btnSearchRower.setVisible(false);
        btnDeleteRower.setVisible(false);

        tfIdDep.setDisable(true);
        tfIdDep.setText("");
        tfNombreDep.setDisable(false);
        tfNombreDep.setText("");
        tfPrimerApellidoDep.setDisable(false);
        tfPrimerApellidoDep.setText("");
        tfSegundoApellidoDep.setDisable(false);
        tfSegundoApellidoDep.setText("");
        tfDniDep.setDisable(false);
        tfDniDep.setText("");
        cbGeneroDep.setDisable(false);
        //Rellenar con tipos de genero.
        tfAnoNacDep.setDisable(false);
        tfAnoNacDep.setText("");
        cbBancoFijoDep.setDisable(false);
        cbBancoFijoDep.setSelected(false);
        cbBancoMovilDep.setDisable(false);
        cbBancoMovilDep.setSelected(false);
        lbCategoriaDep.setText("");

        ObservableList<String> genero = FXCollections.observableArrayList("Masculino", "Femenino");
        cbGeneroDep.setItems(genero);
    }
    public void onSearchRowerButtonClick(MouseEvent mouseEvent) {
        optionSelected = 2;

        btnAcceptRower.setVisible(true);
        btnDeclineRower.setVisible(true);
        btnEditRower.setVisible(false);
        btnAddRower.setVisible(false);
        btnSearchRower.setVisible(false);
        btnDeleteRower.setVisible(false);

        tfIdDep.setDisable(true);
        tfIdDep.setText("");
        tfNombreDep.setDisable(true);
        tfNombreDep.setText("");
        tfPrimerApellidoDep.setDisable(true);
        tfPrimerApellidoDep.setText("");
        tfSegundoApellidoDep.setDisable(true);
        tfSegundoApellidoDep.setText("");
        tfDniDep.setDisable(false);
        tfDniDep.setText("");
        cbGeneroDep.setDisable(true);
        //Rellenar con tipos de genero.
        tfAnoNacDep.setDisable(true);
        tfAnoNacDep.setText("");
        cbBancoFijoDep.setDisable(true);
        cbBancoFijoDep.setSelected(false);
        cbBancoMovilDep.setDisable(true);
        cbBancoMovilDep.setSelected(false);
        lbCategoriaDep.setText("");
    }
    public void onEditRowerButtonClick(MouseEvent mouseEvent) {
        optionSelected = 3;

        btnAcceptRower.setVisible(true);
        btnDeclineRower.setVisible(true);
        btnEditRower.setVisible(false);
        btnAddRower.setVisible(false);
        btnSearchRower.setVisible(false);
        btnDeleteRower.setVisible(false);

        tfIdDep.setDisable(false);
        tfNombreDep.setDisable(false);
        tfPrimerApellidoDep.setDisable(false);
        tfSegundoApellidoDep.setDisable(false);
        tfDniDep.setDisable(false);
        cbGeneroDep.setDisable(false);
        tfAnoNacDep.setDisable(false);
        cbBancoFijoDep.setDisable(false);
        cbBancoFijoDep.setSelected(false);
        cbBancoMovilDep.setDisable(false);
        cbBancoMovilDep.setSelected(false);


    }
    public void onDeleteRowerButtonClick(MouseEvent mouseEvent) {
        optionSelected = 4;

        lbCategoriaDep.setText("ELIMINAR - Estas seguro?");

        btnAcceptRower.setVisible(true);
        btnDeclineRower.setVisible(true);
        btnEditRower.setVisible(false);
        btnAddRower.setVisible(false);
        btnSearchRower.setVisible(false);
        btnDeleteRower.setVisible(false);
    }
    public void onAcceptRowerButtonClick(MouseEvent mouseEvent) {
         if (optionSelected == 1){
             //Aceptar añadir
             String nombreDep = tfNombreDep.getText();
             String primerApellidoDep = tfPrimerApellidoDep.getText();
             String segundoApellidoDep = tfSegundoApellidoDep.getText();
             String dniDep = tfDniDep.getText();

             boolean generoDep;
             if(cbGeneroDep.getValue() == "Masculino"){
                 generoDep = true;
             }
             else {
                 generoDep = false;
             }

             int anoNacDep = Integer.parseInt(tfAnoNacDep.getText());

             boolean modalidadBancoFijo = false;
             if(cbBancoFijoDep.isSelected()){
                 modalidadBancoFijo = true;
             }

             boolean modalidadBancoMovil = false;
             if(cbBancoMovilDep.isSelected()){
                 modalidadBancoMovil = true;
             }

             model.addDeportistas(nombreDep, primerApellidoDep, segundoApellidoDep, dniDep, generoDep, anoNacDep, modalidadBancoFijo, modalidadBancoMovil);
             startOptions();
             lbCategoriaDep.setText("Deportista añadido.");
         }
         if (optionSelected == 2){
             //Aceptar buscar
             DeportistasEntity deportista = new DeportistasEntity();

             String dniDep = tfDniDep.getText();
             deportista = model.searchDeportista(dniDep);

             tfIdDep.setText(String.valueOf(deportista.getIdDeportista()));
             tfNombreDep.setText(deportista.getNombre());
             tfPrimerApellidoDep.setText(deportista.getPrimerApellido());
             tfSegundoApellidoDep.setText(deportista.getSegundoApellido());

             if(deportista.getGenero()){
                 ObservableList<String> genero = FXCollections.observableArrayList("Masculino");
                 cbGeneroDep.setValue(genero);
             }
             else{
                 ObservableList<String> genero = FXCollections.observableArrayList("Femenino");
                 cbGeneroDep.setValue(genero);
             }

             tfAnoNacDep.setText(String.valueOf(deportista.getAñoNac()));

             if(deportista.getBancoFijo() == true){
                 cbBancoFijoDep.setSelected(true);
             }else{
                 cbBancoFijoDep.setSelected(false);
             }
             if(deportista.getBancoMovil() == true){
                 cbBancoMovilDep.setSelected(true);
             }else{
                 cbBancoMovilDep.setSelected(false);
             }

             lbCategoriaDep.setText(stringCategoria(Integer.parseInt(tfAnoNacDep.getText()),cbGeneroDep.getValue().toString()));

             btnAcceptRower.setVisible(false);
             btnDeleteRower.setVisible(true);
             btnEditRower.setVisible(true);
             tfDniDep.setDisable(true);
         }
         if (optionSelected == 3){
             String idDep = tfIdDep.getText();
             String nombreDep = tfNombreDep.getText();
             String primerApellidoDep = tfPrimerApellidoDep.getText();
             String segundoApellidoDep = tfSegundoApellidoDep.getText();
             String dniDep = tfDniDep.getText();

             boolean generoDep;
             if(cbGeneroDep.getValue() == "Masculino"){
                 generoDep = true;
             }
             else {
                 generoDep = false;
             }

             int anoNacDep = Integer.parseInt(tfAnoNacDep.getText());

             boolean modalidadBancoFijo = false;
             if(cbBancoFijoDep.isSelected()){
                 modalidadBancoFijo = true;
             }

             boolean modalidadBancoMovil = false;
             if(cbBancoMovilDep.isSelected()){
                 modalidadBancoMovil = true;
             }

             model.deleteDeportista(idDep);
             model.addDeportistas(nombreDep, primerApellidoDep, segundoApellidoDep, dniDep, generoDep, anoNacDep, modalidadBancoFijo, modalidadBancoMovil);
             startOptions();
             lbCategoriaDep.setText("Editado correctamente.");
         }
         if(optionSelected == 4){

             String idDeportista = tfIdDep.getText();

             model.deleteDeportista(idDeportista);

             startOptions();

             lbCategoriaDep.setText("Eliminado correctamente.");
         }
    }
    public void onDeclineRowerButtonClick(MouseEvent mouseEvent) {
        startOptions();
    }
//endregion

    //Metodos auxiliares
    private void fadeInGridPane(GridPane gridPane) {
        gridPane.setVisible(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), gridPane);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }
    private void fadeOutGridPane(GridPane gridPane) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), gridPane);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();

        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.setOnFinished(event -> gridPane.setVisible(false));
        pause.play();
    }

    private void startOptions(){
        //Rowers
        btnAcceptRower.setVisible(false);
        btnDeclineRower.setVisible(false);
        btnEditRower.setVisible(false);
        btnAddRower.setVisible(true);
        btnSearchRower.setVisible(true);
        btnDeleteRower.setVisible(false);

        tfIdDep.setDisable(true);
        tfIdDep.setText("");
        tfNombreDep.setDisable(true);
        tfNombreDep.setText("");
        tfPrimerApellidoDep.setDisable(true);
        tfPrimerApellidoDep.setText("");
        tfSegundoApellidoDep.setDisable(true);
        tfSegundoApellidoDep.setText("");
        tfDniDep.setDisable(true);
        tfDniDep.setText("");
        cbGeneroDep.setDisable(true);
        tfAnoNacDep.setDisable(true);
        tfAnoNacDep.setText("");
        cbBancoFijoDep.setDisable(true);
        cbBancoFijoDep.setSelected(false);
        cbBancoMovilDep.setDisable(true);
        cbBancoMovilDep.setSelected(false);
        lbCategoriaDep.setText("");

        //Coach
        btnAcceptCoach.setVisible(false);
        btnDeclineCoach.setVisible(false);
        btnEditCoach.setVisible(false);
        btnAddCoach.setVisible(true);
        btnSearchCoach.setVisible(true);
        //Faltan los textFields y demas.

    }

    private String stringCategoria (int anoNac, String genero){
        String categoria;
        if(genero == "Masculino"){
            categoria = switch (anoNac) {
                case 2009, 2010 -> "Cadete Masculino";
                case 2007, 2008 -> "Juvenil Masculino";
                case 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006 -> "Senior Masculino";
                default -> "Veterano Masculino";
            };
        }
        else{
            categoria = switch (anoNac) {
                case 2009, 2010 -> "Cadete Femenino";
                case 2007, 2008 -> "Juvenil Femenino";
                case 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006 -> "Senior Femenino";
                default -> "Veterano Femenino";
            };
        }
        return categoria;
    }



}