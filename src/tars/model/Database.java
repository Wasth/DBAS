package tars.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import tars.controller.MainController;

public class Database {
	ObservableList<TreeItem> tables = FXCollections.observableArrayList();
	public String name;
	public Database(String name){
		this.name = name;
	}
	public boolean isHas(String table){
		boolean b = false;
		for(int i = 0; i < tables.size();i++){
			if(tables.get(i).getValue().equals(table)){
				b = true;
				System.out.println("Return "+b);
			}
		}
		return b;
	}
}
