package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class SupplyOrderLine extends Model {

    final private SimpleStringProperty id;
    final private SimpleStringProperty supply_order_header_id;
    final private SimpleStringProperty book_presentation_id;
    final private SimpleStringProperty quantity;

    public SupplyOrderLine(String id, String supply_order_header_id, String book_presentation_id, String quantity) {
        this.id = new SimpleStringProperty(id);
        this.supply_order_header_id = new SimpleStringProperty(supply_order_header_id);
        this.book_presentation_id = new SimpleStringProperty(book_presentation_id);
        this.quantity = new SimpleStringProperty(quantity);
    }

    public SupplyOrderLine(List<String> supplyOrderLine) {
        this.id = new SimpleStringProperty(supplyOrderLine.get(0));
        this.supply_order_header_id = new SimpleStringProperty(supplyOrderLine.get(1));
        this.book_presentation_id = new SimpleStringProperty(supplyOrderLine.get(2));
        this.quantity = new SimpleStringProperty(supplyOrderLine.get(3));
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getSupply_order_header_id() {
        return supply_order_header_id.get();
    }

    public void setSupply_order_header_id(String supply_order_header_id) {
        this.supply_order_header_id.set(supply_order_header_id);
    }

    public String getBook_presentation_id() {
        return book_presentation_id.get();
    }

    public void setBook_presentation_id(String book_presentation_id) {
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
        values.add(supply_order_header_id.get());
        values.add(book_presentation_id.get());
        values.add(quantity.get());
        return values;
    }
}
