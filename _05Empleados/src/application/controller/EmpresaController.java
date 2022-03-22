package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Empleado;
import application.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmpresaController implements Initializable {

    Empresa e;
    int posActual = 0;
	
	@FXML
    private TextField txtNombreEmpresa;

    @FXML
    private Button btnAnterior;
    
    @FXML
    private Button btnSubirSueldo;
    
    @FXML
    private Button btnPrimero;

    @FXML
    private Button btnSiguiente;

    @FXML
    private Button btnUltimo;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtAnyo;

    @FXML
    private TextField txtSueldo;
    
    @FXML
    private Label txtNumEmpleados;

    @FXML
    void btnAnteriorOnAction(ActionEvent event) {
    	if (posActual > 0) {
    		posActual--;
    		actualizarFormulario();
		}
    }

    @FXML
    void btnPrimeroOnAction(ActionEvent event) {
    	if (posActual > 0) {
    		posActual = 0;
    		actualizarFormulario();
		}
    }

    @FXML
    void btnSiguienteOnAction(ActionEvent event) {
    	if (posActual < e.getPlantilla().size() - 1) {
    		posActual++;
    		actualizarFormulario();
		}
    	
    }

    @FXML
    void btnUltimoOnAction(ActionEvent event) {
    	if (posActual < e.getPlantilla().size() - 1) {
    		posActual = e.getPlantilla().size() - 1;
    		actualizarFormulario();
		}
    }
    
    @FXML
    void btnSubirSueldoOnAction(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		e = new Empresa("Programadores en Acción");
		e.contratar(new Empleado("Pepe", "3481286C", 2000, 1750));
		e.contratar(new Empleado("Luis", "8414846A", 2018, 2500));
		e.contratar(new Empleado("Jose", "9867452B", 2015, 1200));
		e.contratar(new Empleado("Agustin", "7865478J", 1996, 2600));
		actualizarFormulario();
	}
    
    public void actualizarFormulario() {
    	txtNombreEmpresa.setText(e.getNombre());
    	Empleado emp = e.getPlantilla().get(posActual);
    	txtDNI.setText(emp.getDni());
    	txtNombre.setText(emp.getNombre());
    	txtAnyo.setText(String.valueOf(emp.getAnyo()));
    	txtSueldo.setText(String.format("%.2f€", emp.getSueldo()));
    	txtNumEmpleados.setText(String.format("Empleado %d de %d", posActual + 1, e.getPlantilla().size()));
    	
    	if (posActual == 0) {
			btnPrimero.setDisable(true);
			btnAnterior.setDisable(true);
		} else {
			btnPrimero.setDisable(false);
			btnAnterior.setDisable(false);
		}
    	
    	if (posActual == e.getPlantilla().size() - 1) {
			btnSiguiente.setDisable(true);
			btnUltimo.setDisable(true);
		} else {
			btnSiguiente.setDisable(false);
			btnUltimo.setDisable(false);
		}
    }
}
