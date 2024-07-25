module Project {
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires junit;
	requires javafx.fxml;
	requires javafx.base;
	
	exports application;
	//exports application.controllers;
	
	opens application.controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}