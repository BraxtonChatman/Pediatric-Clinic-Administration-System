package application;

/**
 * ClinicVisit represents a single visit by a patient to the clinic. Objects
 * of this type have data members to store the date, time, id of attending doctor,
 * patient id, and data collected at the exam.
 */
public class ClinicVisit {
	
	private String patientId;
	private String providerId;
	private int visitId;
	private String visitDate;
	private String visitTime;
	private String reason;
	private float height;
	private float weight;
	private float temperature;
	private String bloodPressure;
	private boolean atLeastTwelve;
	private String allergies;
	private String concerns;
	private String prescriptions;
	private String examSummary;
	
	public ClinicVisit() {
		this.patientId = "";
		this.providerId = "";
		this.visitId = 0;
		this.visitDate = "";
		this.visitTime = "";
		this.reason = "";
		this.height = 0;
		this.weight = 0;
		this.temperature = 0;
		this.bloodPressure = "";
		this.atLeastTwelve = false;
		this.allergies = "";
		this.concerns = "";
		this.examSummary = "";
		this.prescriptions = ""; 
	}
	
	public ClinicVisit(String newPatientId) {
		this();
		this.patientId = newPatientId;
	}
	
	public ClinicVisit(String newPatientId, String newProviderId) {
		this(newPatientId);
		this.providerId = newProviderId;
	}
	
	public boolean equals(ClinicVisit checkAgainst) {
		if(!this.getPatientId().equals(checkAgainst.getPatientId()))
			return false;
		if(!this.getProviderId().equals(checkAgainst.getProviderId()))
			return false;
		if(this.getVisitId() != checkAgainst.getVisitId())
			return false;
		if(!this.getVisitDate().equals(checkAgainst.getVisitDate()))
			return false;
		if(!this.getVisitTime().equals(checkAgainst.getVisitTime()))
			return false;
		if(!this.getReason().equals(checkAgainst.getReason()))
			return false;
		if(this.getHeight()!=checkAgainst.getHeight())
			return false;
		if(this.getWeight()!=checkAgainst.getWeight())
			return false;
		if(this.getTemperature()!=checkAgainst.getTemperature())
			return false;
		if(!this.getBloodPressure().equals(checkAgainst.getBloodPressure()))
			return false;
		if(this.isAtLeastTwelve()!=checkAgainst.isAtLeastTwelve())
			return false;
		if(!this.getAllergies().equals(checkAgainst.getAllergies()))
			return false;
		if(!this.getConcerns().equals(checkAgainst.getConcerns()))
			return false;
		if(!this.getExamSummary().equals(checkAgainst.getExamSummary()))
			return false;
		if(!this.getPrescriptions().equals(checkAgainst.getPrescriptions()))
			return false;
		
		return true;
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
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	public boolean isAtLeastTwelve() {
		return atLeastTwelve;
	}
	public void setAtLeastTwelve(boolean atLeastTwelve) {
		this.atLeastTwelve = atLeastTwelve;
	}
	
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	public String getConcerns() {
		return concerns;
	}
	public void setConcerns(String concerns) {
		this.concerns = concerns;
	}
	
	public String getExamSummary() {
		return examSummary;
	}
	public void setExamSummary(String examSummary) {
		this.examSummary = examSummary;
	}
	
	public String getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}
	
}
