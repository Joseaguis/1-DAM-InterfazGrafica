package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.CambioInsuficienteException;
import application.model.CreditoInsuficienteException;
import application.model.Expendedora;
import application.model.StockInsuficienteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ExpendedoraController implements Initializable {

	Expendedora e;
	
    @FXML
    private Button btn00;

    @FXML
    private Button btn01;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private TextField txtCambio;

    @FXML
    private TextField txtCredito;

    @FXML
    private Button btnDevolver;

    @FXML
    private Button btnDinero00;

    @FXML
    private Button btnDinero01;

    @FXML
    private Button btnDinero02;

    @FXML
    private Button btnDinero10;

    @FXML
    private Button btnDinero11;

    @FXML
    private Button btnDinero12;

    @FXML
    private TextField txtVenta;

    @FXML
    private TextField cantidad00;

    @FXML
    private TextField cantidad01;

    @FXML
    private TextField cantidad10;

    @FXML
    private TextField cantidad11;

    @FXML
    private TextField cantidad20;

    @FXML
    private TextField cantidad21;

    @FXML
    private TextField precio01;

    @FXML
    private TextField precio10;

    @FXML
    private TextField precio11;

    @FXML
    private TextField precio20;

    @FXML
    private TextField precio21;

    @FXML
    private TextField preicio00;

    @FXML
    void btn00OnAction(ActionEvent event) {
    	compra(0);
    }
    @FXML
    void btn01OnAction(ActionEvent event) {
    	compra(3);
    }

    @FXML
    void btn10OnAction(ActionEvent event) {
    	compra(1);
    }

    @FXML
    void btn11OnAction(ActionEvent event) {
    	compra(4);
    }

    @FXML
    void btn20OnAction(ActionEvent event) {
    	compra(2);
    }

    @FXML
    void btn21OnAction(ActionEvent event) {
    	compra(5);
    }

    @FXML
    void btnDinero00OnAction(ActionEvent event) {
      	e.setCredito(e.getCredito() + 2);
    	actualizarFormulario();
    }

    @FXML
    void btnDinero01OnAction(ActionEvent event) {
      	e.setCredito(e.getCredito() + 0.50);
    	actualizarFormulario();
    }

    @FXML
    void btnDinero02OnAction(ActionEvent event) {
      	e.setCredito(e.getCredito() + 0.10);
    	actualizarFormulario();
    }

    @FXML
    void btnDinero10OnAction(ActionEvent event) {
      	e.setCredito(e.getCredito() + 1);
    	actualizarFormulario();
    }

    @FXML
    void btnDinero11OnAction(ActionEvent event) {
      	e.setCredito(e.getCredito() + 0.20);
    	actualizarFormulario();
    }

    @FXML
    void btnDinero12OnAction(ActionEvent event) {
      	e.setCredito(e.getCredito() + 0.05);
    	actualizarFormulario();
    }
    
    @FXML
    void btnDevolverOnAction(ActionEvent event) {
    	double devolucion = e.devolverCredito();
    	if (devolucion != 0) {
    		Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Cambio");
			a.setHeaderText("Devolucion de cambio");
			a.setContentText(String.format("Aqui tiene sus %.2f €", devolucion));
			a.showAndWait();
		}
    	actualizarFormulario();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	String[] nombreProd = {"Coca Cola", "Fanta Limon", "Pepsi", "Fanta Naranja", "Nestea", "Aquarius"	};
    	double[] precioProd = {1.,1.10,1.20,0.90,0.95,1.05};
    	int[] stockProd = {5,6,7,8,2,1};
    	e = new Expendedora(10,nombreProd , precioProd, stockProd);
    	actualizarFormulario();
    }
    
    public void compra(int i) {
    	try {
    		double devolucion = e.comprar(i);
 	    	
 	    	Alert a = new Alert(AlertType.INFORMATION);
 			a.setTitle("Cambio");
 			a.setHeaderText("Devolucion de cambio");
 			a.setContentText(String.format("Aqui tiene sus %.2f €", devolucion));
 			a.showAndWait();
 		} catch (CambioInsuficienteException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setHeaderText("Cambio Insuficiente");
				a.setContentText("La maquina expendedora no tiene cambio suficiente");
				a.showAndWait();
 		} catch (CreditoInsuficienteException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error");
			a.setHeaderText("Credito insuficiente");
			a.setContentText("Introduzca mas dinero");
			a.showAndWait();
 		} catch (StockInsuficienteException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error");
			a.setHeaderText("Stock Insuficiente");
			a.setContentText("Elija otro producto");
			a.showAndWait();
 		}

 	    actualizarFormulario();
    }
    
    public void actualizarFormulario() {
    	txtCredito.setText(String.valueOf(e.getCredito()) + " €");
    	txtCambio.setText(String.valueOf(e.getCambioDisponible()) + " €");
    	txtVenta.setText(String.valueOf(e.getImporteVentas()) + " €");
    	
    	cantidad00.setText(String.valueOf(e.getStock(0)));
    	cantidad10.setText(String.valueOf(e.getStock(1)));
    	cantidad20.setText(String.valueOf(e.getStock(2)));
    	cantidad01.setText(String.valueOf(e.getStock(3)));
    	cantidad11.setText(String.valueOf(e.getStock(4)));
    	cantidad21.setText(String.valueOf(e.getStock(5)));
    	
    	btn00.setText(e.getNombre(0));
    	btn10.setText(e.getNombre(1));
    	btn20.setText(e.getNombre(2));
    	btn01.setText(e.getNombre(3));
    	btn11.setText(e.getNombre(4));
    	btn21.setText(e.getNombre(5));
    	
    }

}
