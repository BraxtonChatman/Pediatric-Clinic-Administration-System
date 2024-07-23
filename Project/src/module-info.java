module Project {
	requires javafx.controls;
	requires javafx.graphics;
	requires junit;
	requires javafx.fxml;
	requires javafx.base;
	
	exports application.controllers;
	
	opens application.controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}