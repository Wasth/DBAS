package tars.view;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Statement;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tars.Main;
import tars.controller.MainController;
import tars.model.Model;

public class MainWindowView {
	Model db;
	public static GridPane pane;
	public static SplitPane root;
	public static Scene scene;
	public static Stage stage;
	public MainWindowView(Model m) throws SQLException{
		db = m;
		root = new SplitPane();
		pane = new GridPane();
		TreeView<String>tree = m.updateResultSet();
		pane.setPrefSize(750, 500);
		tree.setMaxSize(150, 500);
		tree.setMinSize(150, 500);
		tree.addEventHandler(MouseEvent.MOUSE_CLICKED, new MainController());
		root.getItems().addAll(tree,pane);
		scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Work Window [DBAS] v"+Main.version);
		stage.show();
	}
	public void repaint(SplitPane root){
		
	}
}
