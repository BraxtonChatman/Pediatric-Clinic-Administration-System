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
	
	private Clinic mainClinic = new Clinic();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// TODO: for testing display based on user type
			mainClinic.setProviderStatus(false);
			
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
}
