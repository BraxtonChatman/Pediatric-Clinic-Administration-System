package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * Clinic object stores lists of providers, patients, visits, and messages,
 * as well as an String to store the user id of the current user signed in
 */
public class Clinic {

	private String currentUser;
	private boolean providerStatus;
	private boolean doctorStatus;
	
	private ArrayList<ProviderAccount> providers;
	private ArrayList<PatientAccount> patients;
	private ArrayList<ClinicVisit> visits;
	private ArrayList<ClinicMessage> messages;
	private ArrayList<Login> logins;
	
	/**
	 * The Clinic constructor initializes the currentUser value to 0, which corresponds
	 * to a logged out state, and the lists to empty. Then it checks the file directory
	 * to see if the Clinic_Data directory exists along with its subdirectories for
	 * providers, patients, messages, visits, and logins. If the directories don't exist
	 * the constructor makes them, and if they do, they are searched for files which are
	 * read into the corresponding Clinic data member lists using the Clinic.read<Type> 
	 * methods.
	 */
	public Clinic() {
		// currentUser defaults to 0, corresponding to logged out state
		this.currentUser = "";
		
		// initialize Clinic lists to empty
		this.providers = new ArrayList<>();
		this.patients = new ArrayList<>();
		this.visits = new ArrayList<>();
		this.messages = new ArrayList<>();
		this.logins = new ArrayList<>();
		
		// initialize paths to Clinic_Data directory and subdirectories
		Path clinicPath = Paths.get("Clinic_Data");
		Path providerAccountPath = clinicPath.resolve("Provider_Data");
		Path patientAccountPath = clinicPath.resolve("Patient_Data");
		Path messagePath = clinicPath.resolve("Message_Data");
		Path visitPath = clinicPath.resolve("Visit_Data");
		Path loginPath = clinicPath.resolve("Login_Data");
		
		try {
			// create boolean values assessing the existence of the Clinic_Data directory and subdirectories
			boolean clinicExists = Files.exists(clinicPath) && Files.isDirectory(clinicPath);
			boolean providersExists = Files.exists(providerAccountPath) && Files.isDirectory(providerAccountPath);
			boolean patientsExists = Files.exists(patientAccountPath) && Files.isDirectory(patientAccountPath);
			boolean messagesExists = Files.exists(messagePath) && Files.isDirectory(messagePath);
			boolean visitsExists = Files.exists(visitPath) && Files.isDirectory(visitPath);
			boolean loginsExists = Files.exists(loginPath) && Files.isDirectory(loginPath);
			
			// if directories exist, read their data
			if(clinicExists && providersExists && patientsExists && messagesExists && visitsExists && loginsExists) {
				// get list of all provider files and read them to Clinic.providers
				
				List<Path> providerFiles = Files.list(providerAccountPath).filter(Files::isRegularFile).collect(Collectors.toList());				
				for(Path fileToRead : providerFiles) 
					this.readProvider(fileToRead);
								
				// get list of all patient files and read them to Clinic.patients
				List<Path> patientFiles = Files.list(patientAccountPath).filter(Files::isRegularFile).collect(Collectors.toList());
				for(Path fileToRead : patientFiles)
					this.readPatient(fileToRead);
				
				// get list of all message files and read them to Clinic.messages
				List<Path> messageFiles = Files.list(messagePath).filter(Files::isRegularFile).collect(Collectors.toList());
				for(Path fileToRead : messageFiles)
					this.readMessage(fileToRead);
				
				// get list of all visit files and read them to Clinic.visits
				List<Path> visitFiles = Files.list(visitPath).filter(Files::isRegularFile).collect(Collectors.toList());
				for(Path fileToRead : visitFiles)
					this.readVisit(fileToRead);
				
				// get list of all login files and read them to Clinic.logins
				List<Path> loginFiles = Files.list(loginPath).filter(Files::isRegularFile).collect(Collectors.toList());
				for(Path fileToRead : loginFiles)
					this.readLogin(fileToRead);
			}
			
			// if not, create directories
			else {
				Files.createDirectories(clinicPath);
				Files.createDirectories(providerAccountPath);
				Files.createDirectories(patientAccountPath);
				Files.createDirectories(messagePath);
				Files.createDirectories(visitPath);
				Files.createDirectories(loginPath);
				System.out.println("Directories created successfully at " + clinicPath.toAbsolutePath());
			}
		}
		catch (IOException e) {
			System.err.println("Failed to create directories: " + e.getMessage());
		}	
	}

	
	// Functions for reading ProviderAccount, PatientAccount, ClinicVisit, ClinicMessage, and Login objects from files
	/**
	 * readProvider takes a file path for a ProviderAccount data, reads the data,
	 * stores it in a ProviderAccount object, and adds the object to Clinic.providers
	 * 
	 * @param fileToRead
	 */
	public void readProvider(Path fileToRead) {
		try {
			// read indicated file to string
			String fileData = Files.readString(fileToRead, StandardCharsets.UTF_8);

			// parse and store string into ProviderAccount
			String[] dataValues = fileData.split("\\n");
			String providerId = dataValues[0];
			String firstName = dataValues[1];			
			String lastName = dataValues[2];
			boolean doctorStatus = Boolean.parseBoolean(dataValues[3]);
						
			ProviderAccount newProvider = new ProviderAccount();
			newProvider.setProviderId(providerId);
			newProvider.setFirstName(firstName);
			newProvider.setLastName(lastName);
			newProvider.setDoctorStatus(doctorStatus);
			
			// add ProviderAccount to Clinic.providers
			this.providers.add(newProvider);			
		}
		catch(IOException e) {
			System.err.println("Failed to read Provider file: " + e.getMessage());
		}
	}
	
