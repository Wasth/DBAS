package tars.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import tars.controller.MainController;

public class Database {
	StringProperty id = new SimpleStringProperty("Lx");
	public ObservableList<TreeItem> tables = FXCollections.observableArrayList();
	public ObservableList<String> strValues = FXCollections.observableArrayList();
	public StringProperty[] tablesStringProperty;
	public String name;
	public Database(String name){
		this.name = name;
	}
	public void update() throws SQLException{
		tablesStringProperty = new StringProperty[tables.size()];
		for(int i = 0;i < tables.size();i++){
			System.out.println("Constructor in Database cycle()");
			String prop = tables.get(i).getValue().toString();
		//	Statement stat = Model.connect.createStatement();
		//	ResultSet rs = stat.executeQuery("SELECT "+prop+" FROM "+name+prop);
			tablesStringProperty[i] = new SimpleStringProperty("j4f");
			strValues.add(i, prop);
		}
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
