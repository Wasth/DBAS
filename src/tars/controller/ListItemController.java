package tars.controller;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
public class ListItemController implements EventHandler<MouseEvent> {
	String field,val,table,db;
	ListItemController(String field,String table,String db){
		this.field = field;
		this.table = table;
		this.db = db;
	}
	public void handle(MouseEvent event) {
		ListView<String> list = (ListView) event.getSource();
		val = list.getSelectionModel().getSelectedItem();
		System.out.println(field+" "+val);
	}

}