/*
 * Recipe 18-1:  Simple JavaFX Application
 */
package org.javaeerecipes.javafx.recipe18_01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author juneau
 */
public class HelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        final Label lbl = new Label("This will change");

        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl.setText("Hello World");
            }
        });
        
        
        VBox root = new VBox();
        root.getChildren().addAll(lbl, btn);
        //root.getChildren().add(btn);
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
