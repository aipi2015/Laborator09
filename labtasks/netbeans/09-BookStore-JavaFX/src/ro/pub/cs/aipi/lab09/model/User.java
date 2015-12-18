package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class User extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty personal_identifier;
	final private SimpleStringProperty first_name;
	final private SimpleStringProperty last_name;
	final private SimpleStringProperty address;
	final private SimpleStringProperty phone_number;
	final private SimpleStringProperty email;
	final private SimpleStringProperty type;
	final private SimpleStringProperty username;
	final private SimpleStringProperty password;

	public User(String id, String personal_identifier, String first_name, String last_name, String address,
			String phone_number, String email, String type, String username, String password) {
		this.id = new SimpleStringProperty(id);
		this.personal_identifier = new SimpleStringProperty(personal_identifier);
		this.first_name = new SimpleStringProperty(first_name);
		this.last_name = new SimpleStringProperty(last_name);
		this.address = new SimpleStringProperty(address);
		this.phone_number = new SimpleStringProperty(phone_number);
		this.email = new SimpleStringProperty(email);
		this.type = new SimpleStringProperty(type);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
	}

	public User(List<String> user) {
		this.id = new SimpleStringProperty(user.get(0));
		this.personal_identifier = new SimpleStringProperty(user.get(1));
		this.first_name = new SimpleStringProperty(user.get(2));
		this.last_name = new SimpleStringProperty(user.get(3));
		this.address = new SimpleStringProperty(user.get(4));
		this.phone_number = new SimpleStringProperty(user.get(5));
		this.email = new SimpleStringProperty(user.get(6));
		this.type = new SimpleStringProperty(user.get(7));
		this.username = new SimpleStringProperty(user.get(8));
		this.password = new SimpleStringProperty(user.get(9));
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public String getPersonal_identifier() {
		return personal_identifier.get();
	}

	public void setPersonal_identifier(String personal_identifier) {
		this.personal_identifier.set(personal_identifier);
	}

	public String getFirst_name() {
		return first_name.get();
	}

	public void setFirst_name(String first_name) {
		this.first_name.set(first_name);
	}

	public String getLast_name() {
		return last_name.get();
	}

	public void setLast_name(String last_name) {
		this.last_name.set(last_name);
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public String getPhone_number() {
		return phone_number.get();
	}

	public void setphone_number(String phone_number) {
		this.phone_number.set(phone_number);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();
		values.add(id.get());
		values.add(personal_identifier.get());
		values.add(first_name.get());
		values.add(last_name.get());
		values.add(address.get());
		values.add(phone_number.get());
		values.add(email.get());
		values.add(type.get());
		values.add(username.get());
		values.add(password.get());
		return values;
	}
}