	/**
	 * readPatient takes a file path for a PatientAccount data, reads the data,
	 * stores it in a PatientAccount object, and adds the object to Clinic.patients
	 * 
	 * @param fileToRead
	 */
	public void readPatient(Path fileToRead) {
		try {
			// read indicated file to string
			String fileData = Files.readString(fileToRead, StandardCharsets.UTF_8);
			
			// parse and store string into PatientAccount
			String[] dataValues = fileData.split("\\n");
			String patientId = dataValues[0];
			String firstName = dataValues[1];
			String lastName = dataValues[2];
			String birthday = dataValues[3];
			String phoneNumber = dataValues[4];
			String emailAddress = dataValues[5];
			String insurance = dataValues[6];
			String pharmacy = dataValues[7];
			String patientHistory = dataValues[8];
			String prescriptions = dataValues[9];
			
			// TODO: this parsing method does not allow for multiline data member strings
			
			// create patient account object, and its set data values
			PatientAccount newPatient = new PatientAccount();
			newPatient.setPatientId(patientId);
			newPatient.setFirstName(firstName);
			newPatient.setLastName(lastName);
			newPatient.setBirthday(birthday);
			newPatient.setPhoneNumber(phoneNumber);
			newPatient.setEmailAddress(emailAddress);
			newPatient.setInsurance(insurance);
			newPatient.setPharmacy(pharmacy);
			newPatient.setPatientHistory(patientHistory);
			newPatient.setPrescriptions(prescriptions);
			
			// add ProviderAccount to Clinic.patients
			this.patients.add(newPatient);			
		}
		catch(IOException e) {
			System.err.println("Failed to read Patient file: " + e.getMessage());
		}
	}
		
	/**
	 * readMessage takes a file path for a ClinicMessage data, reads the data,
	 * stores it in a ClinicMessage object, and adds the object to Clinic.messages
	 * 
	 * @param fileToRead
	 */
	public void readMessage(Path fileToRead) {
		try {
			// read indicated file to string
			String fileData = Files.readString(fileToRead, StandardCharsets.UTF_8);
			
			// parse and store string into PatientAccount
			String[] dataValues = fileData.split("\\n");
			int messageId = Integer.parseInt(dataValues[0]);
			String patientId = dataValues[1];
			String providerId = dataValues[2];
			boolean urgent = Boolean.parseBoolean(dataValues[3]);

			// concatenate strings if message includes newlines
			StringBuilder concatenatedString = new StringBuilder();
			for(int i=4; i<dataValues.length; i++) {
				concatenatedString.append(dataValues[i]);
			}
			String message = concatenatedString.toString();
			
			// create new ClinicMessage object and add it to Clinic.messages
			ClinicMessage newMessage = new ClinicMessage(messageId, patientId, providerId, urgent, message);			
			this.messages.add(newMessage);			
		}
		catch(IOException e) {
			System.err.println("Failed to read Message file: " + e.getMessage());
		}
	}
	
