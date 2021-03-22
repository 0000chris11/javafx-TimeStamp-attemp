package com.cofii.listeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonAction implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        System.out.println("YOU PRESSED!");
        
    }
    
}
