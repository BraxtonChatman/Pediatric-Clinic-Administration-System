package application;

/**
 * ProviderAccount represents a given healthcare provider. Objects of this
 * type contain value of the given provider ID, boolean value determining 
 * if they are a doctor (with permission to write prescriptions)
 */
public class ProviderAccount {

	private String providerId;
	private String firstName;
	private String lastName;
	private boolean doctorStatus;
	
	public ProviderAccount() {
		this.providerId = "";
		this.doctorStatus = false;
	}
	
	public ProviderAccount(String newProviderId, boolean newDoctorStatus) {
		this.providerId = newProviderId;
		this.doctorStatus = newDoctorStatus;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
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

	public boolean isDoctor() {
		return doctorStatus;
	}

	public void setDoctorStatus(boolean doctorStatus) {
		this.doctorStatus = doctorStatus;
	}
	
}
