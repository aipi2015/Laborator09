package ro.pub.cs.aipi.lab09.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import ro.pub.cs.aipi.lab09.dataaccess.DatabaseException;
import ro.pub.cs.aipi.lab09.dataaccess.DatabaseOperations;
import ro.pub.cs.aipi.lab09.dataaccess.DatabaseOperationsImplementation;
import ro.pub.cs.aipi.lab09.general.Constants;
import ro.pub.cs.aipi.lab09.general.Utilities;
import ro.pub.cs.aipi.lab09.model.Author;
import ro.pub.cs.aipi.lab09.model.Book;
import ro.pub.cs.aipi.lab09.model.BookPresentation;
import ro.pub.cs.aipi.lab09.model.Category;
import ro.pub.cs.aipi.lab09.model.CategoryContent;
import ro.pub.cs.aipi.lab09.model.Collection;
import ro.pub.cs.aipi.lab09.model.Country;
import ro.pub.cs.aipi.lab09.model.Format;
import ro.pub.cs.aipi.lab09.model.InvoiceHeader;
import ro.pub.cs.aipi.lab09.model.InvoiceLine;
import ro.pub.cs.aipi.lab09.model.Language;
import ro.pub.cs.aipi.lab09.model.Model;
import ro.pub.cs.aipi.lab09.model.PublishingHouse;
import ro.pub.cs.aipi.lab09.model.SupplyOrderHeader;
import ro.pub.cs.aipi.lab09.model.SupplyOrderLine;
import ro.pub.cs.aipi.lab09.model.User;
import ro.pub.cs.aipi.lab09.model.Writer;

public class TableManagement {

	private final String tableName;

	private ArrayList<Label> attributesLabels;
	private ArrayList<Control> attributesControls;

	private final DatabaseOperations databaseOperations;

	@FXML
	private Button insertButton;
	@FXML
	private Button updateButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button searchButton;
	@FXML
	private Button clearButton;

	@FXML
	private TableView<Model> tableContentTableView;
	@FXML
	private GridPane attributesGridPane;

	public TableManagement(String tableName) {
		this.tableName = tableName;
		databaseOperations = DatabaseOperationsImplementation.getInstance();
	}

