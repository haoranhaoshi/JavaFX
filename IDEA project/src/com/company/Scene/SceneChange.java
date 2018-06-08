package com.company.Scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneChange extends Application {
    Button button1,button2;
    Scene scene1,scene2;
    VBox vBox;
    StackPane stackPane;
    public static void main(String[] args) {
        launch(args);//Application.java
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        button1 = new Button("Hello");
        vBox = new VBox();
        vBox.getChildren().add(button1);
        scene1 = new Scene(vBox,200,200);

        button2 = new Button("World");
        stackPane = new StackPane();
        stackPane.getChildren().add(button2);
        scene2 = new Scene(stackPane,300,300);

        primaryStage.setScene(scene1);
        primaryStage.show();

        button1.setOnMouseClicked(e->{
            primaryStage.setScene(scene2);//场景切换
        });

        button2.setOnMouseClicked(e->{
            primaryStage.setScene(scene1);
        });
    }
}
