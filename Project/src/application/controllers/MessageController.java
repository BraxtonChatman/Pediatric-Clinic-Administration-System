package application.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import application.ClinicMessage;
import application.PatientAccount;
import application.ProviderAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


public class MessageController {
	
	private ArrayList<ClinicMessage> userMessages;
	private ArrayList<ProviderAccount> providerList;
	private ArrayList<PatientAccount> patientList;
	private boolean providerStatus;
	private Map<String, ArrayList<ClinicMessage>> threadMap;
	
	@FXML
	private ListView<String> threadsListView;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button sendMessageButton;

	@FXML
	public void initialize() {
		threadMap = new LinkedHashMap<>();
	}
	
	@FXML
	public void setToList() {
		Map<String, ArrayList<ClinicMessage>> tempMap = new LinkedHashMap<>();
		ObservableList<String> threadItems = FXCollections.observableArrayList();
		String tempString = "";
		String recipientName = "";
		
		// iterate through list of messages and populate threadMap with recipient:message-list pairings
		for(ClinicMessage checkMessage : userMessages) {
			String recipientId = providerStatus ? checkMessage.getPatientId() : checkMessage.getProviderId();
			tempMap.computeIfAbsent(recipientId, k -> new ArrayList<>()).add(checkMessage);
		}
		
		// sort messages in threads by recency
		for(Map.Entry<String, ArrayList<ClinicMessage>> entry : tempMap.entrySet()) {
			ArrayList<ClinicMessage> messagesSort = entry.getValue();
			messagesSort.sort(Comparator.comparingInt(ClinicMessage::getMessageId).reversed());
		}
		
		// sort threads by most recent message in thread
		List<Map.Entry<String, ArrayList<ClinicMessage>>> threadEntries = new ArrayList<>(tempMap.entrySet());
		threadEntries.sort((e1, e2) ->{
			ClinicMessage recentMessage1 = e1.getValue().get(0);
			ClinicMessage recentMessage2 = e2.getValue().get(0);
			return Integer.compare(recentMessage1.getMessageId(), recentMessage2.getMessageId());
		});
		
		// reinsert sorted threads into new linked
		for(Map.Entry<String, ArrayList<ClinicMessage>> entry : threadEntries) {
			threadMap.put(entry.getKey(), entry.getValue());
		}
		
		// add message summaries to listview
		// get name of recipient based on whether the user is a patient or provider
		for(Map.Entry<String, ArrayList<ClinicMessage>> entry : threadMap.entrySet()) {
			recipientName = "";
			tempString = "";
			
			if(providerStatus) {
				for(PatientAccount checkAccount : patientList) {
					if(checkAccount.getPatientId().equals(entry.getKey())) {
						recipientName = "Conversation with " + checkAccount.getFirstName() + " " + checkAccount.getLastName() + ":";
						break;
					}
				}
			}
			else {
				for(ProviderAccount checkAccount : providerList) {
					if(checkAccount.getProviderId().equals(entry.getKey())) {
						recipientName = "Conversation with " + checkAccount.getFirstName() + " " + checkAccount.getLastName() + ":";
						break;
					}
				}
			}
			
			// get message content of most recent message in thread
			tempString = entry.getValue().get(0).getClinicMessage();
			if(tempString.length() > 80) {
				tempString = tempString.substring(0, 80);
			}
			tempString = recipientName + "\n" + tempString + "\n\n";
			threadItems.add(tempString);
		}
		threadsListView.setItems(threadItems);		
	}
	
	@FXML
	private void backButtonHandler(ActionEvent event) {
		
	}
	
	@FXML
	private void sendMessageButtonHandler(ActionEvent event) {
		
	}
	
	public void setUserMessages(ArrayList<ClinicMessage> newMessages) {
		this.userMessages = newMessages;
	}
	
	public void setProviderAccounts(ArrayList<ProviderAccount> newList) {
		this.providerList = newList;
	}
	
	public void setPatientAccounts(ArrayList<PatientAccount> newList) {
		this.patientList = newList;
	}
	
	public void setProviderStatus(boolean newStatus) {
		this.providerStatus = newStatus;
	}
	
}