	/**
	 * readVisit takes a file path for a ClinicVisit data, reads the data,
	 * stores it in a ClinicMVisit object, and adds the object to Clinic.visits
	 * 
	 * @param fileToRead
	 */
	public void readVisit(Path fileToRead) {
		try {
			// read indicated file to string
			String fileData = Files.readString(fileToRead, StandardCharsets.UTF_8);
			
			// parse and store string into PatientAccount
			String[] dataValues = fileData.split("\\n");
			
			String patientId = dataValues[0];
			String providerId = dataValues[1];
			int visitId = Integer.parseInt(dataValues[2]);
			String visitDate = dataValues[3];
			String visitTime = dataValues[4];
			String reason = dataValues[5];
			float height = Float.parseFloat(dataValues[6]);
			float weight = Float.parseFloat(dataValues[7]);
			float temperature = Float.parseFloat(dataValues[8]);
			String bloodPressure = dataValues[9];
			boolean atLeastTwelve = Boolean.parseBoolean(dataValues[10]);
			String allergies = dataValues[11];
			String concerns = dataValues[12];
			String prescriptions = dataValues[13];
			
			// concatenate strings if examSummary includes newlines
			StringBuilder concatenatedString = new StringBuilder();
			for(int i=14; i<dataValues.length; i++) {
				concatenatedString.append(dataValues[i]);
			}
			String examSummary = concatenatedString.toString();
			
			// this parsing method does not allow for multiline data member strings besides examSummary
			
			// create patient account object, and its set data values
			ClinicVisit newVisit = new ClinicVisit();
			newVisit.setPatientId(patientId);
			newVisit.setProviderId(providerId);
			newVisit.setVisitId(visitId);
			newVisit.setVisitDate(visitDate);
			newVisit.setVisitTime(visitTime);
			newVisit.setReason(reason);
			newVisit.setHeight(height);
			newVisit.setWeight(weight);
			newVisit.setTemperature(temperature);
			newVisit.setBloodPressure(bloodPressure);
			newVisit.setAtLeastTwelve(atLeastTwelve);
			newVisit.setAllergies(allergies);
			newVisit.setConcerns(concerns);
			newVisit.setPrescriptions(prescriptions);
			newVisit.setExamSummary(examSummary);
			
			// add ProviderAccount to Clinic.patients
			this.visits.add(newVisit);			
		}
		catch(IOException e) {
			System.err.println("Failed to read Visit file: " + e.getMessage());
		}
	}
	
	/**
	 * readLogin takes a file path for a Login data, reads the data,
	 * stores it in a Login object, and adds the object to Clinic.logins
	 * 
	 * @param fileToRead
	 */
	public void readLogin(Path fileToRead) {
		try {
			// read indicated file to string
			String fileData = Files.readString(fileToRead, StandardCharsets.UTF_8);
			
			// parse and store string into ProviderAccount
			String[] dataValues = fileData.split("\\n");
			String userId = dataValues[0];
			String password = dataValues[1];
			Login newLogin = new Login(userId, password);
			
			// add ProviderAccount to Clinic.providers
			this.logins.add(newLogin);			
		}
		catch(IOException e) {
			System.err.println("Failed to read Login file: " + e.getMessage());
		}
	}

	
	
	
	// Functions for writing ProviderAccount, PatientAccount, ClinicVisit, ClinicMessage, and Login objects to files
	/**
	 * writeProviderAccount takes a given ProviderAccount object and writes its
	 * data to a file in the Provider_Data subdirectory of Clinic_Data
	 * with its data parsed by line
	 * 
	 */
	public void writeProviderAccount(ProviderAccount accountToWrite) {
		
		// Convert ProviderAccount data to string
		StringBuilder concatenateStrings = new StringBuilder();
		concatenateStrings.append(accountToWrite.getProviderId() + "\n");
		concatenateStrings.append(accountToWrite.getFirstName() + "\n");
		concatenateStrings.append(accountToWrite.getLastName() + "\n");
		concatenateStrings.append(accountToWrite.isDoctor());
		String dataToWrite = concatenateStrings.toString();
		 
		// write data to file in Provider_Data with file name format: <providerId>_ProviderAccount.txt
		Path clinicPath = Paths.get("Clinic_Data");
		Path providerAccountPath = clinicPath.resolve("Provider_Data");
		Path filePath = providerAccountPath.resolve(String.valueOf(accountToWrite.getProviderId()) + "_ProviderAccount.txt");
		try {
			Files.write(filePath, dataToWrite.getBytes(StandardCharsets.UTF_8));
		}
		catch(IOException e) {
			System.err.println("Failed to write ProviderAccount to file: " + e.getMessage());
		}
	}
	
