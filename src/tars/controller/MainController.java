package tars.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import tars.model.Model;
import tars.view.MainWindowView;;

public class MainController implements EventHandler<MouseEvent>{
	public void handle(MouseEvent event) {
		TreeView<String> item = (TreeView) event.getSource();
		String selection = item.getSelectionModel().getSelectedItem().getValue();
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
					while(rs.next()){
						MainWindowView.pane.add(new Label(rs.getString("Field")+"\t"),j,0);
						j++;
					}
				} catch (Exception e) {
					System.out.println("EXception: "+e.getMessage());
			
				}
			}
		}
		
	}
}
