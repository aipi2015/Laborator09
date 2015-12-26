package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Language extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty name;
	final private SimpleStringProperty code;
	final private SimpleStringProperty description;

	public Language(String id, String name, String code, String description) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.code = new SimpleStringProperty(code);
		this.description = new SimpleStringProperty(description);
	}

	public Language(List<String> language) {
		this.id = new SimpleStringProperty(language.get(0));
		this.name = new SimpleStringProperty(language.get(1));
		this.code = new SimpleStringProperty(language.get(2));
		this.description = new SimpleStringProperty(language.get(2));
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

	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
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
		values.add(name.get());
		values.add(code.get());
		values.add(description.get());
		return values;
	}
}