	/**
	 * writePatientAccount takes a given PatientAccount object and writes its
	 * data to a file in the Patient_Data subdirectory of Clinic_Data
	 * with its data parsed by line
	 * 
	 */
	public void writePatientAccount(PatientAccount accountToWrite) {
		// Convert PatientAccount data to string
		StringBuilder concatenateStrings = new StringBuilder();
		
		concatenateStrings.append(accountToWrite.getPatientId() + "\n");
		concatenateStrings.append(accountToWrite.getFirstName() + "\n");
		concatenateStrings.append(accountToWrite.getLastName() + "\n");
		concatenateStrings.append(accountToWrite.getBirthday() + "\n");
		concatenateStrings.append(accountToWrite.getPhoneNumber() + "\n");
		concatenateStrings.append(accountToWrite.getEmailAddress() + "\n");
		concatenateStrings.append(accountToWrite.getInsurance() + "\n");
		concatenateStrings.append(accountToWrite.getPharmacy() + "\n");
		concatenateStrings.append(accountToWrite.getPatientHistory() + "\n");
		concatenateStrings.append(accountToWrite.getPrescriptions());
		
		String dataToWrite = concatenateStrings.toString();
		 
		// write data to file in Patient_Data with file name format: <patientId>_PatientAccount.txt
		Path clinicPath = Paths.get("Clinic_Data");
		Path patientPath = clinicPath.resolve("Patient_Data");
		Path filePath = patientPath.resolve(String.valueOf(accountToWrite.getPatientId()) + "_PatientAccount.txt");
		try {
			Files.write(filePath, dataToWrite.getBytes(StandardCharsets.UTF_8));
		}
		catch(IOException e) {
			System.err.println("Failed to write PatientAccount to file: " + e.getMessage());
		}
	}
	
	/**
	 * writeMessage takes a given ClinicMessage object and writes its
	 * data to a file in the Message_Data subdirectory of Clinic_Data
	 * with its data parsed by line
	 * 
	 */
	public void writeMessage(ClinicMessage messageToWrite) {
		
		// Convert ClinicMessage data to string
		String messageId = String.valueOf(messageToWrite.getMessageId());
		
		StringBuilder concatenateStrings = new StringBuilder();
		concatenateStrings.append(messageId + "\n");
		concatenateStrings.append(messageToWrite.getPatientId() + "\n");
		concatenateStrings.append(messageToWrite.getProviderId() + "\n");
		concatenateStrings.append(messageToWrite.isUrgent() + "\n");
		concatenateStrings.append(messageToWrite.getClinicMessage());
		String dataToWrite = concatenateStrings.toString();
		 
		// write data to file in Message_Data with file name format: <messageId>_Message.txt
		Path clinicPath = Paths.get("Clinic_Data");
		Path messagePath = clinicPath.resolve("Message_Data");
		Path filePath = messagePath.resolve(messageId + "_Message.txt");
		try {
			Files.write(filePath, dataToWrite.getBytes(StandardCharsets.UTF_8));
		}
		catch(IOException e) {
			System.err.println("Failed to write ClinicMessage to file: " + e.getMessage());
		}
	}
	
