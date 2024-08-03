package application.controllers;

import application.Clinic;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserInterfaceController {

	private Clinic mainClinic;
	private PatientAccountController patientAccountController;
	
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
	private void signoutButtonHandler(ActionEvent event) {
		// run logout tasks for the Clinic object
		mainClinic.logout();
		
		try {
			// load loginView.fxml as the new scene
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/loginView.fxml"));
			Scene loginScene = new Scene(loader.load());
			
			// pass the Clinic to the LoginController
			LoginController controller = loader.getController();
			controller.setClinic(mainClinic);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.setWidth(350);
			window.setHeight(350);
			window.setX(450);
			window.setY(150);
			window.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void initialize() {
		try {
			// account tab
			FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("/application/resources/patientAccountView.fxml"));
			AnchorPane accountTabContent = accountLoader.load();
			patientAccountController = accountLoader.getController();
			accountTab.setContent(accountTabContent);
			
			// visits tab
			AnchorPane visitsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/visitView.fxml"));
			visitsTab.setContent(visitsTabContent);
			
			// messages tab
			AnchorPane messagesTabContent = FXMLLoader.load(getClass().getResource("/application/resources/messageView.fxml"));
			messagesTab.setContent(messagesTabContent);
			
			// prescriptions tab
			AnchorPane prescriptionsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/prescriptionView.fxml"));
			prescriptionsTab.setContent(prescriptionsTabContent);
			
			// add listener to account tab for tab switching to restore fields
			landingPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
				if(oldTab != null && accountTab.equals(oldTab)) {
						patientAccountController.showInfo();
				}	
			});
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public void setClinic(Clinic newClinic) {
		this.mainClinic = newClinic;
	}
	
	public void setPatientAccountController(PatientAccountController newController) {
		this.patientAccountController = newController;
	}
	
	public void loadTabContent() {
		landingPane.getTabs().clear();
		
		// user is a provider
		if(mainClinic.getProviderStatus()) {
			landingPane.getTabs().add(visitsTab);
			landingPane.getTabs().add(messagesTab);
		}
		
		// user is a patient
		else {
			// add account tab, and fill entries based on user account data from clinic
			landingPane.getTabs().add(accountTab);
			patientAccountController.setCurrentPatient(mainClinic.viewPatientSelf());
			patientAccountController.showInfo();
			
			landingPane.getTabs().add(visitsTab);
			landingPane.getTabs().add(messagesTab);
			landingPane.getTabs().add(prescriptionsTab);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void loadTabContent(int x) {
		try {
			landingPane.getTabs().clear();
			
			// user is provider
			if(mainClinic.getProviderStatus()) {			
				landingPane.getTabs().add(visitsTab);
				AnchorPane visitsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/visitView.fxml"));
				visitsTab.setContent(visitsTabContent);
				
				landingPane.getTabs().add(messagesTab);
				AnchorPane messagesTabContent = FXMLLoader.load(getClass().getResource("/application/resources/messageView.fxml"));
				messagesTab.setContent(messagesTabContent);
			}
			
			// user is patient
			else {
				// account tab
				landingPane.getTabs().add(accountTab);
				FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("/application/resources/patientAccountView.fxml"));
				AnchorPane accountTabContent = accountLoader.load();
				PatientAccountController patientAccountController = accountLoader.getController();
				patientAccountController.setCurrentPatient(mainClinic.viewPatientSelf());
				patientAccountController.showInfo();
				accountTab.setContent(accountTabContent);
				
				
				// visits tab
				landingPane.getTabs().add(visitsTab);
				AnchorPane visitsTabContent = FXMLLoader.load(getClass().getResource("/application/resources/visitView.fxml"));
				visitsTab.setContent(visitsTabContent);
				
				// messages tab
				landingPane.getTabs().add(messagesTab);
				AnchorPane messagesTabContent = FXMLLoader.load(getClass().getResource("/application/resources/messageView.fxml"));
				messagesTab.setContent(messagesTabContent);
				
				// prescriptions tab
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



