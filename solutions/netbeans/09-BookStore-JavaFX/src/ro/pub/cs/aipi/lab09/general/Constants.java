package ro.pub.cs.aipi.lab09.general;

public interface Constants {

    final public static String APPLICATION_NAME = "BookStore";

    final public static String DATABASE_CONNECTION = "jdbc:mysql://localhost:3306/bookstore";
    final public static String DATABASE_USERNAME = "root";
    final public static String DATABASE_PASSWORD = "StudentAipi2015$";
    final public static String DATABASE_NAME = "bookstore";

    final public static boolean DEBUG = true;

    final public static int DEFAULT_COMBOBOX_WIDTH = 200;
    final public static int DEFAULT_TEXTFIELD_WIDTH = 200;

    final public static String RESOURCES_PATH = "/resources";

    final public static String FXML_PATH = RESOURCES_PATH + "/fxmls";
    final public static String AUTHENTICATION_FXML = FXML_PATH + "/authentication.fxml";
    final public static String CONTAINER_FXML = FXML_PATH + "/container.fxml";
    final public static String TABLE_MANAGEMENT_FXML = FXML_PATH + "/tablemanagement.fxml";
    final public static String DIALOG_FXML = FXML_PATH + "/dialog.fxml";

    final public static String IMAGE_PATH = RESOURCES_PATH + "/images";
    final public static String ICON_FILE_NAME = IMAGE_PATH + "/icon.png";

    final public static String ABOUT_WINDOW_TITLE = "About";
    final public static String ABOUT_ICON_LOCATION = IMAGE_PATH + "/about.png";
    final public static String ABOUT_MESSAGE_CONTENT = "Librarie Virtuala\nv2.0\n\n(c) Aplicatii Integrate pentru Intreprinderi 2015\nhttp://aipi2015.andreirosucojocaru.ro";

    final public static String ERROR_WINDOW_TITLE = "Error";
    final public static String ERROR_ICON_LOCATION = IMAGE_PATH + "/error.png";
    final public static String ERROR_MESSAGE_CONTENT = "You must complete all fields\nin order to perform this operation!";

    final public static String AUTHOR_TABLE_NAME = "author";
    final public static String BOOK_TABLE_NAME = "book";
    final public static String BOOK_PRESENTATION_TABLE_NAME = "book_presentation";
    final public static String CATEGORY_TABLE_NAME = "category";
    final public static String CATEGORY_CONTENT_TABLE_NAME = "category_content";
    final public static String COLLECTION_TABLE_NAME = "collection";
    final public static String COUNTRY_TABLE_NAME = "country";
    final public static String FORMAT_TABLE_NAME = "format";
    final public static String INVOICE_HEADER_TABLE_NAME = "invoice_header";
    final public static String INVOICE_LINE_TABLE_NAME = "invoice_line";
    final public static String LANGUAGE_TABLE_NAME = "language";
    final public static String PUBLISHING_HOUSE_TABLE_NAME = "publishing_house";
    final public static String SUPPLY_ORDER_HEADER_TABLE_NAME = "supply_order_header";
    final public static String SUPPLY_ORDER_LINE_TABLE_NAME = "supply_order_line";
    final public static String USER_TABLE_NAME = "user";
    final public static String WRITER_TABLE_NAME = "writer";

    final public static String USER_TYPE_ATTRIBUTE = "type";
    final public static String USER_TYPE_ADMINISTRATOR_VALUE = "administrator";

    final public static String ERROR_USERNAME_PASSWORD = "Either username or password are incorrect!";
    final public static String ERROR_ACCESS_NOT_ALLOWED = "You don't have enough rights to access the application!";
}
