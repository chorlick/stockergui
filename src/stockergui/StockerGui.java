/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockergui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Chris
 */
public class StockerGui extends Application {

    private double yOffset = 0;
    private double xOffset = 0;

    @Override
    public void start(final Stage primaryStage) {
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Stocker");
        primaryStage.initStyle(StageStyle.TRANSPARENT);

       root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        Scene scene = new Scene(root, 1200, 650, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();

        Rectangle r = new Rectangle(5, 5, primaryStage.getWidth() - 10, primaryStage.getHeight() - 10);
        r.setFill(Color.WHITE);
        r.setEffect(new DropShadow());
        root.getChildren().add(r);   
        
        
        Font header_font = new Font(java.awt.Font.SANS_SERIF, 24);
        Font label_font = new Font(java.awt.Font.SANS_SERIF, 16);
        
        
        HBox hbox_top = new HBox();
        root.setTop(hbox_top);
        hbox_top.setStyle("-fx-padding:20px;");
        hbox_top.getChildren().add(new Text("Top thing"));
        
        VBox vbox_center = new VBox();
        root.setCenter(vbox_center);
        vbox_center.setPrefWidth(600);
        
        vbox_center.getChildren().add(new Text("Center thing"));
        
        VBox vbox_right = new VBox();
        root.setRight(vbox_right);
        vbox_right.setPrefWidth(300);
        vbox_right.getChildren().add(new Text("Right thing"));
        
        
        VBox vbox_left = new VBox();
        root.setLeft(vbox_left);
        vbox_left.setStyle("-fx-padding:20px; ");
        
        Text label = new Text("symbols");
        vbox_left.getChildren().add(label);
        vbox_left.setPrefWidth(300);
        
        Text icons_label = new Text("icons");
        icons_label.setFont(header_font);
        
        
        
        StockerButton first_symbol = new StockerButton("Test", label_font);
        

        
 
        
        label.setFont(header_font);    
        vbox_left.getChildren().add(first_symbol);
        vbox_left.getChildren().add(icons_label);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
