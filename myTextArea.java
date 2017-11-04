
package kyleuml;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class myTextArea extends TextArea {
    
    double width = 100;
    int rows;
    double scrolltop;
    Rectangle box;
    
    public myTextArea(String s)
    {
        super(s);
        setWrapText(true);
        setMaxWidth(width);
        scrolltop = 0;
        rows = 1;
        setPrefRowCount(rows);
        setOnKeyPressed(keypress);
        
        
        //probably can't be bigger than parent??
        box = new Rectangle(getWidth() + 10, getHeight() + 10);
        getChildren().add(box);
        
    }
    
    EventHandler<KeyEvent> keypress = (KeyEvent e) ->
    {
        if (getScrollTop() != scrolltop)
        {
            scrolltop = getScrollTop();
            if (scrolltop != 0)
            {
                setPrefRowCount(++rows);
            }
        }
        System.out.println(scrolltop);
    };
}
