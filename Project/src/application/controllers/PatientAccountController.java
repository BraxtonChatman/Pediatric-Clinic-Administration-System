package application.controllers;

import java.time.LocalDate;
import java.util.Optional;

import application.Clinic;
import application.PatientAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientAccountController {

	private PatientAccount currentPatient;
	
	private Clinic mainClinic;
	
	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private DatePicker birthdayPicker;
	
	@FXML
	private TextField phoneNumberField;
	
	@FXML
	private TextField emailAddressField;
	
	@FXML
	private TextArea insuranceArea;
	
	@FXML
	private TextArea pharmacyArea;
	
	@FXML
	private void saveButtonHandler() {
		
		Alert saveConfirm = new Alert(Alert.AlertType.CONFIRMATION);
		saveConfirm.setTitle("Confirm Account Changes");
		saveConfirm.setHeaderText(null);
		saveConfirm.setContentText("Are you sure you would like to save these changes?");
		Optional<ButtonType> result = saveConfirm.showAndWait();
		
		if(result.isPresent() && result.get() == ButtonType.OK) {
			if (currentPatient != null) {
				currentPatient.setFirstName(firstNameField.getText());
				currentPatient.setLastName(lastNameField.getText());
				currentPatient.setBirthday(birthdayPicker.getValue().toString());
				currentPatient.setPhoneNumber(phoneNumberField.getText());
				currentPatient.setEmailAddress(emailAddressField.getText());
				currentPatient.setInsurance(insuranceArea.getText());
				currentPatient.setPharmacy(pharmacyArea.getText());
				
				mainClinic.writePatientAccount(currentPatient);
			}
		}	
	}
	
	@FXML
	public void showInfo() {
		if (currentPatient != null) {
			firstNameField.setText(currentPatient.getFirstName());
			lastNameField.setText(currentPatient.getLastName());
			birthdayPicker.setValue(LocalDate.parse(currentPatient.getBirthday()));
			phoneNumberField.setText(currentPatient.getPhoneNumber());
			emailAddressField.setText(currentPatient.getEmailAddress());
			insuranceArea.setText(currentPatient.getInsurance());
			pharmacyArea.setText(currentPatient.getPharmacy());
		}
	}

	public void setClinic(Clinic newClinic) {
		this.mainClinic = newClinic;
	}
	
	public void setCurrentPatient(PatientAccount currentPatient) {
		this.currentPatient = currentPatient;
	}
}
