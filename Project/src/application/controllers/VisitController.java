package application.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import application.ClinicVisit;
import application.ProviderAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class VisitController {

	private ArrayList<ClinicVisit> userVisits;
	private ArrayList<ProviderAccount> providerList;
	
	@FXML
	private ListView<String> upcomingListView;
	
	@FXML
	private ListView<String> pastListView;
	
	
	@FXML
	public void initialize() {
//		ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6");
//		
		// TODO: add listener for new visit scheduled
	}
	
	/**
	 * setToLists takes this.userVisits and organizes the visits to either upcoming or past
	 * visits to be displayed in the list views
	 */
	@FXML
	public void setToLists() {
		ObservableList<String> visitItemsPast = FXCollections.observableArrayList();
		ObservableList<String> visitItemsUpcoming = FXCollections.observableArrayList();
		String tempString = "";
		String providerName = "";
		LocalDate currentDate = LocalDate.now();
		LocalDate visitDate = LocalDate.now();
		
		// iterate through the list of providers to find the name of the doctor with the given providerId
		for(ClinicVisit x : userVisits) {
			providerName = "";
			for(ProviderAccount provider : providerList) {
				if(provider.getProviderId().equals(x.getProviderId())) {
					providerName = "Dr. " + provider.getFirstName() + " " + provider.getLastName();
					break;
				}
			}
			tempString = providerName + "\n" + x.getVisitDate() + ", " + x.getVisitTime();
			
			// add visits from the list to either upcoming visits or past visits based on date
			visitDate = LocalDate.parse(x.getVisitDate());
			if(visitDate.isAfter(currentDate) || visitDate.isEqual(currentDate)) {
				visitItemsUpcoming.add(tempString);
			}
			else if(visitDate.isBefore(currentDate)) {
				visitItemsPast.add(tempString);
			}	
		}
		upcomingListView.setItems(visitItemsUpcoming);
		pastListView.setItems(visitItemsPast);
	}
	
	public void setUserVisits(ArrayList<ClinicVisit> newVisits) {
		this.userVisits = newVisits;
	}
	
	public void setProviderAccounts(ArrayList<ProviderAccount> newList) {
		this.providerList = newList;
	}
}
