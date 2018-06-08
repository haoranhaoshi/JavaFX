package com.company.Alert;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
    public static boolean isClickYes;

    public static boolean display(String title, String message) {
        Button buttonYes = new Button();
        buttonYes.setText("Yes");
        Button buttonNo = new Button("No");
        Label label = new Label();
        label.setText(message);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(buttonYes, buttonNo, label);//添加多个
        Scene scene = new Scene(vBox, 200, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        buttonYes.setOnMouseClicked(e -> {
            isClickYes = true;
            stage.close();
        });
        buttonNo.setOnMouseClicked(e -> {
            isClickYes = false;
            stage.close();
        });

        stage.showAndWait();//不调用stage.close();无法执行之后的代码

        return isClickYes;
    }
}
