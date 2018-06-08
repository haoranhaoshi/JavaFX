package com.company.Alert;

import com.company.Alert.AlertWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
    Stage stage = new Stage();
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setOnCloseRequest(event -> {//关闭前
            event.consume();//销毁默认操作，即关闭stage，可以靠stage.close();关闭
            System.out.println("You want to close MainWindow!");
        });
        Button button=new Button();
        button.setText("alert");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        Scene scene=new Scene(stackPane,600,300);
        stage.setScene(scene);
        stage.show();
        button.setOnMouseClicked(e->closeWindow());
    }

    private void closeWindow(){
        boolean isClickYes = AlertWindow.display("AlertWindowShow","Close Two Window?Yes or No?");
        System.out.println(isClickYes);
        if(isClickYes){
            stage.close();
        }
    }
}
