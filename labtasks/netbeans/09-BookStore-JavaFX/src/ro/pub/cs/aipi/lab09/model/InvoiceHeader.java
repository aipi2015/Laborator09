package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class InvoiceHeader extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty identification_number;
	final private SimpleStringProperty issue_date;
	final private SimpleStringProperty state;
	final private SimpleStringProperty user_id;

	public InvoiceHeader(String id, String identification_number, String issue_date, String state, String user_id) {
		this.id = new SimpleStringProperty(id);
		this.identification_number = new SimpleStringProperty(identification_number);
		this.issue_date = new SimpleStringProperty(issue_date);
		this.state = new SimpleStringProperty(state);
		this.user_id = new SimpleStringProperty(user_id);
	}

	public InvoiceHeader(List<String> invoiceHeader) {
		this.id = new SimpleStringProperty(invoiceHeader.get(0));
		this.identification_number = new SimpleStringProperty(invoiceHeader.get(1));
		this.issue_date = new SimpleStringProperty(invoiceHeader.get(2));
		this.state = new SimpleStringProperty(invoiceHeader.get(3));
		this.user_id = new SimpleStringProperty(invoiceHeader.get(4));
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public String getIdentification_number() {
		return identification_number.get();
	}

	public void setIdentification_number(String identification_number) {
		this.identification_number.set(identification_number);
	}

	public String getIssue_date() {
		return issue_date.get();
	}

	public void setIssue_date(String issue_date) {
		this.issue_date.set(issue_date);
	}

	public String getState() {
		return state.get();
	}

	public void setState(String state) {
		this.state.set(state);
	}

	public String getUser_id() {
		return user_id.get();
	}

	public void setUser_id(String user_id) {
		this.user_id.set(user_id);
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();
		values.add(id.get());
		values.add(identification_number.get());
		values.add(issue_date.get());
		values.add(state.get());
		values.add(user_id.get());
		return values;
	}
}
