package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class Controller {

    private TreeView<String> treeView;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button animateButton;

    @FXML
    private Button quiteButton;

    private Image animateImage, quiteImage;
    private ImageView animateImageView, quiteImageView;

    public void setTreeView(TreeView<String> treeView) {
        this.treeView = treeView;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    public void subInitialize() {

        initImages();

        if (treeView == null) {
            System.out.println("treeView is null!");
            treeView = initTreeView();
        } else {
            System.out.println("treeView is not null!");
        }

        borderPane.setLeft(treeView);

    }

    @FXML
    private void handleAnimate() {

        treeView.getRoot().setGraphic(animateImageView);

        //TODO change root node text(..) and style to italic

    }

    @FXML
    private void handleQuite() {

        treeView.getRoot().setGraphic(quiteImageView);

    }

    private void initImages() {

        //Image image = new Image("sample/loadingGray001.gif");
        //Image image = new Image("sample/networkBase001.png");

        animateImage = new Image("sample/loadingGray001.gif");
        quiteImage = new Image("sample/network001.png");

        animateImageView = new ImageView(animateImage);
        quiteImageView = new ImageView(quiteImage);

        animateImageView.setFitHeight(16);
        animateImageView.setFitWidth(16);

        quiteImageView.setFitHeight(16);
        quiteImageView.setFitWidth(16);

    }

    private TreeView<String> initTreeView() {

        ArrayList<TreeItem> cars = new ArrayList<>();

        TreeItem ferrari = new TreeItem("Ferrari");
        TreeItem porsche = new TreeItem("Porsche");
        TreeItem ford = new TreeItem("Ford");
        TreeItem mercedes = new TreeItem("Mercedes");

        cars.add(ferrari);
        cars.add(porsche);
        cars.add(ford);
        cars.add(mercedes);

        // Create the TreeView
        TreeView treeView = new TreeView();

        // Create the Root TreeItem
        TreeItem rootItem = new TreeItem("Cars");
        rootItem.setGraphic(quiteImageView);

        // Add children to the root
        rootItem.getChildren().addAll(cars);

        // Set the Root Node
        treeView.setRoot(rootItem);

        return treeView;

    }

}
