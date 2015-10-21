package tars.controller;
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
	@FXML
	public void initialize(){
		
	}
	public void enterClicked(){
		Model m = new Model(usernameField.getText(),passField.getText(),ipField.getText(),portField.getText());
		MainWindowView viewWindow = new MainWindowView(m);
	}
	public void closeClicked(){
		Main.stage.close();
	}
}
