package tars.view;

import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tars.model.Model;

public class MainWindowView {
	Model db;
	public MainWindowView(Model m){
		db = m;
		Stage stage = new Stage();
		SplitPane root = new SplitPane();
		GridPane pane = new GridPane();
		Scene scene = new Scene(root);
	}
}
