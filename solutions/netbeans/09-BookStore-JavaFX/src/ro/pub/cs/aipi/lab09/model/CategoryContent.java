package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class CategoryContent extends Model {

    final private SimpleStringProperty id;
    final private SimpleStringProperty book_id;
    final private SimpleStringProperty category_id;

    public CategoryContent(String id, String book_id, String category_id) {
        this.id = new SimpleStringProperty(id);
        this.book_id = new SimpleStringProperty(book_id);
        this.category_id = new SimpleStringProperty(category_id);
    }

    public CategoryContent(List<String> author) {
        this.id = new SimpleStringProperty(author.get(0));
        this.book_id = new SimpleStringProperty(author.get(1));
        this.category_id = new SimpleStringProperty(author.get(2));
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getBook_id() {
        return book_id.get();
    }

    public void setBook_id(String book_id) {
        this.book_id.set(book_id);
    }

    public String getCategory_id() {
        return category_id.get();
    }

    public void setCategory_id(String category_id) {
        this.category_id.set(category_id);
    }

    @Override
    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(id.get());
        values.add(book_id.get());
        values.add(category_id.get());
        return values;
    }
}
