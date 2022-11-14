import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class PopUpSample extends Application{
   private Button btnscene1, btnscene2;
   private Label lblscene1, lblscene2;
   private FlowPane pane1, pane2;
   private Scene scene1, scene2;
   private Stage newStage;
// private Stage thestage;
   
   @Override
   public void start(Stage primaryStage) {
//      thestage=primaryStage; //can now use the stage in other methods
                               //make things to put on panes
        btnscene1=new Button("Click to go to Other Scene");
        btnscene2=new Button("Click to go back to First Scene");
        btnscene1.setOnAction(e->trataBotao1(e));
        btnscene2.setOnAction(e->trataBotao2(e));
        lblscene1=new Label("Scene 1");
        lblscene2=new Label("Scene 2");
        
        //make 2 Panes
        pane1=new FlowPane();
        pane2=new FlowPane();
        pane1.setHgap(20);
        pane2.setVgap(10);
        //set background color of each Pane
        pane1.setStyle("-fx-background-color:tan;-fx-padding:10px;");
        pane2.setStyle("-fx-background-color:red;-fx-padding:10px;");
        //add everything to panes
        pane1.getChildren().addAll(lblscene1, btnscene1);
        pane2.getChildren().addAll(lblscene2, btnscene2);
        
        //make 2 scenes from 2 panes
        scene1 = new Scene(pane1, 200, 100);
        scene2 = new Scene(pane2);
        //make another stage for scene2
        newStage = new Stage();
        newStage.setScene(scene2);
        //tell stage it is meannt to pop-up (Modal)
        //newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Pop up window");
        //rest of code -
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene1);
        primaryStage.setMinWidth(300);
        primaryStage.show();
   }
    
   public void trataBotao1(ActionEvent e){
        newStage.showAndWait();
        //newStage.show();
   }

   public void trataBotao2(ActionEvent e){
        newStage.close();
   }
   
   public static void main(String[] args) {
        Application.launch(args);
   }   
}