	/**
	 * writeVisit takes a given ClinicVisit object and writes its
	 * data to a file in the Visit_Data subdirectory of Clinic_Data
	 * with its data parsed by line
	 * 
	 */
	public void writeVisit(ClinicVisit visitToWrite) {
		// Convert PatientAccount data to string
		StringBuilder concatenateStrings = new StringBuilder();
		
		concatenateStrings.append(visitToWrite.getPatientId() + "\n");
		concatenateStrings.append(visitToWrite.getProviderId() + "\n");
		concatenateStrings.append(visitToWrite.getVisitId() + "\n");
		concatenateStrings.append(visitToWrite.getVisitDate() + "\n");
		concatenateStrings.append(visitToWrite.getVisitTime() + "\n");
		concatenateStrings.append(visitToWrite.getReason() + "\n");
		concatenateStrings.append(visitToWrite.getHeight() + "\n");
		concatenateStrings.append(visitToWrite.getWeight() + "\n");
		concatenateStrings.append(visitToWrite.getTemperature() + "\n");
		concatenateStrings.append(visitToWrite.getBloodPressure() + "\n");
		concatenateStrings.append(visitToWrite.isAtLeastTwelve() + "\n");
		concatenateStrings.append(visitToWrite.getAllergies() + "\n");
		concatenateStrings.append(visitToWrite.getConcerns() + "\n");
		concatenateStrings.append(visitToWrite.getPrescriptions() + "\n");
		concatenateStrings.append(visitToWrite.getExamSummary());
		
		String dataToWrite = concatenateStrings.toString();
		 
		// write data to file in Visit_Data with file name format: <visitId>_Visit.txt
		Path clinicPath = Paths.get("Clinic_Data");
		Path visitPath = clinicPath.resolve("Visit_Data");
		Path filePath = visitPath.resolve(String.valueOf(visitToWrite.getVisitId()) + "_Visit.txt");
		try {
			Files.write(filePath, dataToWrite.getBytes(StandardCharsets.UTF_8));
		}
		catch(IOException e) {
			System.err.println("Failed to write ClinicVisit to file: " + e.getMessage());
		}
	}
	
	/**
	 * writeLogin takes a given Login object and writes its
	 * data to a file in the Login_Data subdirectory of Clinic_Data
	 * with its data parsed by line
	 * 
	 */
	public void writeLogin(Login loginToWrite) {
		// Convert ClinicMessage data to string
		String userId = String.valueOf(loginToWrite.getUserId());
		
		StringBuilder concatenateStrings = new StringBuilder();
		concatenateStrings.append(loginToWrite.getUserId() + "\n");
		concatenateStrings.append(loginToWrite.getPassword());
		String dataToWrite = concatenateStrings.toString();
		 
		// write data to file in Message_Data with file name format: <userId>_Login.txt
		Path clinicPath = Paths.get("Clinic_Data");
		Path loginPath = clinicPath.resolve("Login_Data");
		Path filePath = loginPath.resolve(userId + "_Login.txt");
		try {
			Files.write(filePath, dataToWrite.getBytes(StandardCharsets.UTF_8));
		}
		catch(IOException e) {
			System.err.println("Failed to write Login to file: " + e.getMessage());
		}
	}
	
	
	
	
	// User validation methods for log in, log out
	/**
	 * isUniqueUsername takes a String representing  username, iterates through the
	 * patient and provider lists to see if that username is already in use. If it is
	 * in use, return false. Otherwise, checkName is unique
	 * 
	 * @param: chceckName
	 */
	public boolean isUniqueUsername(String checkName) {
		boolean isUnique = true;
		
		for(PatientAccount checkAccount : this.patients) {
			if(checkAccount.getPatientId().equals(checkName))
				isUnique = false;
		}
		
		for(ProviderAccount checkAccount : this.providers) {
			if(checkAccount.getProviderId().equals(checkName))
				isUnique = false;
		}
		
		return isUnique;
	}
	
	/**
	 * isUniqueUser checks a given first name, last name, and birthday against
	 * those already on file. If an existing user is found with the dame data, returns 
	 * false for a not unique user. If supplied data does not match an existing patient,
	 * returns true.
	 */
	public boolean isUniqueUser(String firstName, String lastName, String birthday) {
		boolean firstNameMatch = false;
		boolean lastNameMatch = false;
		boolean birthdayMatch = false;
		
		for(PatientAccount checkAccount : this.patients) {
			firstNameMatch = checkAccount.getFirstName().equalsIgnoreCase(firstName);
			lastNameMatch = checkAccount.getLastName().equalsIgnoreCase(lastName);
			birthdayMatch = checkAccount.getBirthday().equals(birthday);
			
			if(firstNameMatch && lastNameMatch && birthdayMatch)
				return false;
		}
		
		return true;
	}
	
	/**
	 * login takes two inputs for a user account and checks them against those on file
	 * 
	 * upon login info match, Clinic.currentUser will be set to the one input, and
	 * if login corresponds to a ProviderAccount or a doctor, then Clinic.providerStatus
	 * and Clinic.doctorStatus will be set to true, respectively.
	 * 
	 * @param: userId represents the id of the account the user is trying to sign into
	 * @param: password represents the password of the account the user is trying to sign into
	 */
	public boolean login(String userId, String password) {
		
		boolean successful = false;
		
		// iterate through list of valid logins
		for(Login check : logins) {
			if(check.authenticate(userId, password)) {
				successful = true;
				this.currentUser = userId;
				
				// check if login data corresponds to a provider and doctor
				for(ProviderAccount checkProvider : this.providers) {
					if(checkProvider.getProviderId().equals(this.currentUser)) {
						this.providerStatus = true;
						if(checkProvider.isDoctor()) {
							this.doctorStatus = true;
						}
					}
				}
			}
		}
		return successful;
	}
	