	@FXML
	public void initialize() throws SQLException {

		if (tableName == null || tableName.isEmpty()) {
			return;
		}

		if (Constants.DEBUG) {
			System.out.println("starting initialize " + tableName + "...");
		}

		List<String> attributes = databaseOperations.getTableColumns(tableName);

		attributesLabels = new ArrayList<>();
		attributesControls = new ArrayList<>();

		tableContentTableView.setItems(null);
		if (tableContentTableView.getColumns() != null) {
			tableContentTableView.getColumns().clear();
		}

		tableContentTableView.setEditable(true);
		int currentIndex = 0;
		for (String attribute : attributes) {

			TableColumn<Model, String> column = new TableColumn<>(attribute);
			column.setMinWidth(tableContentTableView.getPrefWidth() / attributes.size());
			column.setCellValueFactory(new PropertyValueFactory<>(attribute));
			tableContentTableView.getColumns().add(column);

			attributesLabels.add(new Label(attribute));
			GridPane.setConstraints(attributesLabels.get(attributesLabels.size() - 1), 0, currentIndex);
			attributesGridPane.getChildren().add(attributesLabels.get(attributesLabels.size() - 1));

			String parentTable = databaseOperations.getForeignKeyParentTable(tableName, attribute);
			if (parentTable != null) {
				ComboBox<String> attributeComboBox = new ComboBox<>();
				attributeComboBox.setMinWidth(Constants.DEFAULT_COMBOBOX_WIDTH);
				attributeComboBox.setMaxWidth(Constants.DEFAULT_COMBOBOX_WIDTH);
				List<List<String>> parentTableContent = databaseOperations.getTableContent(parentTable, null, null,
						null, null, null);
				parentTableContent.stream().forEach((parentTableRecord) -> {
					attributeComboBox.getItems().add(Utilities.compress(parentTableRecord));
				});
				attributesControls.add(attributeComboBox);
			} else {
				TextField attributeTextField = new TextField();
				attributeTextField.setMinWidth(Constants.DEFAULT_TEXTFIELD_WIDTH);
				attributeTextField.setPromptText(attribute);
				if (currentIndex == 0) {
					attributeTextField.setText(
							Integer.toString(databaseOperations.getTablePrimaryKeyMaximumValue(tableName) + 1));
					attributeTextField.setEditable(false);
				}
				attributesControls.add(attributeTextField);
			}
			GridPane.setConstraints(attributesControls.get(attributesControls.size() - 1), 1, currentIndex);
			attributesGridPane.getChildren().add(attributesControls.get(attributesControls.size() - 1));

			currentIndex++;
		}
		populateTableView(null);

		final DropShadow dropShadow = new DropShadow();
		final FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
		fadeTransition.setFromValue(1.0f);
		fadeTransition.setToValue(0.8f);
		fadeTransition.setCycleCount(Timeline.INDEFINITE);
		fadeTransition.setAutoReverse(true);
		final ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1));
		scaleTransition.setByX(0.1f);
		scaleTransition.setByY(0.1f);
		scaleTransition.setCycleCount(Timeline.INDEFINITE);
		scaleTransition.setAutoReverse(true);
		final ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, scaleTransition);

		ArrayList<Button> buttonList = new ArrayList<>();
		buttonList.add(insertButton);
		buttonList.add(updateButton);
		buttonList.add(deleteButton);
		buttonList.add(searchButton);
		buttonList.add(clearButton);
		buttonList.stream().map((currentButton) -> {
			currentButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
				currentButton.setEffect(dropShadow);
				fadeTransition.setNode(currentButton);
				scaleTransition.setNode(currentButton);
				parallelTransition.play();
			});
			return currentButton;
		}).forEach((currentButton) -> {
			currentButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
				currentButton.setEffect(null);
				parallelTransition.jumpTo(Duration.ZERO);
				fadeTransition.setNode(null);
				scaleTransition.setNode(null);
				parallelTransition.stop();
				parallelTransition.setNode(null);
			});
		});

		if (Constants.DEBUG) {
			System.out.println("finishing initialize " + tableName + "...");
		}

	}

	private Model getCurrentEntity(List<String> values) {
		switch (tableName) {
		case Constants.AUTHOR_TABLE_NAME:
			return new Author(values);
		case Constants.BOOK_TABLE_NAME:
			return new Book(values);
		case Constants.BOOK_PRESENTATION_TABLE_NAME:
			return new BookPresentation(values);
		case Constants.CATEGORY_TABLE_NAME:
			return new Category(values);
		case Constants.CATEGORY_CONTENT_TABLE_NAME:
			return new CategoryContent(values);
		case Constants.COLLECTION_TABLE_NAME:
			return new Collection(values);
		case Constants.COUNTRY_TABLE_NAME:
			return new Country(values);
		case Constants.FORMAT_TABLE_NAME:
			return new Format(values);
		case Constants.INVOICE_HEADER_TABLE_NAME:
			return new InvoiceHeader(values);
		case Constants.INVOICE_LINE_TABLE_NAME:
			return new InvoiceLine(values);
		case Constants.LANGUAGE_TABLE_NAME:
			return new Language(values);
		case Constants.PUBLISHING_HOUSE_TABLE_NAME:
			return new PublishingHouse(values);
		case Constants.SUPPLY_ORDER_HEADER_TABLE_NAME:
			return new SupplyOrderHeader(values);
		case Constants.SUPPLY_ORDER_LINE_TABLE_NAME:
			return new SupplyOrderLine(values);
		case Constants.USER_TABLE_NAME:
			return new User(values);
		case Constants.WRITER_TABLE_NAME:
			return new Writer(values);
		}
		return null;
	}

	public void populateTableView(String whereClause) {
		try {
			List<List<String>> values = DatabaseOperationsImplementation.getInstance().getTableContent(tableName, null,
					(whereClause == null || whereClause.isEmpty()) ? null : whereClause, null, null, null);
			ObservableList<Model> data = FXCollections.observableArrayList();
			values.stream().forEach((record) -> {
				data.add(getCurrentEntity(record));
			});
			tableContentTableView.setItems(data);
		} catch (SQLException sqlException) {
			System.out.println("An exception had occured: " + sqlException.getMessage());
			if (Constants.DEBUG) {
				sqlException.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void tableContentTableViewHandler(MouseEvent mouseEvent) {
		List<String> tableViewRecord = ((Model) tableContentTableView.getSelectionModel().getSelectedItem())
				.getValues();
		int currentIndex = 0;
		for (String value : tableViewRecord) {
			if (attributesControls.get(currentIndex) instanceof ComboBox) {
				try {
					String parentTable = databaseOperations.getForeignKeyParentTable(tableName,
							attributesLabels.get(currentIndex).getText());
					if (parentTable != null) {
						List<List<String>> parentTableReferrence = null;
						parentTableReferrence = databaseOperations.getTableContent(parentTable, null,
								databaseOperations.getTablePrimaryKey(parentTable) + "="
										+ tableViewRecord.get(currentIndex),
								null, null, null);
						((ComboBox<String>) attributesControls.get(currentIndex))
								.setValue(Utilities.compress(parentTableReferrence.get(0)));
					}
				} catch (SQLException sqlException) {
					System.out.println("An exception had occured: " + sqlException.getMessage());
					if (Constants.DEBUG) {
						sqlException.printStackTrace();
					}
				}
			} else {
				((TextField) attributesControls.get(currentIndex)).setText(value);
			}
			currentIndex++;
		}
	}

	@SuppressWarnings("unchecked")
	private boolean checkAllFieldsCompletion() {
		return attributesControls.stream().map((attributeControl) -> {
			String value = null;
			if (attributeControl instanceof ComboBox) {
				value = ((ComboBox<String>) attributeControl).getValue();
			} else {
				value = ((TextField) attributeControl).getText();
			}
			return value;
		}).noneMatch((value) -> (value == null || value.isEmpty()));
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void insertButtonHandler(MouseEvent mouseEvent) {
		if (!checkAllFieldsCompletion()) {
			Dialog dialog = new Dialog();
			dialog.setProperties(Constants.ERROR_WINDOW_TITLE, Constants.ERROR_ICON_LOCATION,
					Constants.ERROR_MESSAGE_CONTENT);
			dialog.start();
			return;
		}
		int currentIndex = 0;
		List<String> values = new ArrayList<>();
		for (Control attributeControl : attributesControls) {
			if (attributeControl instanceof ComboBox) {
				try {
					values.add(databaseOperations.getForeignKeyValue(tableName,
							attributesLabels.get(currentIndex).getText(),
							Utilities.decompress(((ComboBox<String>) attributeControl).getValue())));
				} catch (Exception sqlException) {
					System.out.println("An exception had occured: " + sqlException.getMessage());
					if (Constants.DEBUG) {
						sqlException.printStackTrace();
					}
				}
			} else {
				values.add(((TextField) attributeControl).getText());
			}
			currentIndex++;
		}
		try {
			databaseOperations.insertValuesIntoTable(tableName, null, values, false);
		} catch (SQLException | DatabaseException exception) {
			System.out.println("An exception had occured: " + exception.getMessage());
			if (Constants.DEBUG) {
				exception.printStackTrace();
			}
		}
		populateTableView(null);
		tableContentTableView.getSelectionModel().select(tableContentTableView.getItems().size() - 1);
		tableContentTableView.scrollTo(tableContentTableView.getItems().size() - 1);
		clearButtonHandler(null);
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void updateButtonHandler(MouseEvent mouseEvent) {
		int tableViewSelectedIndex = tableContentTableView.getSelectionModel().getSelectedIndex();
		List<String> tableViewCurrentRecord = ((Model) tableContentTableView.getSelectionModel().getSelectedItem())
				.getValues();
		int currentIndex = 0;
		ArrayList<String> attributes = new ArrayList<>();
		ArrayList<String> values = new ArrayList<>();
		for (Control attributeControl : attributesControls) {
			String value = null;
			if (attributeControl instanceof ComboBox) {
				try {
					String parentTableValues = ((ComboBox<String>) attributeControl).getValue();
					if (parentTableValues != null && !parentTableValues.isEmpty()) {
						value = databaseOperations.getForeignKeyValue(tableName,
								attributesLabels.get(currentIndex).getText(), Utilities.decompress(parentTableValues));
					}
				} catch (Exception sqlException) {
					System.out.println("An exception had occured: " + sqlException.getMessage());
					if (Constants.DEBUG) {
						sqlException.printStackTrace();
					}
				}
			} else {
				value = ((TextField) attributeControl).getText();
			}
			if (value != null && !value.isEmpty()) {
				attributes.add(attributesLabels.get(currentIndex).getText());
				values.add(value);
			}
			currentIndex++;
		}
		try {
			if (attributes != null && values != null && !attributes.isEmpty() && !values.isEmpty()) {
				databaseOperations.updateRecordsIntoTable(tableName, attributes, values,
						databaseOperations.getTablePrimaryKey(tableName) + "=\'" + tableViewCurrentRecord.get(0)
								+ "\'");
			}
		} catch (SQLException | DatabaseException exception) {
			System.out.println("An exception had occured: " + exception.getMessage());
			if (Constants.DEBUG) {
				exception.printStackTrace();
			}
		}
		populateTableView(null);
		tableContentTableView.getSelectionModel().select(tableViewSelectedIndex);
		clearButtonHandler(null);
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void deleteButtonHandler(MouseEvent mouseEvent) {
		int currentIndex = 0;
		ArrayList<String> attributes = new ArrayList<>();
		ArrayList<String> values = new ArrayList<>();
		for (Control attributeControl : attributesControls) {
			String value = null;
			if (attributeControl instanceof ComboBox) {
				try {
					String parentTableValues = ((ComboBox<String>) attributeControl).getValue();
					if (parentTableValues != null && !parentTableValues.isEmpty()) {
						value = databaseOperations.getForeignKeyValue(tableName,
								attributesLabels.get(currentIndex).getText(), Utilities.decompress(parentTableValues));
					}
				} catch (Exception sqlException) {
					System.out.println("An exception had occured: " + sqlException.getMessage());
					if (Constants.DEBUG) {
						sqlException.printStackTrace();
					}
				}
			} else {
				value = ((TextField) attributeControl).getText();
			}
			if (value != null && !value.isEmpty()) {
				attributes.add(attributesLabels.get(currentIndex).getText());
				values.add(value);
			}
			currentIndex++;
		}
		try {
			if (attributes != null && values != null && !attributes.isEmpty() && !values.isEmpty()) {
				databaseOperations.deleteRecordsFromTable(tableName, attributes, values, null);
			}
		} catch (SQLException | DatabaseException exception) {
			System.out.println("An exception had occured: " + exception.getMessage());
			if (Constants.DEBUG) {
				exception.printStackTrace();
			}
		}
		populateTableView(null);
		tableContentTableView.getSelectionModel().select(0);
		tableContentTableView.scrollTo(0);
		clearButtonHandler(null);
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void searchButtonHandler(MouseEvent mouseEvent) {
		int currentIndex = 0;
		String whereClause = "";
		for (Control attributeControl : attributesControls) {
			String value = null;
			if (attributeControl instanceof ComboBox) {
				try {
					String parentTableValues = ((ComboBox<String>) attributeControl).getValue();
					if (parentTableValues != null && !parentTableValues.isEmpty()) {
						value = databaseOperations.getForeignKeyValue(tableName,
								attributesLabels.get(currentIndex).getText(), Utilities.decompress(parentTableValues));
					}
				} catch (Exception exception) {
					System.out.println("An exception had occured: " + exception.getMessage());
					if (Constants.DEBUG) {
						exception.printStackTrace();
					}
				}
			} else {
				value = ((TextField) attributeControl).getText();
			}
			if (value != null && !value.isEmpty() && currentIndex != 0) {
				whereClause += ((whereClause.isEmpty()) ? "" : " AND ") + attributesLabels.get(currentIndex).getText()
						+ " LIKE \'%" + Utilities.escape(value) + "%\'";
			}
			currentIndex++;
		}
		System.out.println("*" + (!whereClause.isEmpty() ? whereClause : null) + "*");
		populateTableView(!whereClause.isEmpty() ? whereClause : null);
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void clearButtonHandler(MouseEvent mouseEvent) {
		int currentIndex = 0;
		for (Control attributeControl : attributesControls) {
			if (attributeControl instanceof ComboBox) {
				((ComboBox<String>) attributeControl).setValue("");
			} else {
				try {
					if (currentIndex == 0) {
						((TextField) attributeControl).setText(
								Integer.toString(databaseOperations.getTablePrimaryKeyMaximumValue(tableName) + 1));
					} else {
						((TextField) attributeControl).setText("");
					}
				} catch (SQLException sqlException) {
					System.out.println("An exception had occured: " + sqlException.getMessage());
					if (Constants.DEBUG) {
						sqlException.printStackTrace();
					}
				}
			}
			currentIndex++;
		}
	}
}
