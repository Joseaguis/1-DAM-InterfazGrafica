package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SaludarController {

    @FXML
    private Button btnSaludar;

    @FXML
    private TextField txtNombre;

    @FXML
    void btnSaludarOnAction(ActionEvent event) {
    	System.out.println("Hola " + txtNombre.getText());
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Saludo");
		a.setHeaderText("Bienvenidos|!|");
		a.setContentText("Hola " + txtNombre.getText());
		a.showAndWait();
		System.out.println("Fin");
    }

}
