package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
	
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
	
	@FXML
	private void loginButtonHandler(ActionEvent event) {
		try {
			Parent mainPage = FXMLLoader.load(getClass().getResource("/application/resources/UserInterface.fxml"));
			Scene mainScene = new Scene(mainPage);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(mainScene);
			window.setX(200);
			window.setY(10);
			window.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
