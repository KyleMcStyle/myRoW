package kyleuml;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class myMenuBar extends MenuBar
{
    
    CenterPane centerPane;
    
    myMenuBar(CenterPane cp)
    {
        super();
        centerPane = cp;
        Menu file = new Menu("File");
        MenuItem fileNew = new MenuItem("New...");
        MenuItem fileOpen = new MenuItem("Open...");
        MenuItem fileSave = new MenuItem("Save");
        MenuItem fileSaveAs = new MenuItem("Save as...");
        file.getItems().addAll(fileNew, fileOpen, fileSave, fileSaveAs);
        
        Menu edit = new Menu("Edit");
        MenuItem editUndo = new MenuItem("Undo");        
        edit.getItems().add(editUndo);
        
        editUndo.setOnAction(undo);
        
        Menu view = new Menu("View");
        Menu help = new Menu("Help");

        getMenus().addAll(file, edit, view, help);
    }

    EventHandler<ActionEvent> undo = (ActionEvent e) ->
    {
        centerPane.undo();
    };
    
    /*
    EventHandler<KeyEvent> undoHotkey = (KeyEvent e) ->
    {
        if (e.getCode() == KeyCode.Z && e.isControlDown())
        {
            centerPane.undo();
        }
    };
    */
}
