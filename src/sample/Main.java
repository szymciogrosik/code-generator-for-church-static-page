package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Generator kodu dla parafialnej strony");
        Group root = new Group();
        Scene scene = new Scene(root, 1400, 700, Color.rgb(43,43,43));

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();


        Tab aktualnosci = createAktualnosci();

        Tab zdjecia = createZdjecia();

        tabPane.getTabs().add(aktualnosci);
        tabPane.getTabs().add(zdjecia);

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createAktualnosci() {
        Tab aktualnosci = new Tab();
        aktualnosci.setClosable(false);
        aktualnosci.setText("Aktualności");
        HBox hboxAktualnosci = new HBox();
        hboxAktualnosci.getChildren().add(new Label("Tab" + "Aktualnosc"));
        hboxAktualnosci.setAlignment(Pos.CENTER);
        hboxAktualnosci.getChildren().add(new TextArea());

        aktualnosci.setContent(hboxAktualnosci);

        return aktualnosci;
    }

    private Tab createZdjecia(){
        Tab zdjecia = new Tab();
        zdjecia.setClosable(false);
        zdjecia.setText("Zdjecia do slajdera");
        HBox hboxZdjecia = new HBox();
        hboxZdjecia.getChildren().add(new Label("Tab" + "Zdjecia"));
        hboxZdjecia.setAlignment(Pos.CENTER);
        zdjecia.setContent(hboxZdjecia);

        return zdjecia;
    }


}