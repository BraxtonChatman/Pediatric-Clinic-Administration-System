package application;

/**
 * The ClinicMessage class represents a message between a healthcare provider
 * and a patient. Objects of this type have String and boolean data members 
 * to represent the message content and the urgency of the message.
 */
public class ClinicMessage {
	
	private int messageId;
	private String patientId;
	private String providerId;
	private boolean urgency;
	private String clinicMessage;
	
	
	public ClinicMessage() {
		this.messageId = 0;
		this.patientId = "";
		this.providerId = "";
		this.urgency = false;
		this.clinicMessage = "";
	}
	
	public ClinicMessage(String newMessage) {
		this.clinicMessage = newMessage;
		this.urgency = false;
	}
	
	public ClinicMessage(String newPatientId, String newProviderId, String newMessage) {
		this(newMessage);
		this.patientId = newPatientId;
		this.providerId = newProviderId;
	}
	
	public ClinicMessage(String newMessage, boolean newUrgency) {
		this.clinicMessage = newMessage;
		this.urgency = newUrgency;
	}
	
	public ClinicMessage(int messageId, String patientId, String providerId, boolean newUrgency, String newMessage) {
		this.messageId = messageId;
		this.patientId = patientId;
		this.providerId = providerId;
		this.urgency = newUrgency;
		this.clinicMessage = newMessage;
	}
	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getClinicMessage() {
		return clinicMessage;
	}

	public void setClinicMessage(String clinicMessage) {
		this.clinicMessage = clinicMessage;
	}

	public boolean isUrgent() {
		return urgency;
	}

	public void setUrgency(boolean newUrgency) {
		this.urgency = newUrgency;
	}
}
