package application.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class VisitController {

	@FXML
	private ListView<String> upcomingListView;
	
	
	
	@FXML
	public void initialize() {
		ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6");
		
		upcomingListView.setItems(items);
	}
	
}
