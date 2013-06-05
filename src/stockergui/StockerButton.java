/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockergui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 *
 * @author Chris
 */
public class StockerButton extends Button {
    
    
    public StockerButton(String text, Font ft) {
        super(text);
        
        this.setMaxWidth(Double.MAX_VALUE);
        this.setStyle("-fx-background-color:#00B2EE; -fx-font-weight:bold; -fx-background-radius: 0; -fx-background-insets: 0;");
        this.setFont(ft);
        

        
    }
    
}
