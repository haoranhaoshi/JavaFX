package com.company.Event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventUse extends Application implements EventHandler<MouseEvent> {
    Button button;

    public static void main(String[] args) {
        launch(args);//Application.java提供，执行start方法
    }

    @Override
    public void start(Stage primaryStage) throws Exception {//extends Application
        button = new Button("Hello");//等于button.setText("Hello");
        button.setOnMouseClicked(this);//方法一
        button.setOnMouseClicked(new ButtonMouseEvent());//方法二
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {//方法三
            @Override
            public void handle(MouseEvent event) {
                System.out.println("You clicked1 a button by new EventHandler!");
            }
        });
        button.setOnMouseClicked(e->System.out.println("You clicked a button by e!"));//方法四（1）
        button.setOnMouseClicked(e->{//方法四（2）
            System.out.println("You clicked a button by e!");
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 300, 300);
        scene.setOnMousePressed(this);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == button) {
            System.out.println("You clicked a button by Main!");
        } else {
            System.out.println("You clicked a scene by Main!");
        }

    }
}
