package id.ac.its.fp.obj;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class HelloWorld extends Application{
  @Override
  public void start(Stage primaryStage) throws Exception {
    Button btn = new Button("Say Hello World");
    btn.setOnAction((e) -> System.out.println("Hello World !"));
    StackPane root = new StackPane();
    root.getChildren().add(btn);
    Scene scene = new Scene(root, 300, 300);
    primaryStage.setTitle("My First Java FX App");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }
}