
package org.javaeerecipes.javafx.recipe18_04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.javaeerecipes.javafx.entity.Book;
import org.javaeerecipes.javafx.session.BookFacade;

/**
 * FXML Controller class
 *
 * @author juneau
 */
public class AcmeBookstoreMainController implements Initializable {
    
    private BookFacade ejbFacade = new BookFacade();
   
    private ObservableList<Book> data;
    @FXML private TableView<Book> tableView;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setData(FXCollections.observableArrayList(ejbFacade.findAllBooks()));
        
        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(
            new PropertyValueFactory<Book,String>("title")
        );
 
        TableColumn descCol = new TableColumn("Description");
        descCol.setCellValueFactory(
            new PropertyValueFactory<Book,String>("description")
        );
 
        tableView.setItems(data);
     
        tableView.getColumns().addAll(titleCol, descCol);
    }   

    /**
     * @return the data
     */
    public ObservableList<Book> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ObservableList<Book> data) {
        this.data = data;
    }
    
    
    

}
