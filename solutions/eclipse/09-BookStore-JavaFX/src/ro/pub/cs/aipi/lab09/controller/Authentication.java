package ro.pub.cs.aipi.lab09.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import ro.pub.cs.aipi.lab09.dataaccess.DatabaseOperations;
import ro.pub.cs.aipi.lab09.dataaccess.DatabaseOperationsImplementation;
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

		DatabaseOperations databaseOperations = DatabaseOperationsImplementation.getInstance();

		List<String> attributes = new ArrayList<>();
		attributes.add(Constants.USER_TYPE_ATTRIBUTE);
		List<List<String>> userTypes = databaseOperations.getTableContent(Constants.USER_TABLE_NAME, attributes,
				"username=\'" + usernameTextField.getText() + "\' AND password=\'" + passwordTextField.getText() + "\'",
				null, null, null);

		if (userTypes.isEmpty()) {
			errorLabel.setText(Constants.ERROR_USERNAME_PASSWORD);
			FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), errorLabel);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0.0);
			fadeTransition.play();

			usernameTextField.setText("");
			passwordTextField.setText("");
		} else {
			userTypes.stream().forEach((userRole) -> {
				if (userRole.get(0).equals(Constants.USER_TYPE_ADMINISTRATOR_VALUE)) {
					new Container().start();
					((Node) event.getSource()).getScene().getWindow().hide();
				} else {
					errorLabel.setText(Constants.ERROR_ACCESS_NOT_ALLOWED);
					FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), errorLabel);
					fadeTransition.setFromValue(1.0);
					fadeTransition.setToValue(0.0);
					fadeTransition.play();
					usernameTextField.setText("");
					passwordTextField.setText("");
				}
			});
		}
	}

	@FXML
	protected void cancelButtonHandler(ActionEvent event) {
		Platform.exit();
	}
}
