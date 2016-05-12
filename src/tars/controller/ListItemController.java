package tars.controller;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import tars.model.Table;
import tars.view.MainWindowView;
public class ListItemController implements EventHandler<MouseEvent> {
	String field,val,table,db;
	ListItemController(String field,String db,String table){
		this.field = field;
		this.table = table;
		this.db = db;
	}
	public void handle(MouseEvent event) {
		ListView<String> list = (ListView) event.getSource();
		val = list.getSelectionModel().getSelectedItem();
		int select = list.getSelectionModel().getSelectedIndex();
		MainWindowView.dbname = db;
		MainWindowView.tablename = table;
		MainWindowView.namefield = field;
		MainWindowView.fieldscontent = val;
		MainWindowView.list = list;
		System.out.println("DB - "+db+" TABLE - "+table);
		for(int i = 0;i < Table.getAllList().size(); i++){
			Table.getList(i).getSelectionModel().select(select);
		}
		
	}

}
