package tars.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tars.model.Model;

public class MainWindowView {
	Model db;
	public MainWindowView(Model m){
		db = m;
		;
		SplitPane root = new SplitPane();
		GridPane pane = new GridPane();
		pane.add(new Label("1"), 0, 0);
		pane.add(new Label("2"), 1, 0);
		pane.add(new Label("3"), 2, 0);

		Scene scene = new Scene(pane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
}
