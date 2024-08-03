package application.controllers;

import java.time.LocalDate;
import application.PatientAccount;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientAccountController {

	private PatientAccount currentPatient;
	
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
	public void showInfo() {
		firstNameField.setText(currentPatient.getFirstName());
		lastNameField.setText(currentPatient.getLastName());
		birthdayPicker.setValue(LocalDate.parse(currentPatient.getBirthday()));
		phoneNumberField.setText(currentPatient.getPhoneNumber());
		emailAddressField.setText(currentPatient.getEmailAddress());
		insuranceArea.setText(currentPatient.getInsurance());
		pharmacyArea.setText(currentPatient.getPharmacy());
	}
	
	public void setCurrentPatient(PatientAccount currentPatient) {
		this.currentPatient = currentPatient;
	}
}
