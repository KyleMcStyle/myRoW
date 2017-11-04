package kyleuml;

import java.util.Stack;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CenterPane extends Pane{
    
    SidePanel sidePanel;
    double x, y;
    Stack stack;
    
    
    CenterPane(SidePanel sidepanel)
    {
        super();  
        stack = new Stack();
        x = 0; y = 0;
        sidePanel = sidepanel;
        setStyle("-fx-background-color: white;");
        BorderPane.setMargin(this, new Insets(10, 0, 0, 10)); 
        setOnMouseClicked(creatClassBox);
        setOnMousePressed(getCoords);
        setOnMouseReleased(drawLine);
    }
    
    public void undo()
    {
        getChildren().remove(stack.pop());
    }
    
    EventHandler<MouseEvent> creatClassBox = (MouseEvent e) ->
    {
        if(sidePanel.classBoxBtnToggled())
        {
            //both objects have access to cp and sp for togglebuttons and click events
            ClassBox box = new ClassBox(this, sidePanel, e.getX(), e.getY());
            stack.push(box);
            getChildren().add(box);
        }
    };  
    
    EventHandler<MouseEvent> getCoords = (MouseEvent e) ->
    {
        if (sidePanel.lineBtnToggled())
        {
            x = e.getX();
            y = e.getY();
        }
    };
    
    EventHandler<MouseEvent> drawLine = (MouseEvent e) ->
    {
        if (sidePanel.lineBtnToggled())
        {
            myLine line = new myLine(this, sidePanel, x, y, e.getX(), e.getY());
            stack.push(line);
            getChildren().add(line);
        }
    };  
    
}
