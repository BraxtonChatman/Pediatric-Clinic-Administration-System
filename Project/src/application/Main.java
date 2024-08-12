package application;
	
import application.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Name: Braxton Chatman
 * 
 * Description: Application for a Pediatric doctor's office automation system.
 * System operations: Login (both patient & provider), appointments, messaging, visit information, etc.
 */
public class Main extends Application {
	
	// Clinic is main object used throughout program
	private Clinic mainClinic = new Clinic();
	
	/**
	 * start method loads the initial login view and passes mainClinic to its controller
	 */
	@Override
	public void start(Stage primaryStage) {
		try {		
			
			//this.writeTestData();
			
			// load loginView.fxml for initial scene
			FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/loginView.fxml"));
			Scene scene = new Scene(loader.load());
			
			// pass mainClinic to LoginController
			LoginController controller = loader.getController();
			controller.setClinic(mainClinic);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health Clinic Administration System");
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * writeTestData creates sample data to store in the Clinic, and writes it to the file system
	 */
	public void writeTestData() {
		
		// create data for a patient account 1
		PatientAccount pat1 = new PatientAccount();
		pat1.setPatientId("patient1");
		pat1.setFirstName("John");
		pat1.setLastName("Doe");
		pat1.setBirthday("1984-12-08");
		pat1.setPhoneNumber("5555555");
		pat1.setEmailAddress("jdoe1@gmail.com");
		pat1.setInsurance("Kaiser Permanente, 95064, 22098");
		pat1.setPharmacy("901 Main Street, New York, NY 98051");
		pat1.setPatientHistory("Seasonal Allergies");
		pat1.setPrescriptions("No Prescriptions");
		
		// create login data for patient 1
		Login logPat1 = new Login("patient1", "password");
		
		// create data for a patient account 2
		PatientAccount pat2 = new PatientAccount();
		pat2.setPatientId("patient2");
		pat2.setFirstName("Jane");
		pat2.setLastName("Smith");
		pat2.setBirthday("2014-09-12");
		pat2.setPhoneNumber("8675309");
		pat2.setEmailAddress("jSmith20@gmail.com");
		pat2.setInsurance("Blue Cross, 44309, 9888973");
		pat2.setPharmacy("903 Main Street, New York, NY 98051");
		pat2.setPatientHistory("GERD, Allergic to Pennicilin");
		pat2.setPrescriptions("Aspirin, 5mg, daily");
		
		// create login data for patient 2
		Login logPat2 = new Login("patient2", "123456");
		
		
		// create data for doctor 1
		ProviderAccount doc1 = new ProviderAccount();
		doc1.setProviderId("doctor1");
		doc1.setFirstName("Preston");
		doc1.setLastName("Burke");
		doc1.setDoctorStatus(true);
		
		// create login data for doctor 1
		Login logDoc1 = new Login("doctor1", "PresPass1");
		
		// create data for doctor 2
		ProviderAccount doc2 = new ProviderAccount();
		doc2.setProviderId("doctor2");
		doc2.setFirstName("Derek");
		doc2.setLastName("Shepherd");
		doc2.setDoctorStatus(true);
		
		// create login data for doctor 2
		Login logDoc2 = new Login("doctor2", "ShepPass1");
		
		
		// create data for nurse 1
		ProviderAccount nur1 = new ProviderAccount();
		nur1.setProviderId("nurse1");
		nur1.setFirstName("Nancy");
		nur1.setLastName("Joy");
		nur1.setDoctorStatus(false);
		
		// create login data for nurse 1
		Login logNur1 = new Login("nurse1", "PokePass1");
		
		// create data for nurse 2
		ProviderAccount nur2 = new ProviderAccount();
		nur2.setProviderId("nurse2");
		nur2.setFirstName("Jeremy");
		nur2.setLastName("Adams");
		nur2.setDoctorStatus(false);
		
		// create login data for nurse 1
		Login logNur2 = new Login("nurse2", "ExtraHelp26");
		
		
		// create visits for patient1
		ClinicVisit pat1Vis1 = new ClinicVisit();
		pat1Vis1.setPatientId("patient1");
		pat1Vis1.setProviderId("doctor1");
		pat1Vis1.setVisitId(1);
		pat1Vis1.setVisitDate("2023-08-01");
		pat1Vis1.setVisitTime("12:00 PM");
		pat1Vis1.setReason("New Patient Visit");
		pat1Vis1.setHeight(120.2);
		pat1Vis1.setWeight(100.9);
		pat1Vis1.setTemperature(98.9);
		pat1Vis1.setBloodPressure("120/78");
		pat1Vis1.setAtLeastTwelve(true);
		pat1Vis1.setAllergies("Seasonal Allergies");
		pat1Vis1.setConcerns("None");
		pat1Vis1.setExamSummary("Patient is healthy");
		pat1Vis1.setPrescriptions("No Prescriptions");
		
		ClinicVisit pat1Vis2 = new ClinicVisit();
		pat1Vis2.setPatientId("patient1");
		pat1Vis2.setProviderId("doctor2");
		pat1Vis2.setVisitId(3);
		pat1Vis2.setVisitDate("2025-07-20");
		pat1Vis2.setVisitTime("12:30 PM");
		pat1Vis2.setReason("Regular Physical");
		pat1Vis2.setHeight(120.2);
		pat1Vis2.setWeight(140.9);
		pat1Vis2.setTemperature(99.2);
		pat1Vis2.setBloodPressure("140/70");
		pat1Vis2.setAtLeastTwelve(true);
		pat1Vis2.setAllergies("Seasonal Allergies");
		pat1Vis2.setConcerns("Weight Gain");
		pat1Vis2.setExamSummary("Patient had concerns about recent weight gain, but no problems were found");
		pat1Vis2.setPrescriptions("No Prescriptions");
		
		ClinicVisit pat1Vis3 = new ClinicVisit();
		pat1Vis3.setPatientId("patient1");
		pat1Vis3.setProviderId("doctor2");
		pat1Vis3.setVisitId(5);
		pat1Vis3.setVisitDate("2024-07-20");
		pat1Vis3.setVisitTime("12:30 PM");
		pat1Vis3.setReason("Regular Physical");
		pat1Vis3.setHeight(120.2);
		pat1Vis3.setWeight(140.9);
		pat1Vis3.setTemperature(99.2);
		pat1Vis3.setBloodPressure("140/70");
		pat1Vis3.setAtLeastTwelve(true);
		pat1Vis3.setAllergies("Seasonal Allergies");
		pat1Vis3.setConcerns("Weight Gain");
		pat1Vis3.setExamSummary("Patient had concerns about recent weight gain, but no problems were found");
		pat1Vis3.setPrescriptions("No Prescriptions");
		
		ClinicVisit pat1Vis4 = new ClinicVisit();
		pat1Vis4.setPatientId("patient1");
		pat1Vis4.setProviderId("doctor2");
		pat1Vis4.setVisitId(6);
		pat1Vis4.setVisitDate("2024-07-20");
		pat1Vis4.setVisitTime("12:30 PM");
		pat1Vis4.setReason("Regular Physical");
		pat1Vis4.setHeight(120.2);
		pat1Vis4.setWeight(140.9);
		pat1Vis4.setTemperature(99.2);
		pat1Vis4.setBloodPressure("140/70");
		pat1Vis4.setAtLeastTwelve(true);
		pat1Vis4.setAllergies("Seasonal Allergies");
		pat1Vis4.setConcerns("Weight Gain");
		pat1Vis4.setExamSummary("Patient had concerns about recent weight gain, but no problems were found");
		pat1Vis4.setPrescriptions("No Prescriptions");
		
		// create visits for patient 2
		ClinicVisit pat2Vis1 = new ClinicVisit();
		pat2Vis1.setPatientId("patient2");
		pat2Vis1.setProviderId("doctor2");
		pat2Vis1.setVisitId(2);
		pat2Vis1.setVisitDate("2024-07-20");
		pat2Vis1.setVisitTime("09:30 PM");
		pat2Vis1.setReason("Regular Physical");
		pat2Vis1.setHeight(100.2);
		pat2Vis1.setWeight(80.9);
		pat2Vis1.setTemperature(98.2);
		pat2Vis1.setBloodPressure("100/58");
		pat2Vis1.setAtLeastTwelve(false);
		pat2Vis1.setAllergies("Penicillin");
		pat2Vis1.setConcerns("Chest pain");
		pat2Vis1.setExamSummary("Patient had concerns about chest pain. No problems found.");
		pat2Vis1.setPrescriptions("Aspirin, 5mg, daily");
		
		ClinicVisit pat2Vis2 = new ClinicVisit();
		pat2Vis2.setPatientId("patient2");
		pat2Vis2.setProviderId("doctor2");
		pat2Vis2.setVisitId(4);
		pat2Vis2.setVisitDate("2024-07-24");
		pat2Vis2.setVisitTime("10:15 PM");
		pat2Vis2.setReason("Severe chest pain");
		pat2Vis2.setHeight(101.2);
		pat2Vis2.setWeight(81.9);
		pat2Vis2.setTemperature(100.1);
		pat2Vis2.setBloodPressure("100/58");
		pat2Vis2.setAtLeastTwelve(false);
		pat2Vis2.setAllergies("Penicillin");
		pat2Vis2.setConcerns("Chest pain");
		pat2Vis2.setExamSummary("Patient came in for worsened chest pain. Scheduled for tests.");
		pat2Vis2.setPrescriptions("Aspirin, 15mg, daily");
		
		
		// add data to mainClinic
		mainClinic.addPatient(pat1);
		mainClinic.addPatient(pat2);
		mainClinic.addProvider(doc1);
		mainClinic.addProvider(doc2);
		mainClinic.addProvider(nur1);
		mainClinic.addProvider(nur2);
		mainClinic.addLogin(logPat1);
		mainClinic.addLogin(logPat2);
		mainClinic.addLogin(logDoc1);
		mainClinic.addLogin(logDoc2);
		mainClinic.addLogin(logNur1);
		mainClinic.addLogin(logNur2);
		mainClinic.addVisit(pat1Vis1);
		mainClinic.addVisit(pat1Vis2);
		mainClinic.addVisit(pat2Vis1);
		mainClinic.addVisit(pat2Vis2);
		
		// write data to file system
		mainClinic.writePatientAccount(pat1);
		mainClinic.writePatientAccount(pat2);
		mainClinic.writeProviderAccount(doc1);
		mainClinic.writeProviderAccount(doc2);
		mainClinic.writeProviderAccount(nur1);
		mainClinic.writeProviderAccount(nur2);
		mainClinic.writeLogin(logPat1);
		mainClinic.writeLogin(logPat2);
		mainClinic.writeLogin(logDoc1);
		mainClinic.writeLogin(logDoc2);
		mainClinic.writeLogin(logNur1);
		mainClinic.writeLogin(logNur2);
		mainClinic.writeVisit(pat1Vis1);
		mainClinic.writeVisit(pat1Vis2);
		mainClinic.writeVisit(pat1Vis3);
		mainClinic.writeVisit(pat1Vis4);
		mainClinic.writeVisit(pat2Vis1);
		mainClinic.writeVisit(pat2Vis2);
		
		
	}
}
