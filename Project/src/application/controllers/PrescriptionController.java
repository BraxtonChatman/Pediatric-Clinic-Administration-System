package application.controllers;

import java.util.ArrayList;
import application.ClinicVisit;
import application.ProviderAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PrescriptionController {

	private ArrayList<ClinicVisit> userVisits;
	private ArrayList<ProviderAccount> providerList;
	
	@FXML
	private ListView<String> prescriptionListView;
	
	/**
	 * setToList takes this.userVisits and adds any prescriptions indicated in the visit to the
	 * prescriptionListView to be displayed.
	 */
	@FXML
	public void setToList() {
		ObservableList<String> prescriptionItems = FXCollections.observableArrayList();
		String tempString = "";
		String providerName = "";
		
		// iterate through list of patient visits for any indicated prescriptions
		for(ClinicVisit x : userVisits) {
			providerName = "";
			if(x.getPrescriptions() != null && x.getPrescriptions() != "") {
				// get the name of the prescribing doctor
				for(ProviderAccount provider : providerList) {
					if(provider.getProviderId().equals(x.getProviderId())) {
						providerName = "Dr. " + provider.getFirstName() + " " + provider.getLastName();
						break;
					}
				}
				// construct the string to be added to list view consisting of prescription, doctor, date
				tempString = x.getPrescriptions() +"\nPrescribed by: "+ providerName + " on " + x.getVisitDate();
				prescriptionItems.add(tempString);
			}	
		}
		// add items to list view
		if(prescriptionItems != null)
			prescriptionListView.setItems(prescriptionItems);
	}
	
	public void setUserVisits(ArrayList<ClinicVisit> newVisits) {
		this.userVisits = newVisits;
	}
	
	public void setProviderAccounts(ArrayList<ProviderAccount> newList) {
		this.providerList = newList;
	}
	
}
