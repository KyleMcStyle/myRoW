package kyleuml;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class SidePanel extends VBox
{
    ToggleGroup tg;
    ObservableList<Toggle> toggles;

    
    SidePanel()
    {
        super();
        setPadding(new Insets(10));
        setSpacing(10);
        tg = new ToggleGroup();
        
        //0
        ToggleButton selectBtn = new ToggleButton("Select");
        initialize(selectBtn);
        
        //1
        ToggleButton classBoxBtn = new ToggleButton("Class Box");
        initialize(classBoxBtn);
        
        //2
        ToggleButton lineBtn = new ToggleButton("Line");
        initialize(lineBtn);
        
        //3
        ToggleButton deleteBtn = new ToggleButton("Delete");
        initialize(deleteBtn);
        
        getChildren().addAll(selectBtn, classBoxBtn, lineBtn, deleteBtn);
        toggles = tg.getToggles();
    }
    
    private void initialize(ToggleButton x){
        x.setPrefSize(80, 20);
        x.setToggleGroup(tg);
    }

    public boolean selectBtnToggled()
    {
        return toggles.get(0).isSelected();
    }
    
    public boolean classBoxBtnToggled()
    {
        return toggles.get(1).isSelected();
    }
    
    public boolean lineBtnToggled()
    {
        return toggles.get(2).isSelected();
    }
    
    public boolean deleteBtnToggled()
    {
        return toggles.get(3).isSelected();
    }
   
    
}
