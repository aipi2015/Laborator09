package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Category extends Model {

    final private SimpleStringProperty id;
    final private SimpleStringProperty name;
    final private SimpleStringProperty description;

    public Category(String id, String name, String description) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public Category(List<String> category) {
        this.id = new SimpleStringProperty(category.get(0));
        this.name = new SimpleStringProperty(category.get(1));
        this.description = new SimpleStringProperty(category.get(2));
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

    @Override
    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(id.get());
        values.add(name.get());
        values.add(description.get());
        return values;
    }
}
