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
import org.example.fullrowing.Model.Entities.EntrenadoresEntity;
import org.example.fullrowing.Model.FullRowingModel;

import java.util.Objects;

public class FullRowingController {

    FullRowingModel model = new FullRowingModel();
    private int menuSelected = 1;
    private int optionSelectedDep = 0;
    private int optionSelectedEnt = 0;

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
    private TextField tfPesoDep;
    @FXML
    private TextField tfWatsDep;



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
    private ImageView btnDeleteCoach;
    @FXML
    private TextField tfIdEnt;
    @FXML
    private TextField tfNombreEnt;
    @FXML
    private TextField tfPrimerApellidoEnt;
    @FXML
    private TextField tfSegundoApellidoEnt;
    @FXML
    private TextField tfDniEnt;
    @FXML
    private ComboBox cbGeneroEnt;
    @FXML
    private Label lbCategoriaEnt;

    @FXML
    private CheckBox cbCM;
    @FXML
    private CheckBox cbCF;
    @FXML
    private CheckBox cbJM;
    @FXML
    private CheckBox cbJF;
    @FXML
    private CheckBox cbSM;
    @FXML
    private CheckBox cbSF;
    @FXML
    private CheckBox cbVM;
    @FXML
    private CheckBox cbVF;


    @FXML
    private GridPane gpStatistics;
    @FXML
    private Label lbCM;
    @FXML
    private Label lbCF;
    @FXML
    private Label lbJM;
    @FXML
    private Label lbJF;
    @FXML
    private Label lbSM;
    @FXML
    private Label lbSF;
    @FXML
    private Label lbVM;
    @FXML
    private Label lbVF;

    @FXML
    private Label lbCMNombre;
    @FXML
    private Label lbCFNombre;
    @FXML
    private Label lbJMNombre;
    @FXML
    private Label lbJFNombre;
    @FXML
    private Label lbSMNombre;
    @FXML
    private Label lbSFNombre;
    @FXML
    private Label lbVMNombre;
    @FXML
    private Label lbVFNombre;

    @FXML
    private Label lbCMWats;
    @FXML
    private Label lbCFWats;
    @FXML
    private Label lbJMWats;
    @FXML
    private Label lbJFWats;
    @FXML
    private Label lbSMWats;
    @FXML
    private Label lbSFWats;
    @FXML
    private Label lbVMWats;
    @FXML
    private Label lbVFWats;



    @FXML
    private GridPane gpAssists;



    @FXML
    private GridPane gpInfo;
    @FXML
    private Label lblFechaMensaje;
    @FXML
    private Label lblTextoMensaje;
    @FXML
    private TextField tfMansaje;


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

        lbCM.setText(estadisticasCM());
        lbCF.setText(estadisticasCF());
        lbJM.setText(estadisticasJM());
        lbJF.setText(estadisticasJF());
        lbSM.setText(estadisticasSM());
        lbSF.setText(estadisticasSF());
        lbVM.setText(estadisticasVM());
        lbVF.setText(estadisticasVF());

