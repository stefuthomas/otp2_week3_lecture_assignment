package org.example.otp2_week3_lecture_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FuelConsumptionController {
    @FXML
    public Button btnEN;
    @FXML
    public Button btnFR;
    @FXML
    public Button btnIR;
    @FXML
    public Button btnJP;
    @FXML
    public Button btnCalculate;
    @FXML
    public Label labelDistance;
    @FXML
    public TextField textFieldDistance;
    @FXML
    public Label labelFuel;
    @FXML
    public TextField textFieldFuel;
    @FXML
    public Label labelResult;

    private ResourceBundle resourceBundle;

    @FXML
    private void initialize() {
        btnEN.setOnAction(this::setEN);
        btnFR.setOnAction(this::setFR);
        btnJP.setOnAction(this::setJP);
        btnIR.setOnAction(this::setIR);
        btnCalculate.setOnAction(this::calculate);
    }

    private void calculate(ActionEvent actionEvent) {
        try {
            double distance = Double.parseDouble(textFieldDistance.getText());
            double fuel = Double.parseDouble(textFieldFuel.getText());
            double result = fuel / distance * 100;
            labelResult.setText(String.format(resourceBundle.getString("result.label"), String.format("%.2f", result)));
            labelResult.setVisible(true);
        } catch (NumberFormatException e) {
            labelResult.setText(resourceBundle.getString("invalid.input"));
            labelResult.setVisible(true);
        }
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    private void setFR(ActionEvent actionEvent) {
        Locale l = new Locale("fr", "FR");
        loadView(l);
    }

    public void setEN(ActionEvent actionEvent) {
        Locale l = new Locale("en", "EN");
        loadView(l);
    }

    public void setIR(ActionEvent actionEvent) {
        Locale l = new Locale("fa", "IR");
        loadView(l);
    }

    public void setJP(ActionEvent actionEvent) {
        Locale l = new Locale("ja", "JP");
        loadView(l);
    }

    public void loadView(Locale locale) {
        FXMLLoader fxmlLoader = new FXMLLoader(FuelConsumptionController.class.getResource("view.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("message", locale));
        try {
            Parent root = fxmlLoader.load();
            FuelConsumptionController controller = fxmlLoader.getController();
            controller.setResourceBundle(fxmlLoader.getResources());
            Stage stage = (Stage) btnEN.getScene().getWindow();
            stage.setScene(new Scene(root, 400, 500));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}