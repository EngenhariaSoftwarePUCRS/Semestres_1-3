import javafx.application.Application;
//import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Basico extends Application {
    private TextField usuario;
    private PasswordField senha;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX - Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setGridLinesVisible(true);
          
        Text scenetitle = new Text("Bem Vindo");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label lbUser = new Label("User:");
        grid.add(lbUser,0,2);
        usuario = new TextField();
        grid.add(usuario,1,2);
        Label lbSenha = new Label("Senha:");
        grid.add(lbSenha,0,3);
        senha = new PasswordField();
        grid.add(senha,1,3);

        Button b = new Button("OK");
        grid.add(b,0,4);
        b.setOnAction(e->{
            System.out.println(usuario.getText());
        });

        

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        //primaryStage.setHeight(1000);
        //primaryStage.setWidth(1000);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
     
    public static void main(String[] args) {
        launch(args);
    }
}