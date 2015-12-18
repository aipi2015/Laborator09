package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class InvoiceLine extends Model {

	final private SimpleStringProperty id;
	final private SimpleStringProperty invoice_header_id;
	final private SimpleStringProperty book_presentation_id;
	final private SimpleStringProperty quantity;

	public InvoiceLine(String id, String invoice_header_id, String book_presentation_id, String quantity) {
		this.id = new SimpleStringProperty(id);
		this.invoice_header_id = new SimpleStringProperty(invoice_header_id);
		this.book_presentation_id = new SimpleStringProperty(book_presentation_id);
		this.quantity = new SimpleStringProperty(quantity);
	}

	public InvoiceLine(List<String> invoiceLine) {
		this.id = new SimpleStringProperty(invoiceLine.get(0));
		this.invoice_header_id = new SimpleStringProperty(invoiceLine.get(1));
		this.book_presentation_id = new SimpleStringProperty(invoiceLine.get(2));
		this.quantity = new SimpleStringProperty(invoiceLine.get(3));
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public String getInvoice_header_id() {
		return invoice_header_id.get();
	}

	public void setInvoice_header_id(String invoice_header_id) {
		this.invoice_header_id.set(invoice_header_id);
	}

	public String getBook_presentation_id() {
		return book_presentation_id.get();
	}

	public void setBook_id(String book_presentation_id) {
		this.book_presentation_id.set(book_presentation_id);
	}

	public String getQuantity() {
		return quantity.get();
	}

	public void setQuantity(String quantity) {
		this.quantity.set(quantity);
	}

	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<>();
		values.add(id.get());
		values.add(invoice_header_id.get());
		values.add(book_presentation_id.get());
		values.add(quantity.get());
		return values;
	}
}
