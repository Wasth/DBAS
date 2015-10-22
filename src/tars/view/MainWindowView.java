package tars.view;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Statement;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tars.Main;
import tars.model.Model;

public class MainWindowView {
	Model db;
	public MainWindowView(Model m) throws SQLException{
		db = m;
		SplitPane root = new SplitPane();
		GridPane pane = new GridPane();
		TreeItem<String>treeRoot = new TreeItem<String>("Databases");
		TreeView<String>tree = new TreeView<String>(treeRoot);
		Statement stat = m.connect.createStatement();
		ResultSet res = stat.executeQuery("SHOW DATABASES;");
		
		root.getItems().addAll(tree,pane);
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Work Window [DBAS] v"+Main.version);
		stage.show();
	}
}