	/**
	 * logout resets Clinic.currentUser to 0, corresponding to a signed out
	 * state. Similarly, it sets providerStatus and doctorStatus to false.
	 */
	public void logout() {
		this.currentUser = "";
		this.providerStatus = false;
		this.doctorStatus = false;
	}
	
	
	
	
	// Current user state and provider/doctor status manipulation methods
	public String getCurrentUser() {
		return this.currentUser;
	}
	
	public void setCurrentUser(String user) {
		this.currentUser = user;
	}
		
	public boolean getProviderStatus() {
		return this.providerStatus;
	}
	
	public void setProviderStatus(boolean newStatus) {
		this.providerStatus = newStatus;
	}

	public boolean getDoctorStatus() {
		return this.doctorStatus;
	}
	
	public void setDoctorStatus(boolean doctorStatus) {
		this.doctorStatus = doctorStatus;
	}
	
	
	
	
	
	/**
	 * generateVisitId iterates through Clinic.visits to find the highest 
	 * visitId, and returns its increment as a unique visit id
	 * 
	 * @return
	 */
	public int generateVisitId() {
		int newVisitId = 1000;
		
		for(ClinicVisit visitInList : this.visits) {
			if(visitInList.getVisitId() >= newVisitId)
				newVisitId = visitInList.getVisitId() + 1;
		}
		
		return newVisitId;
	}
	
	/**
	 * generateMessageId iterates through Clinic.messages to find the highest 
	 * messageId, and returns its increment as a unique message id
	 * 
	 * @return
	 */
	public int generateMessageId() {
		int newMessageId = 1000;
		
		for(ClinicMessage messageInList : this.messages) {
			if(messageInList.getMessageId() >= newMessageId)
				newMessageId = messageInList.getMessageId() + 1;
		}
		
		return newMessageId;
	}
	
	/**
	 * sendMessage adds a new message to Clinic.messages with message content
	 * matching message. It sets ClinicMessage.patientId and ClinicMessage.providerId
	 * to either Clinic.currentUser or recipientId depending on whether the user is
	 * a provider
	 * 
	 * @param recipientId
	 * @param message
	 */
	public void sendMessage(String recipientId, String message) {
		// create a new message with cases for whether a user is a patient or a provider
		ClinicMessage newMessage;
		if(this.providerStatus) {
			newMessage = new ClinicMessage(recipientId, this.currentUser, message);
			newMessage.setMessageId(this.generateMessageId());
		}
		else {
			newMessage = new ClinicMessage(this.currentUser, recipientId, message);
			newMessage.setMessageId(this.generateMessageId());
		}
		
		// add new message to list
		this.addMessage(newMessage);
	}
	



	// Methods for fetching lists or objects ProviderAccount, PatientAccount, ClinicVisit, ClinicMessage from Clinic
	/**
	 * viewProviders returns an ArrayList<ProviderAccount> of all the provider
	 * with accounts at the clinic
	 * 
	 * @return
	 */
	public ArrayList<ProviderAccount> viewProviders(){
		return this.providers;
	}

	/**
	 * viewProvider searches Clinic.providers for a ProviderAccount with a
	 * providerId matching the input username and returns it. If a provider with
	 * the input providerId was not found, it returns an empty ProviderAccount object.
	 * 
	 * @param patientId
	 * @return
	 */
	public ProviderAccount viewProvider(String username) {
		for(ProviderAccount checkAccount : this.providers) {
			if(checkAccount.getProviderId().equals(username)) {
				return checkAccount;
			}
		}
		return new ProviderAccount();
	}
	
	/**
	 * viewPatients returns an ArrayList<PatientAccount> of all the patients
	 * with accounts at the clinic
	 * 
	 * @return
	 */
	public ArrayList<PatientAccount> viewPatients(){
		return this.patients;
	}
	
