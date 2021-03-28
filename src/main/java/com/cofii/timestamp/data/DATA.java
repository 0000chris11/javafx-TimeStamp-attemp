package com.cofii.timestamp.data;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class DATA {

    public static final int MAX_COLUMNS = 8;

    public static final Background BG_COLOR = new Background(
        new BackgroundFill(Color.BLACK, null, null));
        public static final Background BG_COLOR_COMP = new Background(
            new BackgroundFill(Color.rgb(51, 51, 51), null, null));

    private DATA() {
    }
}
