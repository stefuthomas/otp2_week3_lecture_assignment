package org.example.otp2_week3_lecture_assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class FuelConsumptionApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FuelConsumptionController.class.getResource("view.fxml"));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message_en");
        fxmlLoader.setResources(resourceBundle);
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        FuelConsumptionController controller = fxmlLoader.getController();
        controller.setResourceBundle(resourceBundle);
        stage.setTitle("Stefanos Thomas");
        stage.setMinWidth(400);
        stage.setMinHeight(300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}