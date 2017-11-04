
package kyleuml;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class ClassBox extends VBox {
    
    //Must be same width as myTextArea
    double width = 100;
    double prefHeight = 150;
    //double min_height = 12;

    double orgSceneX, orgSceneY;
    double orgX, orgY;
    
    SidePanel sidePanel;
    CenterPane centerPane;
    
    public ClassBox(CenterPane cp, SidePanel sp, double mouseX, double mouseY)
    {
        super();
        centerPane = cp;
        sidePanel = sp;
        setMaxWidth(width);
        //setPrefHeight(prefHeight);
        setLayoutX(mouseX - width / 2);
        setLayoutY(mouseY - prefHeight / 2); 
        checkBounds();
        
        Rectangle rect = new Rectangle(width, 10);
        myTextArea textTitle = new myTextArea("Title");
        myTextArea textDataMembers = new myTextArea("Data Members");
        myTextArea textMethods = new myTextArea("Methods");
        //System.out.println(textTitle.getFont());

        setOnMousePressed(select);
        setOnMouseDragged(move);
        setOnMouseReleased(release);
        setOnMouseClicked(delete);
        
        getChildren().addAll(rect, textTitle, textDataMembers, textMethods);
    }
    
    
    public void printCoords()
    {
        System.out.println(getLayoutX() + ", " + getLayoutY());
    }
    
    public void checkBounds()
    {
        if (getLayoutX() < 0)
        {
            setLayoutX(0);
        }
        if (getLayoutY() < 0)
        {
            setLayoutY(0);
        }
    }
    
    
    EventHandler<MouseEvent> select = (MouseEvent e) ->
    {
        if (sidePanel.selectBtnToggled())
        {
            orgSceneX = e.getSceneX();
            orgSceneY = e.getSceneY();
            orgX = ((ClassBox)(e.getSource())).getLayoutX();
            orgY = ((ClassBox)(e.getSource())).getLayoutY();
        } 
    };
    
    EventHandler<MouseEvent> move = (MouseEvent e) ->
    {
        if (sidePanel.selectBtnToggled())
        {
            double offsetX = e.getSceneX() - orgSceneX;
            double offsetY = e.getSceneY() - orgSceneY;
            double newX = orgX + offsetX;
            double newY = orgY + offsetY;

            ((ClassBox)(e.getSource())).setLayoutX(newX);
            ((ClassBox)(e.getSource())).setLayoutY(newY);
        } 
    };

    EventHandler<MouseEvent> release = (MouseEvent e) ->
    {
        if (sidePanel.selectBtnToggled())
        {
            ((ClassBox)e.getSource()).checkBounds();
            ((ClassBox)e.getSource()).toFront();
        }
    };
    
    EventHandler<MouseEvent> delete = (MouseEvent e) ->
    {
        if (sidePanel.deleteBtnToggled())
        {
            centerPane.getChildren().remove(e.getSource());
        }
    };
    
}
