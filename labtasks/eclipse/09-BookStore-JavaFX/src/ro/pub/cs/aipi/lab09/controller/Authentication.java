package ro.pub.cs.aipi.lab09.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ro.pub.cs.aipi.lab09.general.Constants;

public class Authentication {

	private Stage applicationStage;
	private Scene applicationScene;

	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Label errorLabel;

	public void start() {

		try {
			applicationScene = new Scene(
					(Parent) FXMLLoader.load(getClass().getResource(Constants.AUTHENTICATION_FXML)));
		} catch (Exception exception) {
			System.out.println("An exception has occured: " + exception.getMessage());
			if (Constants.DEBUG) {
				exception.printStackTrace();
			}
		}

		applicationStage = new Stage();
		applicationStage.setTitle(Constants.APPLICATION_NAME);
		applicationStage.getIcons().add(new Image(getClass().getResource(Constants.ICON_FILE_NAME).toExternalForm()));
		applicationStage.setScene(applicationScene);
		applicationStage.show();
	}

	@FXML
	protected void okButtonHandler(ActionEvent event) throws Exception {

		// TODO: exercise 02

	}

	@FXML
	protected void cancelButtonHandler(ActionEvent event) {
		
		// TODO: exercise 02

	}
}
