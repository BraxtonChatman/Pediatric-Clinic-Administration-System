package application.controllers;

import java.io.IOException;
import application.Clinic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	private Clinic mainClinic;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	/**
	 * signupButtonHandler loads the view for the signup page and switches to it
	 * @param event
	 */
	@FXML
	private void signupButtonHandler(ActionEvent event) {
		try {
			Parent signupPage = FXMLLoader.load(getClass().getResource("/application/resources/signupView.fxml"));
			Scene signupScene = new Scene(signupPage);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(signupScene);
			window.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * loginButtonHandler calls the Clinic.login method with the input parameters from the user
	 * to validate login. If user entered credentials are valid, then the main UserInterface
	 * is loaded. If not, the user is prompted to retry login.
	 * @param event
	 */
	@FXML
	private void loginButtonHandler(ActionEvent event) {
		boolean successfulLogin = mainClinic.login(usernameField.getText(), passwordField.getText());
		
		// login successful 
		if(successfulLogin) {
			try {
				// load UserInterface.fxml as the new scene
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/UserInterface.fxml"));
				Scene mainScene = new Scene(loader.load());
				
				// pass mainClinic to UserInterfaceController, and load the tabs
				UserInterfaceController controller = loader.getController();
				controller.setClinic(mainClinic);
				controller.loadTabContent();
				
				// set stage
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(mainScene);
				window.setWidth(800);
				window.setHeight(630);
				window.setX(200);
				window.setY(10);
				window.show();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// on invalid login, prompt reattempt
		else {
			Alert loginError = new Alert(Alert.AlertType.ERROR);
			loginError.setTitle("Login Error");
			loginError.setHeaderText(null);
			loginError.setContentText("Invalid Username or Password. Please try again.");
			loginError.showAndWait();
		}
		

	}
	
	public void setClinic(application.Clinic newClinic) {
		this.mainClinic = newClinic;
	}
}
