package tars;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tars.model.Model;

public class Main extends Application{
	public static float version = 0.1f;
	public static Stage stage;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage primaryStage){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/LoginWindow.fxml"));
		AnchorPane pane = null;
		try{
			pane = (AnchorPane) loader.load();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		Scene scene = new Scene(pane);
		stage = primaryStage;
		stage.setTitle("Login [DBAS] v"+version);
		stage.setScene(scene);
		stage.show();
	}
	public void stop() throws SQLException{
		//Model.connect.close();
		System.out.println("Закрываем соединение.");
	}


}