	/**
	 * viewPatient searches Clinic.patients for a PatientAccount with a
	 * patientId matching the input patientId and returns it. If a patient with
	 * the input patientId was not found, it returns an empty PatientAccount object.
	 * 
	 * @param patientId
	 * @return
	 */
	public PatientAccount viewPatient(String patientId) {
		for(PatientAccount findPatient : this.patients) {
			if(findPatient.getPatientId().equals(patientId))
				return findPatient;
		}
		return new PatientAccount();
	}
	
	/**
	 * viewPatient searches Clinic.patients for a PatientAccount with a
	 * patientId matching the currentUser patientId and returns it. If a patient with
	 * the input patientId was not found, it returns an empty PatientAccount object.
	 * 
	 * @return
	 */
	public PatientAccount viewPatientSelf() {
		return this.viewPatient(currentUser);
	}
	
	/**
	 * viewVisits searches Clinic.visits for each ClinicVisit instance that has a 
	 * providerId or patientId matching that of the current user, Clinic.currentUser.
	 * 
	 * @return
	 */
	public ArrayList<ClinicVisit> viewVisits(){
		ArrayList<ClinicVisit> retrieveVisits = new ArrayList<>();
		
		// user is a provider
		if(this.providerStatus) {
			for(ClinicVisit checkVisit : this.visits) {
				if(checkVisit.getProviderId().equals(this.currentUser)) 
					retrieveVisits.add(checkVisit);
			}
		}
		
		// user is a patient
		else {
			for(ClinicVisit checkVisit : this.visits) {
				if(checkVisit.getPatientId().equals(this.currentUser)) 
					retrieveVisits.add(checkVisit);
			}
		}
		
		return retrieveVisits;
	}
	
	/**
	 * viewVisits searches Clinic.visits for each ClinicVisit instance that has a
	 * patientId matching the input patientId
	 * 
	 * @param patientId
	 * @return
	 */
	public ArrayList<ClinicVisit> viewVisits(String patientId){
		ArrayList<ClinicVisit> retrieveVisits = new ArrayList<>();
		
		for(ClinicVisit checkVisit : this.visits) {
			if(checkVisit.getPatientId().equals(patientId)) 
				retrieveVisits.add(checkVisit);
		}
	
		return retrieveVisits;
	}

	/**
	 * viewMessages finds all messages in Clinic.messages with patient and provider
	 * IDs corresponding to Clinic.currentUser and the input recipientId, and returns
	 * them as an ArrayList<ClinicMessage>
	 * 
	 * @param recipientId
	 * @return
	 */
	public ArrayList<ClinicMessage> viewMessages(String recipientId){
		ArrayList<ClinicMessage> retrieveMessages = new ArrayList<>();
		
		// user is a provider
		if(this.providerStatus) {
			for(ClinicMessage checkMessage : this.messages) {
				if(checkMessage.getPatientId().equals(recipientId) && checkMessage.getProviderId().equals(this.currentUser)) 
					retrieveMessages.add(checkMessage);
			}
		}
		
		// user is a patient
		else {
			for(ClinicMessage checkMessage : this.messages) {
				if(checkMessage.getPatientId().equals(this.currentUser) && checkMessage.getProviderId().equals(recipientId)) 
					retrieveMessages.add(checkMessage);
			}
		}
		
		return retrieveMessages;
	}

	/**
	 * updatePatient accepts a PatientAccount object, finds the patient in
	 * Clinic.patients with a matching patientId, and changes it to the input
	 * PatientAccount
	 * 
	 * @param newPatientInfo
	 */
	public void updatePatient(PatientAccount newPatientInfo) {
		for(PatientAccount updatePatient : this.patients) {
			if(updatePatient.getPatientId().equals(newPatientInfo.getPatientId())) {
				updatePatient = newPatientInfo;
				this.writePatientAccount(updatePatient);
			}
				
		}
	}
	
	
	
	
	// Methods for adding to Clinic lists
	public void addProvider(ProviderAccount newProvider) {
		this.providers.add(newProvider);
	}
	
	public void addPatient(PatientAccount newPatient) {
		this.patients.add(newPatient);
	}
	
	public void addVisit(ClinicVisit newVisit) {
		this.visits.add(newVisit);
	}
	
	public void addMessage(ClinicMessage newMessage) {
		this.messages.add(newMessage);
	}
	
	public void addLogin(Login newLogin) {
		this.logins.add(newLogin);
	}
	
}
