package com.cofii.timestamp.first;

import com.cofii.timestamp.data.DATA;
import com.cofii.timestamp.data.SQL;
import com.cofii.timestamp.data.SQLStatements;
import com.cofii.timestamp.first.querys.ConnectionError;
import com.cofii.timestamp.first.querys.SelectTablesFQ;
import com.cofii.timestamp.login.VLData;
import com.cofii2.custom.LKCustom2;
import com.cofii2.mysql.Connect;
import com.cofii2.mysql.MSQLP;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class VF {

    private VFData dt = VFData.getInstance();

    private void menuItemsConfig() {
        // OPTIONS
        dt.getMenuOptions().getItems().addAll(dt.getMenuItemChangeLog(), dt.getMenuItemShowTable(),
                new SeparatorMenuItem(), dt.getMenuCheckAOT(), new SeparatorMenuItem(), dt.getMenuItemSave());

        dt.getMenuCheckAOT().setSelected(true);
        // TABLE
        dt.getMenuTable().getItems().addAll(dt.getMenuTableOptions(), new SeparatorMenuItem(),
                dt.getMenuTableChangeDefault(), new SeparatorMenuItem(), dt.getMenuTableItemCreate(),
                dt.getMenuTableItemUpdateThis(), dt.getMenuTableItemDelete(), dt.getMenuTableItemDeleteThis());
        // TABLE-OPTIONS
        dt.getMenuTableOptions().getItems().addAll(dt.getMenuTableCheckClearDeleted(), new SeparatorMenuItem(),
                dt.getMenuTableItemReloadImageC());

        dt.getMenuTableItemReloadImageC().setDisable(true);
    }

    private void gridConfig() {
        for (int a = 0; a < DATA.MAX_COLUMNS; a++) {
            dt.getLbs()[a] = new Label("Column " + (a + 1));
            dt.getTfs()[a] = new TextField();
            dt.getBtns()[a] = new Button();

            dt.getLbs()[a].setMinWidth(80);
            dt.getTfs()[a].setPrefWidth(Short.MAX_VALUE);
            dt.getTfs()[a].setMinHeight(26);
            dt.getBtns()[a].setMinWidth(20);
        }
    }

    private void splitPaneConfig() {
        // LEFT
        VBox leftLayout = new VBox(12);
        leftLayout.setPadding(new Insets(6, 8, 8, 8));
        // dt.getLbTable().setBackground(Color.BLACK);BAK LEARN
        dt.getLbTable().setFont(new Font(16));

        GridPane subLeftLayout = new GridPane();

        subLeftLayout.setVgap(10);
        subLeftLayout.setHgap(8);
        for (int a = 0; a < DATA.MAX_COLUMNS; a++) {
            subLeftLayout.add(dt.getLbs()[a], 0, a);
            subLeftLayout.add(dt.getTfs()[a], 1, a);
            subLeftLayout.add(dt.getBtns()[a], 2, a);
        }

        leftLayout.getChildren().addAll(dt.getLbTable(), subLeftLayout);
        // RIGHT
        TableColumn<ObservableList<String>, String> columnId = new TableColumn<>("id");
        TableColumn<ObservableList<String>, String> columnName = new TableColumn<>("Name");
        TableColumn<ObservableList<String>, String> columnLastName = new TableColumn<>("Last Name");

        columnId.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().get(0)));
        columnName.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().get(1)));
        columnLastName.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue().get(2)));

        ObservableList<ObservableList<String>> items = FXCollections.observableArrayList();
        ObservableList<String> colIdItems = FXCollections.observableArrayList();
        colIdItems.addAll("1", "Pinkie", "Pie");
        ObservableList<String> colNameItems = FXCollections.observableArrayList();
        colNameItems.addAll("2", "Inaho", "Misora");
        ObservableList<String> colLastNameItems = FXCollections.observableArrayList();
        colLastNameItems.addAll("3", "Usagi", "Tsukino");
        items.addAll(colIdItems, colNameItems, colLastNameItems);
        dt.getTable().setItems(items);

        dt.getTable().getColumns().addAll(columnId, columnName, columnLastName);
        dt.getSplitPane().getItems().addAll(leftLayout, dt.getTable());

        dt.getSplitPane().setDividerPositions(0.3);
    }

    private void statusConfig(BorderPane layout) {
        HBox bottom = new HBox(10);
        bottom.setPadding(new Insets(6, 6, 6, 6));
        bottom.getChildren().addAll(dt.getLabelStatus(), dt.getButtonDelete(), dt.getButtonFind(), dt.getButtonUpdate(),
                dt.getButtonAdd());

        dt.getButtonDelete().setMinWidth(120);
        dt.getButtonFind().setMinWidth(120);
        dt.getButtonUpdate().setMinWidth(120);
        dt.getButtonAdd().setMinWidth(120);
        dt.getLabelStatus().setPrefWidth(Short.MAX_VALUE);
        HBox.setHgrow(dt.getLabelStatus(), Priority.ALWAYS);

        dt.getLabelStatus().setFont(new Font(14));

        layout.setBottom(bottom);
    }

    private boolean intiQuerys() {
        MSQLP ms = new MSQLP(new Connect(SQL.getUrl(), SQL.getUser(), SQL.getPassword()), new ConnectionError());
        if (!SQL.isWrongPassword()) {
            dt.getLbTable().setText(SQL.getDatabase() + " - " + dt.getLbTable().getText());
            ms.selectTables(new SelectTablesFQ());

            // TEST FOR A NEW DATABASE
            if (!dt.isTableNamesExist()) {
                boolean testTableNames = ms.executeUpdate(SQLStatements.CREATE_TABLE_NAMES);
                System.out.println("table_names has been created?: " + testTableNames);
            }

            if (!dt.isTableDefaultExist()) {
                ms.executeUpdate(SQLStatements.CREATE_TABLE_DEFAULT);
            }

            if (!dt.isTableConfigExist()) {
                boolean testTableConfig = ms.executeUpdate(SQLStatements.CREATE_TABLE_CONFIG);
                System.out.println("table_config has been created?: " + testTableConfig);
            }

            ms.close();

            return true;
        } else {
            return false;
        }
    }

    public VF() {
        if (intiQuerys()) {//IF THE CONNECTION IS WORKING
            //------------------------------------------------
            BorderPane layout = new BorderPane();
            layout.setTop(dt.getMenuBar());
            layout.setCenter(dt.getSplitPane());

            menuItemsConfig();
            gridConfig();
            splitPaneConfig();
            statusConfig(layout);

            dt.setMainScene(new Scene(layout, LKCustom2.MAIN_FRAME_SIZE.width, LKCustom2.MAIN_FRAME_SIZE.height));

            VLData.getInstance().getWindow().close();
            dt.getWindow().setScene(dt.getMainScene());
            dt.getWindow().show();
        }
    }

}
