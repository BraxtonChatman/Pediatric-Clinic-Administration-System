package application.controllers;

import application.Clinic;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class UserInterfaceController {

	private Clinic mainClinic;
	
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
	
//	@FXML
//	public void initialize() {
//		loadTabContent();
//	}
	
	public void setClinic(Clinic newClinic) {
		this.mainClinic = newClinic;
	}
	
	public void loadTabContent() {
		try {
			landingPane.getTabs().clear();
			
			// user is provider
			if(mainClinic.getProviderStatus()) {
				// TODO : change to providerAccountView.fxml
				landingPane.getTabs().add(accountTab);
				AnchorPane accountTabContent = FXMLLoader.load(getClass().getResource("/application/resources/patientAccountView.fxml"));
				accountTab.setContent(accountTabContent);
				
				landingPane.getTabs().add(visitsTab);
				AnchorPane visitsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/visitView.fxml"));
				visitsTab.setContent(visitsTabContent);
				
				landingPane.getTabs().add(messagesTab);
				AnchorPane messagesTabContent = FXMLLoader.load(getClass().getResource("/application/resources/messageView.fxml"));
				messagesTab.setContent(messagesTabContent);
			}
			
			// user is patient
			else {
				landingPane.getTabs().add(accountTab);
				AnchorPane accountTabContent = FXMLLoader.load(getClass().getResource("/application/resources/patientAccountView.fxml"));
				accountTab.setContent(accountTabContent);
				
				landingPane.getTabs().add(visitsTab);
				AnchorPane visitsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/visitView.fxml"));
				visitsTab.setContent(visitsTabContent);
				
				landingPane.getTabs().add(messagesTab);
				AnchorPane messagesTabContent = FXMLLoader.load(getClass().getResource("/application/resources/messageView.fxml"));
				messagesTab.setContent(messagesTabContent);
				
				landingPane.getTabs().add(prescriptionsTab);
				AnchorPane prescriptionsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/prescriptionView.fxml"));
				prescriptionsTab.setContent(prescriptionsTabContent);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
