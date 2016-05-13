package tars.controller;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import tars.model.Database;
import tars.model.Model;
import tars.model.Table;
import tars.view.MainWindowView;;

public class MainController implements EventHandler<MouseEvent>{
	public void handle(MouseEvent event) {
		showTables(event);
		
	}
	public static void showTables(MouseEvent event){
		TreeView<String> item = (TreeView<String>) event.getSource();
		String selection = "";
		Table.clear();
		try{
			selection = item.getSelectionModel().getSelectedItem().getValue();
		}catch(Exception ex){
			System.out.println("Error. Exception mes: "+ex.getMessage());
		}
		System.out.println("Clicked: "+selection);
		MainWindowView.list = null;
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
				   
					while(rs.next()){
						ListView<String> list = new ListView<String>();
						
						String field = rs.getString("Field");
						Label label = new Label(" "+field+" ");
						MainWindowView.pane.add(label,j,i);
						System.out.println("Field "+field);
						Statement stat1 = Model.connect.createStatement(); 
						ResultSet rest = stat1.executeQuery("SELECT * FROM " + Model.DBS.get(i).name+"."+selection+";");
						int c = 0;
						while(rest.next()){
	
							list.getItems().add(rest.getString(field));
							c++;
						}
						if (c >= 16){
						list.setPrefHeight(list.getHeight()+(25*c));	
						}
						list.addEventHandler(MouseEvent.MOUSE_CLICKED, new ListItemController(field,Model.DBS.get(i).name,selection));
						Table.addList(list);
						Table.addLabel(label);
						MainWindowView.pane.add(list,j,i+1);
						j++;
						
					}
					
				} catch (Exception e) {
					System.out.println("EXception: "+e.getMessage());
			
				}
			}
		}		
	}
	public static void showTables(TreeView<String> itemTree){
		TreeView<String> item = itemTree;
		String selection = "";
		Table.clear();
		try{
			selection = MainWindowView.tablename;
			System.out.println("OK");
		}catch(Exception ex){
			System.out.println("Error. Exception mes: "+ex.getMessage());
		}
		System.out.println("Clicked: "+selection);
		MainWindowView.list = null;
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
				   
					while(rs.next()){
						ListView<String> list = new ListView<String>();
						
						String field = rs.getString("Field");
						Label label = new Label(" "+field+" ");
						MainWindowView.pane.add(label,j,i);
						System.out.println("Field "+field);
						Statement stat1 = Model.connect.createStatement(); 
						ResultSet rest = stat1.executeQuery("SELECT * FROM " + Model.DBS.get(i).name+"."+selection+";");
						int c = 0;
						while(rest.next()){
	
							list.getItems().add(rest.getString(field));
							c++;
						}
						if (c >= 16){
						list.setPrefHeight(list.getHeight()+(25*c));	
						}
						list.addEventHandler(MouseEvent.MOUSE_CLICKED, new ListItemController(field,Model.DBS.get(i).name,selection));
						Table.addList(list);
						Table.addLabel(label);
						MainWindowView.pane.add(list,j,i+1);
						j++;
						
					}
					
				} catch (Exception e) {
					System.out.println("EXception: "+e.getMessage());
			
				}
			}
		}		
	}
}
