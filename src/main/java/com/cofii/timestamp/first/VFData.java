package com.cofii.timestamp.first;

import com.cofii.timestamp.data.DATA;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VFData {
    
    private static VFData instance;

    private Stage window = new Stage();//GIVEN FROM star (Application)
    private Scene mainScene;

    private Menu menuOptions = new Menu("_Options");
    private MenuItem menuItemChangeLog = new MenuItem("Change login or DB");
    private MenuItem menuItemShowTable = new MenuItem("Show tables info");
    private CheckMenuItem menuCheckAOT = new CheckMenuItem("Always On Top");
    private MenuItem menuItemSave = new MenuItem("Save Options");

    private Menu menuSelect = new Menu("Select");

    private Menu menuTable = new Menu("_Tables");
    private Menu menuTableOptions = new Menu("Options");
    private CheckMenuItem menuTableCheckClearDeleted = new CheckMenuItem("Clear values when a row is deleted");
    private MenuItem menuTableItemReloadImageC = new MenuItem("Reload current ImageC directory");
    private Menu menuTableChangeDefault = new Menu("Change default table");
    private MenuItem menuTableItemCreate = new MenuItem("Create a Table");
    private MenuItem menuTableItemUpdateThis = new MenuItem("Update this Table");
    private MenuItem menuTableItemDelete = new MenuItem("Delete a Table");
    private MenuItem menuTableItemDeleteThis = new MenuItem("Delete this Table");

    private MenuBar menuBar = new MenuBar(menuOptions, menuSelect, menuTable);
    //CENTER
    private SplitPane splitPane = new SplitPane();

    private Label lbTable = new Label("No table selected");
    private Label[] lbs = new Label[DATA.MAX_COLUMNS];
    private TextField[] tfs = new TextField[DATA.MAX_COLUMNS];
    private Button[] btns = new Button[DATA.MAX_COLUMNS];

    private TableView<ObservableList<String>> table = new TableView<>();
    //BOTTOM
    private Label labelStatus = new Label("Waiting for action...");
    private Button buttonDelete = new Button("Delete");
    private Button buttonFind = new Button("Find");
    private Button buttonUpdate = new Button("Update");
    private Button buttonAdd = new Button("Add");
    //SQL VALUES
    private boolean tableNamesExist = false;
    private boolean tableDefaultExist = false;
    private boolean tableConfigExist = false;

    private VFData(){

    }

    public static VFData getInstance(){
        if(instance == null){
            instance = new VFData();
        }
        return instance;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public Menu getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(Menu menuOptions) {
        this.menuOptions = menuOptions;
    }

    public Menu getMenuSelect() {
        return menuSelect;
    }

    public void setMenuSelect(Menu menuSelect) {
        this.menuSelect = menuSelect;
    }

    public Menu getMenuTable() {
        return menuTable;
    }

    public void setMenuTable(Menu menuTable) {
        this.menuTable = menuTable;
    }

    public MenuItem getMenuItemChangeLog() {
        return menuItemChangeLog;
    }

    public void setMenuItemChangeLog(MenuItem menuItemChangeLog) {
        this.menuItemChangeLog = menuItemChangeLog;
    }

    public MenuItem getMenuItemShowTable() {
        return menuItemShowTable;
    }

    public void setMenuItemShowTable(MenuItem menuItemShowTable) {
        this.menuItemShowTable = menuItemShowTable;
    }

    public CheckMenuItem getMenuCheckAOT() {
        return menuCheckAOT;
    }

    public void setMenuCheckAOT(CheckMenuItem menuCheckAOT) {
        this.menuCheckAOT = menuCheckAOT;
    }

    public MenuItem getMenuItemSave() {
        return menuItemSave;
    }

    public void setMenuItemSave(MenuItem menuItemSave) {
        this.menuItemSave = menuItemSave;
    }

    public Menu getMenuTableOptions() {
        return menuTableOptions;
    }

    public void setMenuTableOptions(Menu menuTableOptions) {
        this.menuTableOptions = menuTableOptions;
    }

    public CheckMenuItem getMenuTableCheckClearDeleted() {
        return menuTableCheckClearDeleted;
    }

    public void setMenuTableCheckClearDeleted(CheckMenuItem menuTableCheckClearDeleted) {
        this.menuTableCheckClearDeleted = menuTableCheckClearDeleted;
    }

    public MenuItem getMenuTableItemReloadImageC() {
        return menuTableItemReloadImageC;
    }

    public void setMenuTableItemReloadImageC(MenuItem menuTableItemReloadImageC) {
        this.menuTableItemReloadImageC = menuTableItemReloadImageC;
    }

    public Menu getMenuTableChangeDefault() {
        return menuTableChangeDefault;
    }

    public void setMenuTableChangeDefault(Menu menuTableChangeDefault) {
        this.menuTableChangeDefault = menuTableChangeDefault;
    }

    public MenuItem getMenuTableItemCreate() {
        return menuTableItemCreate;
    }

    public void setMenuTableItemCreate(MenuItem menuTableItemCreate) {
        this.menuTableItemCreate = menuTableItemCreate;
    }

    public MenuItem getMenuTableItemUpdateThis() {
        return menuTableItemUpdateThis;
    }

    public void setMenuTableItemUpdateThis(MenuItem menuTableItemUpdateThis) {
        this.menuTableItemUpdateThis = menuTableItemUpdateThis;
    }

    public MenuItem getMenuTableItemDelete() {
        return menuTableItemDelete;
    }

    public void setMenuTableItemDelete(MenuItem menuTableItemDelete) {
        this.menuTableItemDelete = menuTableItemDelete;
    }

    public MenuItem getMenuTableItemDeleteThis() {
        return menuTableItemDeleteThis;
    }

    public void setMenuTableItemDeleteThis(MenuItem menuTableItemDeleteThis) {
        this.menuTableItemDeleteThis = menuTableItemDeleteThis;
    }

    public SplitPane getSplitPane() {
        return splitPane;
    }

    public void setSplitPane(SplitPane splitPane) {
        this.splitPane = splitPane;
    }

    public Label getLbTable() {
        return lbTable;
    }

    public void setLbTable(Label lbTable) {
        this.lbTable = lbTable;
    }

    public Label[] getLbs() {
        return lbs;
    }

    public void setLbs(Label[] lbs) {
        this.lbs = lbs;
    }

    public TextField[] getTfs() {
        return tfs;
    }

    public void setTfs(TextField[] tfs) {
        this.tfs = tfs;
    }

    public Button[] getBtns() {
        return btns;
    }

    public void setBtns(Button[] btns) {
        this.btns = btns;
    }

    public TableView<ObservableList<String>> getTable() {
        return table;
    }

    public void setTable(TableView<ObservableList<String>> table) {
        this.table = table;
    }

    public Label getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(Label labelStatus) {
        this.labelStatus = labelStatus;
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(Button buttonDelete) {
        this.buttonDelete = buttonDelete;
    }

    public Button getButtonFind() {
        return buttonFind;
    }

    public void setButtonFind(Button buttonFind) {
        this.buttonFind = buttonFind;
    }

    public Button getButtonUpdate() {
        return buttonUpdate;
    }

    public void setButtonUpdate(Button buttonUpdate) {
        this.buttonUpdate = buttonUpdate;
    }

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(Button buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public boolean isTableNamesExist() {
        return tableNamesExist;
    }

    public void setTableNamesExist(boolean tableNamesExist) {
        this.tableNamesExist = tableNamesExist;
    }

    public boolean isTableDefaultExist() {
        return tableDefaultExist;
    }

    public void setTableDefaultExist(boolean tableDefaultExist) {
        this.tableDefaultExist = tableDefaultExist;
    }

    public boolean isTableConfigExist() {
        return tableConfigExist;
    }

    public void setTableConfigExist(boolean tableConfigExist) {
        this.tableConfigExist = tableConfigExist;
    }

  
}
