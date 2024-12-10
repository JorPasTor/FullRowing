package org.example.fullrowing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FullRowingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FullRowingApplication.class.getResource("FullRowing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 470);

        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        stage.setMinWidth(620);
        stage.setMinHeight(470);
        stage.setMaxWidth(620);
        stage.setMaxHeight(470);
        stage.setTitle("FULLROWING!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}