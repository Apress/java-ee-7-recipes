package org.javaeerecipes.javafx.recipe18_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.TabBuilder;
import javafx.scene.control.TabPaneBuilder;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.stage.Stage;

public class Main extends Application {
    
    BookViewNode bookView = null;

    @Override
    public void start(Stage stage) {
        
       Scene scene = SceneBuilder.create()
     
      .width(800)
      .height(500)
      .root(
        BorderPaneBuilder.create()
          .top(
            HBoxBuilder.create()
              .children(
                LabelBuilder.create()
                  .id("title")
                  .text("Acme Bookstore")
                  .minHeight(2)
                  .build()
              )
              .build()
          )
          .center(
            TabPaneBuilder.create()
              .tabs(
                TabBuilder.create()
                  .content(new BookViewNode())
                  .text("Book Listing")
                  .closable(false)
                  .build(),
                TabBuilder.create()
                  .text("Other Things")
                  .closable(false)
                  .build()
              )
              .build()
          )
          .bottom(
            HBoxBuilder.create()
              .id("footer")
              .children(
                new Label("Acme Bookstore - Java EE 7 Recipes")
              )
              .build()
          )
          .build()
      )
      .build();
       
       
        stage.setTitle("Acme Bookstore");
        stage.setWidth(1400);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.show();
        

    }

    public static void main(String[] args) {
        launch(args);
    }
}