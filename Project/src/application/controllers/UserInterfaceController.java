package application.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class UserInterfaceController {

	@FXML
	private TabPane landingPane;
	
	@FXML
	private Tab accountTab;
	
	@FXML
	private Tab visitsTab;
	
	@FXML
	private Tab messagesTab;
	
	@FXML
	private Tab prescriptionsTab;
	
	@FXML
	public void initialize() {
		loadTabContent();
	}
	
	private void loadTabContent() {
		
		try {
			AnchorPane accountTabContent = FXMLLoader.load(getClass().getResource("/application/resources/patientAccountView.fxml"));
			accountTab.setContent(accountTabContent);
			
			AnchorPane visitsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/visitView.fxml"));
			visitsTab.setContent(visitsTabContent);
			
			AnchorPane messagesTabContent = FXMLLoader.load(getClass().getResource("/application/resources/messageView.fxml"));
			messagesTab.setContent(messagesTabContent);
			
			AnchorPane prescriptionsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/prescriptionView.fxml"));
			prescriptionsTab.setContent(prescriptionsTabContent);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
