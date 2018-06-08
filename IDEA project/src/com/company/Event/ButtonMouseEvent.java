package com.company.Event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ButtonMouseEvent implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println("You click a button by MyMouseEvent!");
    }
}
