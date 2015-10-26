package tars.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import tars.model.Database;
import tars.model.Model;
import tars.view.MainWindowView;;

public class MainController implements EventHandler<MouseEvent>{
	public void handle(MouseEvent event) {
		TreeView<String> item = (TreeView<String>) event.getSource();
		String selection = "";
		try{
			selection = item.getSelectionModel().getSelectedItem().getValue();
		}catch(Exception ex){
			System.out.println("Error. Exception mes: "+ex.getMessage());
		}
		System.out.println("Clicked: "+selection);
		for(int i = 0;i < Model.DBS.size();i++){
			if(Model.DBS.get(i).isHas(selection)){
				Statement stat = null;
				try {
					stat = Model.connect.createStatement();
					ResultSet rs = null;
					String exe = "DESCRIBE "+Model.DBS.get(i).name+"."+selection;
					rs = stat.executeQuery(exe);
					System.out.println(exe);
					int j = 0;
					MainWindowView.pane.getChildren().clear();
					TableView<String>tablesView = new TableView<String>();
					tablesView.setPrefHeight(500);
					tablesView.setPrefWidth(750);
					while(rs.next()){
						TableColumn<String,String> col = new TableColumn<String,String>(rs.getString("Field"));
						//tablesView.getColumns().
						tablesView.getColumns().add(col);
						tablesView.setEditable(true);
						j++;
					}
					tablesView.getItems().add("Qew");
					MainWindowView.pane.add(tablesView,0,0);
				} catch (Exception e) {
					System.out.println("EXception: "+e.getMessage());
			
				}
			}
		}
		
	}
}
