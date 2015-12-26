package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Book extends Model {

    final private SimpleStringProperty id;
    final private SimpleStringProperty title;
    final private SimpleStringProperty subtitle;
    final private SimpleStringProperty description;
    final private SimpleStringProperty edition;
    final private SimpleStringProperty printing_year;
    final private SimpleStringProperty collection_id;

    public Book(String id, String title, String subtitle, String description, String edition, String printing_year, String collection_id) {
        this.id = new SimpleStringProperty(id);
        this.title = new SimpleStringProperty(title);
        this.subtitle = new SimpleStringProperty(subtitle);
        this.description = new SimpleStringProperty(description);
        this.edition = new SimpleStringProperty(edition);
        this.printing_year = new SimpleStringProperty(printing_year);
        this.collection_id = new SimpleStringProperty(collection_id);
    }

    public Book(List<String> book) {
        this.id = new SimpleStringProperty(book.get(0));
        this.title = new SimpleStringProperty(book.get(1));
        this.subtitle = new SimpleStringProperty(book.get(2));
        this.description = new SimpleStringProperty(book.get(3));
        this.edition = new SimpleStringProperty(book.get(4));
        this.printing_year = new SimpleStringProperty(book.get(5));
        this.collection_id = new SimpleStringProperty(book.get(6));
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getSubtitle() {
        return subtitle.get();
    }

    public void setSubtitle(String subtitle) {
        this.subtitle.set(subtitle);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getEdition() {
        return edition.get();
    }

    public void setEdition(String edition) {
        this.edition.set(edition);
    }

    public String getPrinting_year() {
        return printing_year.get();
    }

    public void setPrinting_year(String printing_year) {
        this.printing_year.set(printing_year);
    }

    public String getCollection_id() {
        return collection_id.get();
    }

    public void setCollection_id(String collection_id) {
        this.collection_id.set(collection_id);
    }

    @Override
    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(id.get());
        values.add(title.get());
        values.add(subtitle.get());
        values.add(description.get());
        values.add(edition.get());
        values.add(printing_year.get());
        values.add(collection_id.get());
        return values;
    }
}
