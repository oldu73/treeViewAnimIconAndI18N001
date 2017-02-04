package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class Main extends Application {

    private TreeView<String> treeView;

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();

        controller = fxmlLoader.getController();
        controller.setTreeView(treeView);
        controller.subInitialize();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