        recordCM();
        recordCF();
        recordJM();
        recordJF();
        recordSM();
        recordSF();
        recordVM();
        recordVF();
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

//region Botones Deportistas menu options
    public void onAddRowerButtonClick(MouseEvent mouseEvent) {
        optionSelectedDep = 1;

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
        tfPesoDep.setDisable(false);
        tfPesoDep.setText("");
        tfWatsDep.setDisable(false);
        tfWatsDep.setText("");

        ObservableList<String> genero = FXCollections.observableArrayList("Masculino", "Femenino");
        cbGeneroDep.setItems(genero);
    }
    public void onSearchRowerButtonClick(MouseEvent mouseEvent) {
        optionSelectedDep = 2;

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
        optionSelectedDep = 3;

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
        tfPesoDep.setDisable(false);
        tfWatsDep.setDisable(false);
    }
    public void onDeleteRowerButtonClick(MouseEvent mouseEvent) {
        optionSelectedDep = 4;

        lbCategoriaDep.setText("ELIMINAR - Estas seguro?");

        btnAcceptRower.setVisible(true);
        btnDeclineRower.setVisible(true);
        btnEditRower.setVisible(false);
        btnAddRower.setVisible(false);
        btnSearchRower.setVisible(false);
        btnDeleteRower.setVisible(false);
    }
    public void onAcceptRowerButtonClick(MouseEvent mouseEvent) {
         if (optionSelectedDep == 1){
             //Aceptar añadir
             String nombreDep = tfNombreDep.getText();
             String primerApellidoDep = tfPrimerApellidoDep.getText();
             String segundoApellidoDep = tfSegundoApellidoDep.getText();
             String dniDep = tfDniDep.getText();
             int peso = Integer.parseInt(tfPesoDep.getText());
             int wats = Integer.parseInt(tfWatsDep.getText());

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

             model.addDeportistas(nombreDep, primerApellidoDep, segundoApellidoDep, dniDep, generoDep, anoNacDep, modalidadBancoFijo, modalidadBancoMovil, peso, wats);
             startOptions();
             lbCategoriaDep.setText("Deportista añadido.");
         }
         if (optionSelectedDep == 2){
             //Aceptar buscar
             DeportistasEntity deportista = new DeportistasEntity();

             String dniDep = tfDniDep.getText();

             if(model.deportistaExistDni(dniDep) == true) {
                 deportista = model.searchDeportista(dniDep);

                 tfIdDep.setText(String.valueOf(deportista.getIddeportista()));
                 tfIdDep.setDisable(true);
                 tfNombreDep.setText(deportista.getNombre());
                 tfPrimerApellidoDep.setText(deportista.getPrimerApellido());
                 tfSegundoApellidoDep.setText(deportista.getSegundoApellido());
                 tfPesoDep.setText(String.valueOf(deportista.getKg()));
                 tfWatsDep.setText(String.valueOf(deportista.getWats()));

                 if(deportista.getGenero()){
                     ObservableList<String> genero = FXCollections.observableArrayList("Masculino");
                     cbGeneroDep.setValue(genero);
                 }
                 else{
                     ObservableList<String> genero = FXCollections.observableArrayList("Femenino");
                     cbGeneroDep.setValue(genero);
                 }

                 tfAnoNacDep.setText(String.valueOf(deportista.getAñonac()));

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
             else{
                 lbCategoriaDep.setText("Deportista no existe.");
             }
         }
         if (optionSelectedDep == 3){
             //Aceptar editar
             String idDep = tfIdDep.getText();
             String nombreDep = tfNombreDep.getText();
             String primerApellidoDep = tfPrimerApellidoDep.getText();
             String segundoApellidoDep = tfSegundoApellidoDep.getText();
             String dniDep = tfDniDep.getText();
             int peso = Integer.parseInt(tfPesoDep.getText());
             int wats = Integer.parseInt(tfWatsDep.getText());


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

             if(model.deportistaExist(idDep) == true){
                 model.editarDeportista(idDep,nombreDep,primerApellidoDep,segundoApellidoDep,dniDep,generoDep,anoNacDep,modalidadBancoMovil,modalidadBancoFijo, peso, wats);
             }
             else{
                 lbCategoriaDep.setText("Deportista no existe.");
             }

             startOptions();
             lbCategoriaDep.setText("Editado correctamente.");
         }
         if(optionSelectedDep == 4){

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

//region Botones Entrenadores menu options
    public void onAddCoachButtonClick(MouseEvent mouseEvent) {
        optionSelectedEnt = 1;

        btnAcceptCoach.setVisible(true);
        btnDeclineCoach.setVisible(true);
        btnEditCoach.setVisible(false);
        btnAddCoach.setVisible(false);
        btnSearchCoach.setVisible(false);
        btnDeleteCoach.setVisible(false);

        tfIdEnt.setDisable(true);
        tfIdEnt.setText("");
        tfNombreEnt.setDisable(false);
        tfNombreEnt.setText("");
        tfPrimerApellidoEnt.setDisable(false);
        tfPrimerApellidoEnt.setText("");
        tfSegundoApellidoEnt.setDisable(false);
        tfSegundoApellidoEnt.setText("");
        tfDniEnt.setDisable(false);
        tfDniEnt.setText("");
        cbGeneroEnt.setDisable(false);
        //Rellenar con tipos de genero.
        lbCategoriaDep.setText("");


        cbCM.setSelected(false);

        cbCF.setSelected(false);
        cbJM.setSelected(false);
        cbJF.setSelected(false);
        cbSM.setSelected(false);
        cbSF.setSelected(false);
        cbVM.setSelected(false);
        cbVF.setSelected(false);

        if(model.categoriaEntrenadorExist(1)){
            cbCM.setDisable(true);
        }else{
            cbCM.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(2)){
            cbCF.setDisable(true);
        }else{
            cbCF.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(3)){
            cbJM.setDisable(true);
        }else{
            cbJM.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(4)){
            cbJF.setDisable(true);
        }else{
            cbJF.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(5)){
            cbSM.setDisable(true);
        }else{
            cbSM.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(6)){
            cbSF.setDisable(true);
        }else{
            cbSF.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(7)){
            cbVM.setDisable(true);
        }else{
            cbVM.setDisable(false);
        }
        if(model.categoriaEntrenadorExist(8)){
            cbVF.setDisable(true);
        }else{
            cbVF.setDisable(false);
        }

        ObservableList<String> genero = FXCollections.observableArrayList("Masculino", "Femenino");
        cbGeneroEnt.setItems(genero);
    }
    public void onSearchCoachButtonClick(MouseEvent mouseEvent) {
        optionSelectedEnt = 2;

        btnAcceptCoach.setVisible(true);
        btnDeclineCoach.setVisible(true);
        btnEditCoach.setVisible(false);
        btnAddCoach.setVisible(false);
        btnSearchCoach.setVisible(false);
        btnDeleteCoach.setVisible(false);

        tfIdEnt.setDisable(true);
        tfIdEnt.setText("");
        tfNombreEnt.setDisable(true);
        tfNombreEnt.setText("");
        tfPrimerApellidoEnt.setDisable(true);
        tfPrimerApellidoEnt.setText("");
        tfSegundoApellidoEnt.setDisable(true);
        tfSegundoApellidoEnt.setText("");
        tfDniEnt.setDisable(false);
        tfDniEnt.setText("");
        cbGeneroEnt.setDisable(true);

        lbCategoriaEnt.setText("");
    }
    public void onEditCoachButtonClick(MouseEvent mouseEvent) {
        optionSelectedEnt = 3;

        btnAcceptCoach.setVisible(true);
        btnDeclineCoach.setVisible(true);
        btnEditCoach.setVisible(false);
        btnAddCoach.setVisible(false);
        btnSearchCoach.setVisible(false);
        btnDeleteCoach.setVisible(false);

        tfIdEnt.setDisable(false);
        tfNombreEnt.setDisable(false);
        tfPrimerApellidoEnt.setDisable(false);
        tfSegundoApellidoEnt.setDisable(false);
        tfDniEnt.setDisable(false);
        cbGeneroEnt.setDisable(false);

    }
    public void onDeleteCoachButtonClick(MouseEvent mouseEvent) {
        optionSelectedEnt = 4;

        lbCategoriaEnt.setText("ELIMINAR - Estas seguro?");

        btnAcceptCoach.setVisible(true);
        btnDeclineCoach.setVisible(true);
        btnEditCoach.setVisible(false);
        btnAddCoach.setVisible(false);
        btnSearchCoach.setVisible(false);
        btnDeleteCoach.setVisible(false);
    }
    public void onAcceptCoachButtonClick(MouseEvent mouseEvent) {
        if (optionSelectedEnt == 1){
            //Aceptar añadir
            String nombreEnt = tfNombreEnt.getText();
            String primerApellidoEnt = tfPrimerApellidoEnt.getText();
            String segundoApellidoEnt = tfSegundoApellidoEnt.getText();
            String dniEntText = tfDniEnt.getText();

            boolean generoEnt;
            if(cbGeneroEnt.getValue() == "Masculino"){
                generoEnt = true;
            }
            else {
                generoEnt = false;
            }

            if (!model.entrenadorExistDni(dniEntText)) {

                model.addEntrenador(nombreEnt, primerApellidoEnt, segundoApellidoEnt, dniEntText, generoEnt);

                if(cbCM.isSelected()){
                    model.addEntrenadorCategoria(1, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbCF.isSelected()){
                    model.addEntrenadorCategoria(2, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbJM.isSelected()){
                    model.addEntrenadorCategoria(3, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbJF.isSelected()){
                    model.addEntrenadorCategoria(4, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbSM.isSelected()){
                    model.addEntrenadorCategoria(5, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbSF.isSelected()){
                    model.addEntrenadorCategoria(6, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbVM.isSelected()){
                    model.addEntrenadorCategoria(7, model.searchEntrenador(dniEntText).getIdent());
                }
                if(cbVF.isSelected()){
                    model.addEntrenadorCategoria(8, model.searchEntrenador(dniEntText).getIdent());
                }
                lbCategoriaEnt.setText("Entrenador añadido.");
                startOptions();
            }
            else{
                lbCategoriaEnt.setText("Entrenador existe.");
            }
        }
        if (optionSelectedEnt == 2){
            //Aceptar buscar
            EntrenadoresEntity entrenador = new EntrenadoresEntity();

            String dniEnt = tfDniEnt.getText();

            if(model.entrenadorExistDni(dniEnt) == true) {
                entrenador = model.searchEntrenador(dniEnt);

                tfIdEnt.setText(String.valueOf(entrenador.getIdent()));
                tfIdEnt.setDisable(true);
                tfNombreEnt.setText(entrenador.getNombre());
                tfPrimerApellidoEnt.setText(entrenador.getPrimerApellido());
                tfSegundoApellidoEnt.setText(entrenador.getSegundoApellido());

                if(entrenador.getGenero()){
                    ObservableList<String> genero = FXCollections.observableArrayList("Masculino");
                    cbGeneroEnt.setValue(genero);
                }
                else{
                    ObservableList<String> genero = FXCollections.observableArrayList("Femenino");
                    cbGeneroEnt.setValue(genero);
                }

                lbCategoriaEnt.setText("");

                btnAcceptCoach.setVisible(false);
                btnDeleteCoach.setVisible(true);
                btnEditCoach.setVisible(true);
                tfDniEnt.setDisable(true);

                if(model.categoriaEntrenadorExist(1)){
                    if(Objects.equals(model.entrenadorCategoria(1), Integer.valueOf(tfIdEnt.getText()))){
                        cbCM.setDisable(false);
                        cbCM.setSelected(true);
                    }else{
                        cbCM.setDisable(true);
                    }
                }else{
                    cbCM.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(2)){
                    if(Objects.equals(model.entrenadorCategoria(2), Integer.valueOf(tfIdEnt.getText()))){
                        cbCF.setDisable(false);
                        cbCF.setSelected(true);

                    }else{
                        cbCF.setDisable(true);
                    }
                }else{
                    cbCF.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(3)){
                    if(Objects.equals(model.entrenadorCategoria(3), Integer.valueOf(tfIdEnt.getText()))){
                        cbJM.setDisable(false);
                        cbJM.setSelected(true);

                    }else{
                        cbJM.setDisable(true);
                    }
                }else{
                    cbJM.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(4)){
                    if(Objects.equals(model.entrenadorCategoria(4), Integer.valueOf(tfIdEnt.getText()))){
                        cbJF.setDisable(false);
                        cbJF.setSelected(true);

                    }else{
                        cbJF.setDisable(true);
                    }
                }else{
                    cbJF.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(5)){
                    if(Objects.equals(model.entrenadorCategoria(5), Integer.valueOf(tfIdEnt.getText()))){
                        cbSM.setDisable(false);
                        cbSM.setSelected(true);

                    }else{
                        cbSM.setDisable(true);
                    }
                }else{
                    cbSM.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(6)){
                    if(Objects.equals(model.entrenadorCategoria(6), Integer.valueOf(tfIdEnt.getText()))){
                        cbSF.setDisable(false);
                        cbSF.setSelected(true);

                    }else{
                        cbSF.setDisable(true);
                    }
                }else{
                    cbSF.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(7)){
                    if(Objects.equals(model.entrenadorCategoria(7), Integer.valueOf(tfIdEnt.getText()))){
                        cbVM.setDisable(false);
                        cbVM.setSelected(true);

                    }else{
                        cbVM.setDisable(true);
                    }
                }else{
                    cbVM.setDisable(false);
                }
                if(model.categoriaEntrenadorExist(8)){
                    if(Objects.equals(model.entrenadorCategoria(8), Integer.valueOf(tfIdEnt.getText()))){
                        cbVF.setDisable(false);
                        cbVF.setSelected(true);

                    }else{
                        cbVF.setDisable(true);
                    }
                }else{
                    cbVF.setDisable(false);
                }
            }
            else{
                lbCategoriaEnt.setText("Entrenador no existe.");
            }
        }
        if (optionSelectedEnt == 3){
            //Aceptar editar
            String idEnt = tfIdEnt.getText();
            String nombreEnt = tfNombreEnt.getText();
            String primerApellidoEnt = tfPrimerApellidoEnt.getText();
            String segundoApellidoEnt = tfSegundoApellidoEnt.getText();
            String dniEnt = tfDniEnt.getText();

            boolean generoEnt;
            if(cbGeneroEnt.getValue() == "Masculino"){
                generoEnt = true;
            }
            else {
                generoEnt = false;
            }

            if(model.entrenadorExist(idEnt) == true) {
                model.editarEntrenador(idEnt, nombreEnt, primerApellidoEnt, segundoApellidoEnt, dniEnt, generoEnt);
            }
            else{
                lbCategoriaEnt.setText("Entrenador no existe.");
            }
            startOptions();
            lbCategoriaEnt.setText("Editado correctamente.");
        }
        if(optionSelectedEnt == 4){

            String idEnt = tfIdEnt.getText();

            model.deleteEntrenador(idEnt);

            startOptions();

            lbCategoriaEnt.setText("Eliminado correctamente.");
        }
    }
    public void onDeclineCoachButtonClick(MouseEvent mouseEvent) {
        startOptions();
    }
//endregion

//region Estadisticas
    private String estadisticasCM() {
        String label = "Cadete Masculino: ";

        label += model.countCM() + "    ";

        return label;
    }
    private String estadisticasCF() {
        String label = "Cadete Femenino: ";

        label += model.countCF();

        return label;
    }
    private String estadisticasJM() {
        String label = "Juvenil Masculino: ";

        label += model.countJM() + "    ";

        return label;
    }
    private String estadisticasJF() {
        String label = "Juvenil Femenino: ";

        label += model.countJF();

        return label;
    }
    private String estadisticasSM() {
        String label = "Senior Masculino: ";

        label += model.countSM() + "    ";

        return label;
    }
    private String estadisticasSF() {
        String label = "Senior Femenino: ";

        label += model.countSF();

        return label;
    }
    private String estadisticasVM() {
        String label = "Veterano Masculino: ";

        label += model.countVM() + "    ";

        return label;
    }
    private String estadisticasVF() {
        String label = "Veterano Femenino: ";

        label += model.countVF();

        return label;
    }

    private void recordJM(){
        String nombre = "JM: ";
        String wats = "";

        DeportistasEntity deportista = model.recordJM();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbJMNombre.setText(nombre);
        lbJMWats.setText(wats);
    }
    private void recordJF(){
        String nombre = "JF: ";
        String wats = "";

        DeportistasEntity deportista = model.recordJF();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbJFNombre.setText(nombre);
        lbJFWats.setText(wats);
    }
    private void recordSM(){
        String nombre = "SM: ";
        String wats = "";

        DeportistasEntity deportista = model.recordSM();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbSMNombre.setText(nombre);
        lbSMWats.setText(wats);
    }
    private void recordSF(){
        String nombre = "SF: ";
        String wats = "";

        DeportistasEntity deportista = model.recordSF();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbSFNombre.setText(nombre);
        lbSFWats.setText(wats);
    }
    private void recordVF(){
        String nombre = "VF: ";
        String wats = "";

        DeportistasEntity deportista = model.recordVF();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbVFNombre.setText(nombre);
        lbVFWats.setText(wats);
    }
    private void recordVM(){
        String nombre = "VM: ";
        String wats = "";

        DeportistasEntity deportista = model.recordVM();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbVMNombre.setText(nombre);
        lbVMWats.setText(wats);
    }
    private void recordCF(){
        String nombre = "CF: ";
        String wats = "";

        DeportistasEntity deportista = model.recordCF();
        if(deportista!=null) {
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbCFNombre.setText(nombre);
        lbCFWats.setText(wats);
    }
    private void recordCM(){
        String nombre = "CM: ";
        String wats = "";

        DeportistasEntity deportista = model.recordCM();
        if(deportista!=null){
            nombre += deportista.getNombre() + " -- ";
            wats = deportista.getWats() + " Wats (" + deportista.getKg() + " Kg)";
        }
        lbCMNombre.setText(nombre);
        lbCMWats.setText(wats);
    }
//endregion

//region info
    public void onEnviarMensajeButtonClick(MouseEvent mouseEvent) {
        lblFechaMensaje.setText("04/01/25 - 17:36");
        lblTextoMensaje.setText(tfMansaje.getText());
    }
//endregion

//region Metodos auxiliares
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
        tfPesoDep.setDisable(true);
        tfPesoDep.setText("");
        tfWatsDep.setDisable(true);
        tfWatsDep.setText("");


        lbCategoriaDep.setText("");

        //Coach
        btnAcceptCoach.setVisible(false);
        btnDeclineCoach.setVisible(false);
        btnEditCoach.setVisible(false);
        btnAddCoach.setVisible(true);
        btnSearchCoach.setVisible(true);
        btnDeleteCoach.setVisible(false);

        tfIdEnt.setDisable(true);
        tfIdEnt.setText("");
        tfNombreEnt.setDisable(true);
        tfNombreEnt.setText("");
        tfPrimerApellidoEnt.setDisable(true);
        tfPrimerApellidoEnt.setText("");
        tfSegundoApellidoEnt.setDisable(true);
        tfSegundoApellidoEnt.setText("");
        tfDniEnt.setDisable(true);
        tfDniEnt.setText("");
        cbGeneroEnt.setDisable(true);

        cbCM.setDisable(true);
        cbCM.setSelected(false);
        cbCF.setDisable(true);
        cbCF.setSelected(false);
        cbJM.setDisable(true);
        cbJM.setSelected(false);
        cbJF.setDisable(true);
        cbJF.setSelected(false);
        cbSM.setDisable(true);
        cbSM.setSelected(false);
        cbSF.setDisable(true);
        cbSF.setSelected(false);
        cbVM.setDisable(true);
        cbVM.setSelected(false);
        cbVF.setDisable(true);
        cbVF.setSelected(false);

        lbCategoriaEnt.setText("");
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


//endregion


}