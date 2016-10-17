package org.javaeerecipes.javafx.recipe18_02;

import org.javaeerecipes.javafx.entity.Book;
import org.javaeerecipes.javafx.session.BookFacade;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class BookView extends Application {
    private BookFacade ejbFacade = new BookFacade();
    
    private TableView<Book> table = new TableView<Book>();
    
    private final ObservableList<Book> data = 
        FXCollections.observableArrayList(ejbFacade.findAllBooks());
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Acme Bookstore Book Selection");
        stage.setWidth(1400);
        stage.setHeight(500);
 
        final Label label = new Label("Acme Bookstore Book Selection");
        label.setFont(new Font("Arial", 20));
 
        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(
            new PropertyValueFactory<Book,String>("title")
        );
 
        TableColumn descCol = new TableColumn("Description");
        descCol.setCellValueFactory(
            new PropertyValueFactory<Book,String>("description")
        );
 
       
 
        table.setItems(data);
     
        table.getColumns().addAll(titleCol, descCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, table);
        vbox.setPadding(new Insets(10, 0, 0, 10));
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}
