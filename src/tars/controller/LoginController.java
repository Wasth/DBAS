package tars.controller;
import java.io.*;
import java.sql.SQLException;

import javafx.fxml.*;
import javafx.scene.control.*;
import tars.Main;
import tars.model.Model;
import tars.view.MainWindowView;
public class LoginController {
	@FXML
	TextField usernameField;
	@FXML
	PasswordField passField;
	@FXML
	TextField ipField;
	@FXML
	TextField portField;
	@FXML
	Label infoLabel;
	File file = new File(".loginSettings");
	BufferedReader reader = null;
	PrintWriter writer = null;
	@FXML
	public void initialize() throws IOException{
		if(file.exists()){
			reader = new BufferedReader(new FileReader(file));
			usernameField.setText(reader.readLine());
			passField.setText(reader.readLine());
			ipField.setText(reader.readLine());
			portField.setText(reader.readLine());
		}
	}
	public void enterClicked() throws IOException, SQLException{
		

		if(!file.exists()){
			file.createNewFile();
			writer = new PrintWriter(file);
			writer.println(usernameField.getText());
			writer.println(passField.getText());
			writer.println(ipField.getText());
			writer.println(portField.getText());
			writer.flush();
			writer.close();
		}
		
		
		Model m = new Model(usernameField.getText(),passField.getText(),ipField.getText(),portField.getText());
		MainWindowView viewWindow = new MainWindowView(m);
		Main.stage.close();
	}
	public void closeClicked(){
		Main.stage.close();
	}
}
