package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignupController {

	@FXML
	private void signinButtonHandler(ActionEvent event) {
		try {
			Parent loginPage = FXMLLoader.load(getClass().getResource("/application/resources/loginView.fxml"));
			Scene loginScene = new Scene(loginPage);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(loginScene);
			window.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
