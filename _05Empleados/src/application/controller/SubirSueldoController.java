package application.controller;

import application.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SubirSueldoController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtPorcetajeSubida;

    @FXML
    private TextField txtSueldoActual;
    
    private Empleado e;

    @FXML
    void btnAceptarOnAction(ActionEvent event) {
    	double porcentaje = 0;
    	try {
			porcentaje = Double.parseDouble(txtPorcetajeSubida.getText());
			e.incrementarSueldo(porcentaje);
	    	Node nodo = (Node) event.getSource();
	    	nodo.getScene().getWindow().hide();
		} catch (NumberFormatException e) {
			
		}
    	
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
    	
    }

    public void setEmpleado(Empleado e) {
    	this.e = e;
    	actualizarFormulario();
    }
    
    public Empleado getEmpleado() {
    	return e;
    }
    
    private void actualizarFormulario() {
    	txtSueldoActual.setText(String.format("%.2f ?",e.getSueldo()));
    }
}
