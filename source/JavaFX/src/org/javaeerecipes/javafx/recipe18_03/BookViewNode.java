package org.javaeerecipes.javafx.recipe18_03;

import org.javaeerecipes.javafx.entity.Book;
import org.javaeerecipes.javafx.session.BookFacade;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
 
public final class BookViewNode extends VBox {
    private BookFacade ejbFacade = new BookFacade();
    
    private TableView<Book> table = new TableView<>();
    
    private final ObservableList<Book> data = 
        FXCollections.observableArrayList(ejbFacade.findAllBooks());
    
    public BookViewNode(){
        build();
    }
   

    public void build() {
 
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
 
        
        this.setSpacing(5);
        this.getChildren().addAll(label, table);
        this.setPadding(new Insets(10, 0, 0, 10));

    }
  
}
