package kyleuml;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class myLine extends Line {
    
    CenterPane centerPane;
    SidePanel sidePanel;
    double x1, x2, y1, y2;
    
    public myLine(CenterPane cp, SidePanel sp, double mx1, double my1, double mx2, double my2)
    {
        super(mx1, my1, mx2, my2);
        centerPane = cp;
        sidePanel = sp;
        setStrokeWidth(3);
        setOnMouseClicked(delete);
    }
    
    EventHandler<MouseEvent> delete = (MouseEvent e) ->
    {
        if (sidePanel.deleteBtnToggled())
        {
            centerPane.getChildren().remove(e.getSource());
        }        
    };
    
}
