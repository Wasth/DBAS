package tars.controller;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tars.Main;
import tars.view.MainWindowView;


public class ButtonsController implements EventHandler<MouseEvent>{
	String act;
	public static Stage stage;
	public ButtonsController(String action){
		act = action;
	}
	public void handle(MouseEvent ev){
		try{
			if(act.equals("change")){
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("view/ChangesWindow.fxml"));
				AnchorPane pane = null;
				try{
					pane = (AnchorPane) loader.load();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				Scene scene = new Scene(pane);
				stage = new Stage();
				stage.setTitle("Enter");
				stage.setScene(scene);
				stage.show();
			}
		}catch(NullPointerException ex){
			
		}
	}
}
