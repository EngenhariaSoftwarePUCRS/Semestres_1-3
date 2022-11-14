import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Welcome extends Application {
    private TextField userTextField;
    private PasswordField pwBox;
    private Text actiontarget;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX - Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setGridLinesVisible(true);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btnSigIn = new Button("Sign in");
        Button btnCancel = new Button("Cancel");
        HBox hbBtn = new HBox(10);
        //VBox hbBtn = new VBox(10);
        hbBtn.setAlignment(Pos.BASELINE_CENTER);
        hbBtn.getChildren().add(btnSigIn);
        hbBtn.getChildren().add(btnCancel);
        grid.add(hbBtn, 1, 4);

        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btnSigIn.setOnAction(e->this.trataBotaoSignIn(e));

        btnCancel.setOnAction(e->System.exit(0));
        /* 
        btnCancel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
                
            }
        } );
        */

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public void trataBotaoSignIn(ActionEvent e) {
        actiontarget.setFill(Color.FIREBRICK);
        actiontarget.setText("Sign in button pressed");
        
        Alert msgBox = new Alert(AlertType.INFORMATION);
        msgBox.setHeaderText("Botao acionado");
        String str = userTextField.getText() + "\n"+
                     pwBox.getText();
        msgBox.setContentText(str);
        msgBox.showAndWait();
        actiontarget.setText(" ");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}