package adivinApp;

import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{

	Scanner entrada=new Scanner(System.in);
	
	private Label compruebaLabel;
	private Button comprobarButton;
	private TextField nombreText;
	int count=0;
	int numero=(int)(Math.random()*100+1);
	
	public void start(Stage primaryStage) throws Exception {
		
		nombreText=new TextField();
		nombreText.setPromptText("Introduce un número");
		nombreText.setMaxWidth(150);
		nombreText.setAlignment(Pos.CENTER);
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> oncomprobarButtonAction(e));
		
		compruebaLabel = new Label("Introduce un número del 1 al 100");
		
		VBox root= new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll( compruebaLabel,nombreText, comprobarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void oncomprobarButtonAction(ActionEvent e) {
			count++;
			try {
	      int respuesta;
	      respuesta=Integer.parseInt((nombreText.getText()));
	      
	      if(respuesta > 100 | respuesta < 1) {
	    	  Alert error = new Alert(AlertType.ERROR);
	    	  error.setTitle("Error");
	    	  error.setHeaderText("Ese número o esta dentro del intervalo.");
	    	  error.setContentText("Se te han sumado 2 fallos campeón");
	    	  error.showAndWait();
	    	  
	      }
	         
	      if (respuesta == numero){
	    	  Alert victoria = new Alert(AlertType.INFORMATION);
	    	  victoria.setTitle("¡Has ganado!");
	    	  victoria.setHeaderText("Sólo has necesitado " + count + " intentos.");
	    	  victoria.setContentText("Vuelve a jugar y hazlo mejor.");
	    	  victoria.showAndWait();
	      }
	      else{
	    	  if(respuesta > numero){
	    		  Alert esMenor = new Alert(AlertType.WARNING);
		    	  esMenor.setTitle("¡Has fallado!");
		    	  esMenor.setHeaderText("El número a adivinar es menor que " + respuesta + ".");
		    	  esMenor.setContentText("Vuelve a intentarlo.");
		    	  esMenor.showAndWait();
	    	  }else {
	    		  Alert esMayor = new Alert(AlertType.WARNING);
	    		  esMayor.setTitle("¡Has fallado!");
		    	  esMayor.setHeaderText("El número a adivinar es mayor que " + respuesta + ".");
		    	  esMayor.setContentText("Vuelve a intentarlo.");
		    	  esMayor.showAndWait();
	    	  }
	      }
			}catch(Exception e1){
				Alert error = new Alert(AlertType.ERROR);
	    		  error.setTitle("Error");
		    	  error.setHeaderText("El número introducido no es válido.");
		    	  error.showAndWait();
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
