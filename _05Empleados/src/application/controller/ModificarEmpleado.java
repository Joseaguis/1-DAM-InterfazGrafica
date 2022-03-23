package application.controller;

import application.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ModificarEmpleado {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtAnyoIngreso;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtSueldo;
    
    Empleado e;

    @FXML
    void btnAceptarOnAction(ActionEvent event) {
    	try {
			e.setDni(txtDNI.getText());
			e.setNombre(txtNombre.getText());
			e.setAnyo(Integer.parseInt(txtAnyoIngreso.getText()));
			e.setSueldo(Double.parseDouble(txtSueldo.getText()));
    		
	    	Node nodo = (Node) event.getSource();
	    	nodo.getScene().getWindow().hide();
		} catch (NumberFormatException e) {
			System.out.println("Error");
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
    	txtDNI.setText(e.getDni());
    	txtNombre.setText(e.getNombre());
    	txtAnyoIngreso.setText(String.valueOf(e.getAnyo()));
    	txtSueldo.setText(String.format("%.2f €", e.getSueldo()));
    	
    }
}
