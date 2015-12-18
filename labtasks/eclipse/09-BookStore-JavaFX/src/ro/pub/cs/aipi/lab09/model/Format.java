package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Format extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty value;
	final private SimpleStringProperty description;

	public Format(String id, String value, String description) {
		this.id = new SimpleStringProperty(id);
		this.value = new SimpleStringProperty(value);
		this.description = new SimpleStringProperty(description);
	}

	public Format(List<String> format) {
		this.id = new SimpleStringProperty(format.get(0));
		this.value = new SimpleStringProperty(format.get(1));
		this.description = new SimpleStringProperty(format.get(2));
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public String getValue() {
		return value.get();
	}

	public void seValue(String value) {
		this.value.set(value);
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();
		values.add(id.get());
		values.add(value.get());
		values.add(description.get());
		return values;
	}
}
