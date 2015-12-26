package ro.pub.cs.aipi.lab09.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class BookPresentation extends Model {

    final private SimpleStringProperty id;
    final private SimpleStringProperty isbn;
    final private SimpleStringProperty book_id;
    final private SimpleStringProperty format_id;
    final private SimpleStringProperty language_id;
    final private SimpleStringProperty price;
    final private SimpleStringProperty stockpile;

    public BookPresentation(String id, String isbn, String book_id, String format_id, String language_id, String price, String stockpile) {
        this.id = new SimpleStringProperty(id);
        this.isbn = new SimpleStringProperty(isbn);
        this.book_id = new SimpleStringProperty(book_id);
        this.format_id = new SimpleStringProperty(format_id);
        this.language_id = new SimpleStringProperty(language_id);
        this.price = new SimpleStringProperty(price);
        this.stockpile = new SimpleStringProperty(stockpile);
    }

    public BookPresentation(List<String> bookPresentation) {
        this.id = new SimpleStringProperty(bookPresentation.get(0));
        this.isbn = new SimpleStringProperty(bookPresentation.get(1));
        this.book_id = new SimpleStringProperty(bookPresentation.get(2));
        this.format_id = new SimpleStringProperty(bookPresentation.get(3));
        this.language_id = new SimpleStringProperty(bookPresentation.get(4));
        this.price = new SimpleStringProperty(bookPresentation.get(5));
        this.stockpile = new SimpleStringProperty(bookPresentation.get(6));
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public String getBook_id() {
        return book_id.get();
    }

    public void setBook_id(String book_id) {
        this.book_id.set(book_id);
    }

    public String getFormat_id() {
        return format_id.get();
    }

    public void setFormat_id(String format_id) {
        this.format_id.set(format_id);
    }

    public String getLanguage_id() {
        return language_id.get();
    }

    public void setLanguage_id(String language_id) {
        this.language_id.set(language_id);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getStockpile() {
        return stockpile.get();
    }

    public void setStockpile(String stockpile) {
        this.stockpile.set(stockpile);
    }

    @Override
    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(id.get());
        values.add(isbn.get());
        values.add(book_id.get());
        values.add(format_id.get());
        values.add(language_id.get());
        values.add(price.get());
        values.add(stockpile.get());
        return values;
    }
}
