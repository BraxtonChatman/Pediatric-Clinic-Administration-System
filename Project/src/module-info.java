module Project {
	requires javafx.controls;
	requires javafx.graphics;
	requires junit;
	requires javafx.fxml;
	
	
	opens application to javafx.graphics, javafx.fxml;
}