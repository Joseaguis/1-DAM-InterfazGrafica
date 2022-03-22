package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox root = new HBox();
			
			// Creamos tres componentes
			Label _1lblNombre = new Label("Nombre");
			TextField txtNombre = new TextField();
			Button btnSaludar = new Button("Saludar");
			btnSaludar.setOnAction((event) -> {
				System.out.println("Hola " + txtNombre.getText());
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Saludo");
				a.setHeaderText("Bienvenidos|!|");
				a.setContentText("Hola " + txtNombre.getText());
				a.showAndWait();
				System.out.println("Fin");
			});
			
			// Los añado al contenedor principal (root)
			root.getChildren().add(_1lblNombre);
			root.getChildren().add(txtNombre);
			root.getChildren().add(btnSaludar);
			
			
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
