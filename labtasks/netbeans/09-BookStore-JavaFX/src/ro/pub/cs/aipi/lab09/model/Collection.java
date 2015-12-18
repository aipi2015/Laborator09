package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Collection extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty name;
	final private SimpleStringProperty description;
	final private SimpleStringProperty publishing_house_id;

	public Collection(String id, String name, String description, String publishing_house_id) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.publishing_house_id = new SimpleStringProperty(publishing_house_id);
	}

	public Collection(List<String> collection) {
		this.id = new SimpleStringProperty(collection.get(0));
		this.name = new SimpleStringProperty(collection.get(1));
		this.description = new SimpleStringProperty(collection.get(2));
		this.publishing_house_id = new SimpleStringProperty(collection.get(3));
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public String getPublishing_house_id() {
		return publishing_house_id.get();
	}

	public void setPublishing_house_id(String publishing_house_id) {
		this.publishing_house_id.set(publishing_house_id);
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();
		values.add(id.get());
		values.add(name.get());
		values.add(description.get());
		values.add(publishing_house_id.get());
		return values;
	}
}
