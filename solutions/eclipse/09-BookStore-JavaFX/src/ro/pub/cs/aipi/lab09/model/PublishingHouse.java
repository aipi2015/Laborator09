package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class PublishingHouse extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty name;
	final private SimpleStringProperty registered_number;
	final private SimpleStringProperty description;
	final private SimpleStringProperty postal_address;
	final private SimpleStringProperty zip_code;
	final private SimpleStringProperty country_id;
	final private SimpleStringProperty internet_address;

	public PublishingHouse(String id, String name, String registered_number, String description, String postal_address,
			String zip_code, String country_id, String internet_address) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.registered_number = new SimpleStringProperty(registered_number);
		this.description = new SimpleStringProperty(description);
		this.postal_address = new SimpleStringProperty(postal_address);
		this.zip_code = new SimpleStringProperty(zip_code);
		this.country_id = new SimpleStringProperty(country_id);
		this.internet_address = new SimpleStringProperty(internet_address);
	}

	public PublishingHouse(List<String> publishingHouse) {
		this.id = new SimpleStringProperty(publishingHouse.get(0));
		this.name = new SimpleStringProperty(publishingHouse.get(1));
		this.registered_number = new SimpleStringProperty(publishingHouse.get(2));
		this.description = new SimpleStringProperty(publishingHouse.get(3));
		this.postal_address = new SimpleStringProperty(publishingHouse.get(4));
		this.zip_code = new SimpleStringProperty(publishingHouse.get(5));
		this.country_id = new SimpleStringProperty(publishingHouse.get(6));
		this.internet_address = new SimpleStringProperty(publishingHouse.get(7));
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

	public String getRegistered_number() {
		return registered_number.get();
	}

	public void setRegistered_number(String registered_number) {
		this.registered_number.set(registered_number);
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public String getPostal_address() {
		return postal_address.get();
	}

	public void setPostal_address(String postal_address) {
		this.postal_address.set(postal_address);
	}

	public String getZip_code() {
		return zip_code.get();
	}

	public void setZip_code(String zip_code) {
		this.zip_code.set(zip_code);
	}

	public String getCountry_id() {
		return country_id.get();
	}

	public void setCountry_id(String country_id) {
		this.country_id.set(country_id);
	}

	public String getInternet_address() {
		return internet_address.get();
	}

	public void setInternet_address(String internet_address) {
		this.internet_address.set(internet_address);
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();
		values.add(id.get());
		values.add(name.get());
		values.add(registered_number.get());
		values.add(description.get());
		values.add(postal_address.get());
		values.add(zip_code.get());
		values.add(country_id.get());
		values.add(internet_address.get());
		return values;
	}
}
