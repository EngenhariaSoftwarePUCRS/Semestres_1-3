import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TextAreaDemo extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Borders");
        Group root = new Group();
        //Scene scene = new Scene(root, 600, 330, Color.WHITE);
        Scene scene = new Scene(root);
        
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
        final TextArea texto = new TextArea();
        texto.setPrefRowCount(10);
        texto.setPrefColumnCount(100);
        texto.setWrapText(true);
        texto.setPrefWidth(150);
        GridPane.setHalignment(texto, HPos.CENTER);
        gridpane.add(texto, 0, 1);
        
        for(int i=0;i<15;i++){
            texto.appendText("Linha"+i+"\n");
        }
        
        root.getChildren().add(gridpane);        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}