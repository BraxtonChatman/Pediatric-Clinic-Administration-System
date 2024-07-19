package application;

/**
 * PatientAccount represents patients of the clinic. Objects of this
 * type store the patient id, personal information (such as name, & DOB),
 * and prescriptions
 */
public class PatientAccount {

	private String patientId;
	private String firstName;
	private String lastName;
	private String birthday;
	private String phoneNumber;
	private String emailAddress;
	private String insurance;
	private String pharmacy;
	private String patientHistory;
	private String prescriptions;
	
	public PatientAccount() {
		this.patientId = "";
		this.firstName = "";
		this.lastName = "";
		this.birthday = "";
		this.phoneNumber = "";
		this.emailAddress = "";
		this.insurance = "";
		this.pharmacy = "";
		this.patientHistory = "";
		this.prescriptions = "";
	}
	
	public PatientAccount(String newPatientId) {
		this();
		this.patientId = newPatientId;
	}
	
	public boolean equals(PatientAccount comparison) {
		boolean isEqual = true;
		
		if(!this.patientId.equals(comparison.getPatientId()))
			isEqual = false;
		if(!this.firstName.equals(comparison.getFirstName())) 
			isEqual = false;
		if(!this.lastName.equals(comparison.getLastName()))
			isEqual = false;
		if(!this.birthday.equals(comparison.getBirthday()))
			isEqual = false;
		if(!this.phoneNumber.equals(comparison.getPhoneNumber()))
			isEqual = false;
		if(!this.emailAddress.equals(comparison.getEmailAddress()))
			isEqual = false;
		if(!this.insurance.equals(comparison.getInsurance()))
			isEqual = false;
		if(!this.pharmacy.equals(comparison.getPharmacy()))
			isEqual = false;
		if(!this.patientHistory.equals(comparison.getPatientHistory()))
			isEqual = false;
		if(!this.prescriptions.equals(comparison.getPrescriptions()))
			isEqual = false;
		
		return isEqual;
	}

	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public String getPatientHistory() {
		return patientHistory;
	}
	public void setPatientHistory(String patientHistory) {
		this.patientHistory = patientHistory;
	}

	public String getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}
		
}
