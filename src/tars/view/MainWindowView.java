package tars.view;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tars.Main;
import tars.controller.ButtonsController;
import tars.controller.MainController;
import tars.model.Model;

public class MainWindowView {
	Model db;
	public static GridPane pane;
	public static SplitPane root;
	public static Scene scene;
	public static Stage stage;
	private static ScrollPane scrPane;
	static FlowPane verGrid;
	static HBox buttonPane;
	static Button changeButton;
	static Button addBeforeButton;
	static Button addAfterButton;
	static Button delButton;
	public static String dbname;
	public static String tablename;
	public static String namefield;
	public static String fieldscontent;
	public static ListView<String> list;
	public MainWindowView(Model m) throws SQLException{
		db = m;
		changeButton = new Button("Изменить");
		addBeforeButton = new Button("Добавить до");		
		addAfterButton = new Button("Добавить после");
		delButton = new Button("Удалить");
		
		
		
		verGrid = new FlowPane(Orientation.HORIZONTAL);
		buttonPane = new HBox();
		root = new SplitPane();
		pane = new GridPane();
		scrPane = new ScrollPane();
		TreeView<String>tree = m.updateResultSet();
		
		buttonPane.getChildren().addAll(changeButton,addBeforeButton,addAfterButton,delButton);
		
		changeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonsController("change"));
		addBeforeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonsController("addbefore"));
		addAfterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonsController("addafter"));
		delButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonsController("del"));
		
		scrPane.setContent(pane);
		buttonPane.setMaxWidth(600);
		scrPane.setPrefSize(600, 550);
		tree.setMaxSize(150, 575);
		tree.setMinSize(150, 575);
		tree.addEventHandler(MouseEvent.MOUSE_CLICKED, new MainController());
		verGrid.getChildren().addAll(scrPane,buttonPane);
		root.getItems().addAll(tree,verGrid);
		scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("[DBAS] v"+Main.version);
		stage.show();
	}
	public void repaint(SplitPane root){
		
	}
}
