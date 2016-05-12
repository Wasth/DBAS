package tars.controller;

import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tars.model.Model;
import tars.view.MainWindowView;

public class ChangerController {
	@FXML
	TextField txtField;
	@FXML
	void initialize(){
		txtField.setText(MainWindowView.fieldscontent);
		txtField.selectAll();
	}
	@FXML
	void okAction(){
		Statement stat;
		try{
			stat = Model.connect.createStatement();
			String q = "UPDATE "+MainWindowView.dbname + "." 
			+ MainWindowView.tablename+" SET "
			+MainWindowView.namefield+"='"+txtField.getText() + "' WHERE "+MainWindowView.namefield+"='"+MainWindowView.fieldscontent+"';";
			stat.execute(q);
			ButtonsController.stage.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@FXML
	void cancelAction(){
		
	}
}
