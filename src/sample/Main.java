package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main extends Application {

    private Button reset = new Button("Reset");
    private Button genJS = new Button("Generuj kod JavaScript");
    private Button genHTML = new Button("Generuj kod HTML");
    private Button wybierzZdjecie = new Button("Wybierz zdjęcie");
    private Button usunZdjecie = new Button("Usuń zdjęcie");
    private Button kopiujLink = new Button("Kliknij aby skopiować link do schowka");
    private TextField numerJS = new TextField();
    private TextField data = new TextField();
    private TextField temat = new TextField();
    private TextArea opisKrotki = new TextArea();
    private TextArea opisDlugi = new TextArea();
    private Label wybraneZdjecie = new Label("brak");
    private FileChooser fileChooser = new FileChooser();
    private File file;
    private String bootstrapSite = "https://getbootstrap.com/docs/3.3/components/";

    private TextField nazwaNieklikalnaLink1 = new TextField("");
    private TextField nazwaNieklikalnaLink2 = new TextField("");
    private TextField nazwaNieklikalnaLink3 = new TextField("");
    private TextField nazwaNieklikalnaLink4 = new TextField("");
    private TextField nazwaNieklikalnaLink5 = new TextField("");
    private TextField nazwaNieklikalnaLink6 = new TextField("");
    private TextField nazwaNieklikalnaLink7 = new TextField("");
    private TextField nazwaNieklikalnaLink8 = new TextField("");

    private TextField nazwaKlikalnaLink1 = new TextField("");
    private TextField nazwaKlikalnaLink2 = new TextField("");
    private TextField nazwaKlikalnaLink3 = new TextField("");
    private TextField nazwaKlikalnaLink4 = new TextField("");
    private TextField nazwaKlikalnaLink5 = new TextField("");
    private TextField nazwaKlikalnaLink6 = new TextField("");
    private TextField nazwaKlikalnaLink7 = new TextField("");
    private TextField nazwaKlikalnaLink8 = new TextField("");

    private TextField adresLink1 = new TextField("");
    private TextField adresLink2 = new TextField("");
    private TextField adresLink3 = new TextField("");
    private TextField adresLink4 = new TextField("");
    private TextField adresLink5 = new TextField("");
    private TextField adresLink6 = new TextField("");
    private TextField adresLink7 = new TextField("");
    private TextField adresLink8 = new TextField("");

    private TextField symbolLink1 = new TextField("");
    private TextField symbolLink2 = new TextField("");
    private TextField symbolLink3 = new TextField("");
    private TextField symbolLink4 = new TextField("");
    private TextField symbolLink5 = new TextField("");
    private TextField symbolLink6 = new TextField("");
    private TextField symbolLink7 = new TextField("");
    private TextField symbolLink8 = new TextField("");

    private File zdjecieSlider1;
    private File zdjecieSlider2;
    private File zdjecieSlider3;
    private File zdjecieSlider4;
    private File zdjecieSlider5;
    private Button wczytajZdjecie1 = new Button("Wczytaj zdjecie nr 1");
    private Button wczytajZdjecie2 = new Button("Wczytaj zdjecie nr 2");
    private Button wczytajZdjecie3 = new Button("Wczytaj zdjecie nr 3");
    private Button wczytajZdjecie4 = new Button("Wczytaj zdjecie nr 4");
    private Button wczytajZdjecie5 = new Button("Wczytaj zdjecie nr 5");
    private Button usunZdjecie1 = new Button("Usun");
    private Button usunZdjecie2 = new Button("Usun");
    private Button usunZdjecie3 = new Button("Usun");
    private Button usunZdjecie4 = new Button("Usun");
    private Button usunZdjecie5 = new Button("Usun");
    private Label wybraneZdjecie1 = new Label("brak");
    private Label wybraneZdjecie2 = new Label("brak");
    private Label wybraneZdjecie3 = new Label("brak");
    private Label wybraneZdjecie4 = new Label("brak");
    private Label wybraneZdjecie5 = new Label("brak");
    private Button skopiujIZmienRozmiar = new Button("Skopiuj zdjęcia i zmień ich rozmiar!");

    private TextArea instrukcjaZdjecia = new TextArea();
    private TextArea instrukcjaAktualnosci = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Generator kodu dla parafialnej strony");
        Group root = new Group();
        Scene scene = new Scene(root, 1400, 700, Color.rgb(43,43,43));

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();

        Tab aktualnosci = createAktualnosci();

        Tab aktualnosciInstrukcja = createAktualnosciInstrukcja();

        Tab zdjecia = createZdjecia();

        Tab zdjeciaInstukcja = createZdjeciaInstrukcja();

        tabPane.getTabs().add(aktualnosci);
        tabPane.getTabs().add(aktualnosciInstrukcja);
        tabPane.getTabs().add(zdjecia);
        tabPane.getTabs().add(zdjeciaInstukcja);

        instrukcjaAktualnosci.setText(readTextFromFile("instrukcja_aktualnosci.txt"));
        instrukcjaZdjecia.setText(readTextFromFile("instrukcja_zdjecia.txt"));

        wybierzZdjecie.setOnAction(
                event -> {
                    file = fileChooser.showOpenDialog(primaryStage);
                    if (file != null) {
                        wybraneZdjecie.setText(file.getName());
                    }
                }
        );

        usunZdjecie.setOnAction(
                event -> {
                    if (file != null) {
                        file = null;
                        wybraneZdjecie.setText("brak");
                    }
                }
        );

        kopiujLink.setOnAction(
                event -> {
                    StringSelection stringSelection = new StringSelection(bootstrapSite);
                    java.awt.datatransfer.Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                }
        );

        genJS.setOnAction(
                event -> generujKodJavaScript()
        );

        genHTML.setOnAction(
                event -> {
                    generujKodHTML();
                    if(file != null)
                        wykonajZmianeWielkosciZdjecia();
                }
        );

        reset.setOnAction(
                event -> {
                    numerJS.setText("");
                    data.setText("");
                    temat.setText("");
                    opisKrotki.setText("");
                    opisDlugi.setText("");
                    if (file != null) {
                        file = null;
                        wybraneZdjecie.setText("brak");
                    }
                    nazwaNieklikalnaLink1.setText("");
                    nazwaNieklikalnaLink2.setText("");
                    nazwaNieklikalnaLink3.setText("");
                    nazwaNieklikalnaLink4.setText("");
                    nazwaNieklikalnaLink5.setText("");
                    nazwaNieklikalnaLink6.setText("");
                    nazwaNieklikalnaLink7.setText("");
                    nazwaNieklikalnaLink8.setText("");
                    nazwaKlikalnaLink1.setText("");
                    nazwaKlikalnaLink2.setText("");
                    nazwaKlikalnaLink3.setText("");
                    nazwaKlikalnaLink4.setText("");
                    nazwaKlikalnaLink5.setText("");
                    nazwaKlikalnaLink6.setText("");
                    nazwaKlikalnaLink7.setText("");
                    nazwaKlikalnaLink8.setText("");
                    adresLink1.setText("");
                    adresLink2.setText("");
                    adresLink3.setText("");
                    adresLink4.setText("");
                    adresLink5.setText("");
                    adresLink6.setText("");
                    adresLink7.setText("");
                    adresLink8.setText("");
                    symbolLink1.setText("");
                    symbolLink2.setText("");
                    symbolLink3.setText("");
                    symbolLink4.setText("");
                    symbolLink5.setText("");
                    symbolLink6.setText("");
                    symbolLink7.setText("");
                    symbolLink8.setText("");
                }
        );

        wczytajZdjecie1.setOnAction(
                event -> {
                    zdjecieSlider1 = fileChooser.showOpenDialog(primaryStage);
                    if (zdjecieSlider1 != null) {
                        wybraneZdjecie1.setText(zdjecieSlider1.getName());
                    }
                }
        );

        wczytajZdjecie2.setOnAction(
                event -> {
                    zdjecieSlider2 = fileChooser.showOpenDialog(primaryStage);
                    if (zdjecieSlider2 != null) {
                        wybraneZdjecie2.setText(zdjecieSlider2.getName());
                    }
                }
        );

        wczytajZdjecie3.setOnAction(
                event -> {
                    zdjecieSlider3 = fileChooser.showOpenDialog(primaryStage);
                    if (zdjecieSlider3 != null) {
                        wybraneZdjecie3.setText(zdjecieSlider3.getName());
                    }
                }
        );

        wczytajZdjecie4.setOnAction(
                event -> {
                    zdjecieSlider4 = fileChooser.showOpenDialog(primaryStage);
                    if (zdjecieSlider4 != null) {
                        wybraneZdjecie4.setText(zdjecieSlider4.getName());
                    }
                }
        );

        wczytajZdjecie5.setOnAction(
                event -> {
                    zdjecieSlider5 = fileChooser.showOpenDialog(primaryStage);
                    if (zdjecieSlider5 != null) {
                        wybraneZdjecie5.setText(zdjecieSlider5.getName());
                    }
                }
        );

        usunZdjecie1.setOnAction(
                event -> {
                    if (zdjecieSlider1 != null) {
                        zdjecieSlider1 = null;
                        wybraneZdjecie1.setText("brak");
                    }
                }
        );

        usunZdjecie2.setOnAction(
                event -> {
                    if (zdjecieSlider2 != null) {
                        zdjecieSlider2 = null;
                        wybraneZdjecie2.setText("brak");
                    }
                }
        );

        usunZdjecie3.setOnAction(
                event -> {
                    if (zdjecieSlider3 != null) {
                        zdjecieSlider3 = null;
                        wybraneZdjecie3.setText("brak");
                    }
                }
        );

        usunZdjecie4.setOnAction(
                event -> {
                    if (zdjecieSlider4 != null) {
                        zdjecieSlider4 = null;
                        wybraneZdjecie4.setText("brak");
                    }
                }
        );

        usunZdjecie5.setOnAction(
                event -> {
                    if (zdjecieSlider5 != null) {
                        zdjecieSlider5 = null;
                        wybraneZdjecie5.setText("brak");
                    }
                }
        );

        skopiujIZmienRozmiar.setOnAction(event -> zmienRozmiarZdjeciomSlider());


        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Tab createAktualnosci() {
        Tab aktualnosci = new Tab();
        aktualnosci.setClosable(false);
        aktualnosci.setText("Aktualności");

        Image aktualnosciImage = new Image(getClass().getResourceAsStream("aktualnosc.png"));

        ImageView imageViewAktualnosci = new ImageView(aktualnosciImage);

        HBox hboxAktualnosci = new HBox(5);
        hboxAktualnosci.setPadding(new Insets(5,5,5,5));

        // Col 1
        VBox col11 = new VBox(5);
        col11.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Label label = new Label("0. Wpisz OSTATNI + 1 numer z pliku /static/js/Aktualnosci/aktualnosci.js                    ");
        label.setTextFill(Color.YELLOW);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col12 = new VBox(5);
        col12.getChildren().add(label);

        VBox col13 = new VBox(5);
        col13.getChildren().add(numerJS);

        Label label2 = new Label("1. Wpisz date - format: DD.MM.RRRR");
        label2.setTextFill(Color.YELLOW);
        label2.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col14 = new VBox(5);
        col14.getChildren().add(label2);

        VBox col15 = new VBox(5);
        col15.getChildren().add(data);

        Label label3 = new Label("2. Wpisz temat");
        label3.setTextFill(Color.YELLOW);
        label3.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col16 = new VBox(5);
        col16.getChildren().add(label3);

        VBox col17 = new VBox(5);
        col17.getChildren().add(temat);

        Label label4 = new Label("3. Opis krótki");
        label4.setTextFill(Color.WHITE);
        label4.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col18 = new VBox(5);
        col18.getChildren().add(label4);

        VBox col19 = new VBox(5);
        opisKrotki.setWrapText(true);
        col19.getChildren().add(opisKrotki);

        Label label5 = new Label("4. Opis długi - dodatkowo - <br> - enter, <b>text</b> - pogrubienie");
        label5.setTextFill(Color.WHITE);
        label5.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col110 = new VBox(5);
        col110.getChildren().add(label5);

        VBox col111 = new VBox(5);
        opisDlugi.setWrapText(true);
        col111.getChildren().add(opisDlugi);

        Label label6 = new Label("6. Zdjęcie widoczne przy aktualności");
        label6.setTextFill(Color.WHITE);
        label6.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col112 = new VBox(5);
        col112.getChildren().add(label6);

        VBox col113 = new VBox(5);
        wybierzZdjecie.setMaxWidth(Double.MAX_VALUE);
        usunZdjecie.setMaxWidth(Double.MAX_VALUE);
        col113.getChildren().add(wybierzZdjecie);
        col113.getChildren().add(usunZdjecie);

        wybraneZdjecie.setTextFill(Color.WHITE);
        wybraneZdjecie.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Label label7 = new Label("Wybrane zdjęcie:");
        label7.setTextFill(Color.WHITE);
        label7.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col115 = new VBox(5);
        col115.getChildren().add(label7);

        VBox col114 = new VBox(5);
        col114.getChildren().add(wybraneZdjecie);


        col11.getChildren().addAll(col12, col13, col14, col15, col16, col17, col18, col19, col110, col111, col112, col113, col115, col114);

        hboxAktualnosci.getChildren().add(col11);


        // Col 2
        nazwaNieklikalnaLink1.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink2.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink3.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink4.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink5.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink6.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink7.setPromptText("a) - nazwa nieklikalna");
        nazwaNieklikalnaLink8.setPromptText("a) - nazwa nieklikalna");

        nazwaNieklikalnaLink1.setMinWidth(250);
        nazwaNieklikalnaLink2.setMinWidth(250);
        nazwaNieklikalnaLink3.setMinWidth(250);
        nazwaNieklikalnaLink4.setMinWidth(250);
        nazwaNieklikalnaLink5.setMinWidth(250);
        nazwaNieklikalnaLink6.setMinWidth(250);
        nazwaNieklikalnaLink7.setMinWidth(250);
        nazwaNieklikalnaLink8.setMinWidth(250);

        nazwaKlikalnaLink1.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink2.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink3.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink4.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink5.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink6.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink7.setPromptText("b) - nazwa klikalna");
        nazwaKlikalnaLink8.setPromptText("b) - nazwa klikalna");

        nazwaKlikalnaLink1.setMinWidth(250);
        nazwaKlikalnaLink2.setMinWidth(250);
        nazwaKlikalnaLink3.setMinWidth(250);
        nazwaKlikalnaLink4.setMinWidth(250);
        nazwaKlikalnaLink5.setMinWidth(250);
        nazwaKlikalnaLink6.setMinWidth(250);
        nazwaKlikalnaLink7.setMinWidth(250);
        nazwaKlikalnaLink8.setMinWidth(250);

        symbolLink1.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink2.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink3.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink4.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink5.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink6.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink7.setPromptText("c) - nazwa ikonki z strony Bootstrap");
        symbolLink8.setPromptText("c) - nazwa ikonki z strony Bootstrap");

        symbolLink1.setMinWidth(250);
        symbolLink2.setMinWidth(250);
        symbolLink3.setMinWidth(250);
        symbolLink4.setMinWidth(250);
        symbolLink5.setMinWidth(250);
        symbolLink6.setMinWidth(250);
        symbolLink7.setMinWidth(250);
        symbolLink8.setMinWidth(250);

        adresLink1.setPromptText("Adres linku");
        adresLink2.setPromptText("Adres linku");
        adresLink3.setPromptText("Adres linku");
        adresLink4.setPromptText("Adres linku");
        adresLink5.setPromptText("Adres linku");
        adresLink6.setPromptText("Adres linku");
        adresLink7.setPromptText("Adres linku");
        adresLink8.setPromptText("Adres linku");

        adresLink1.setMinWidth(250);
        adresLink2.setMinWidth(250);
        adresLink3.setMinWidth(250);
        adresLink4.setMinWidth(250);
        adresLink5.setMinWidth(250);
        adresLink6.setMinWidth(250);
        adresLink7.setMinWidth(250);
        adresLink8.setMinWidth(250);

        VBox col21 = new VBox(5);
        col21.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label label8 = new Label("5. Linki                                                                                                                                            ");
        label8.setTextFill(Color.WHITE);
        label8.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col116 = new VBox(5);
        col116.getChildren().add(label8);

        //Link 1
        Label label9 = new Label("Link 1");
        label9.setTextFill(Color.ORANGE);
        label9.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink1 = new VBox(5);
        vBoxLink1.setAlignment(Pos.CENTER);
        vBoxLink1.getChildren().add(label9);

        HBox col117 = new HBox(5);
        col117.setAlignment(Pos.CENTER);
        col117.getChildren().addAll(nazwaNieklikalnaLink1, nazwaKlikalnaLink1);

        HBox col118 = new HBox(5);
        col118.setAlignment(Pos.CENTER);
        col118.getChildren().addAll(symbolLink1, adresLink1);

        //Link 2
        Label label10 = new Label("Link 2");
        label10.setTextFill(Color.ORANGE);
        label10.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink2 = new VBox(5);
        vBoxLink2.setAlignment(Pos.CENTER);
        vBoxLink2.getChildren().add(label10);

        HBox col120 = new HBox(5);
        col120.setAlignment(Pos.CENTER);
        col120.getChildren().addAll(nazwaNieklikalnaLink2, nazwaKlikalnaLink2);

        HBox col121 = new HBox(5);
        col121.setAlignment(Pos.CENTER);
        col121.getChildren().addAll(symbolLink2, adresLink2);

        //Link 3
        Label label11 = new Label("Link 3");
        label11.setTextFill(Color.ORANGE);
        label11.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink3 = new VBox(5);
        vBoxLink3.setAlignment(Pos.CENTER);
        vBoxLink3.getChildren().add(label11);

        HBox col123 = new HBox(5);
        col123.setAlignment(Pos.CENTER);
        col123.getChildren().addAll(nazwaNieklikalnaLink3, nazwaKlikalnaLink3);

        HBox col124 = new HBox(5);
        col124.setAlignment(Pos.CENTER);
        col124.getChildren().addAll(symbolLink3, adresLink3);

        //Link 4
        Label label12 = new Label("Link 4");
        label12.setTextFill(Color.ORANGE);
        label12.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink4 = new VBox(5);
        vBoxLink4.setAlignment(Pos.CENTER);
        vBoxLink4.getChildren().add(label12);

        HBox col125 = new HBox(5);
        col125.setAlignment(Pos.CENTER);
        col125.getChildren().addAll(nazwaNieklikalnaLink4, nazwaKlikalnaLink4);

        HBox col126 = new HBox(5);
        col126.setAlignment(Pos.CENTER);
        col126.getChildren().addAll(symbolLink4, adresLink4);

        //Link 5
        Label label13 = new Label("Link 5");
        label13.setTextFill(Color.ORANGE);
        label13.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink5 = new VBox(5);
        vBoxLink5.setAlignment(Pos.CENTER);
        vBoxLink5.getChildren().add(label13);

        HBox col127 = new HBox(5);
        col127.setAlignment(Pos.CENTER);
        col127.getChildren().addAll(nazwaNieklikalnaLink5, nazwaKlikalnaLink5);

        HBox col128 = new HBox(5);
        col128.setAlignment(Pos.CENTER);
        col128.getChildren().addAll(symbolLink5, adresLink5);

        //Link 6
        Label label14 = new Label("Link 6");
        label14.setTextFill(Color.ORANGE);
        label14.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink6 = new VBox(5);
        vBoxLink6.setAlignment(Pos.CENTER);
        vBoxLink6.getChildren().add(label14);

        HBox col129 = new HBox(5);
        col129.setAlignment(Pos.CENTER);
        col129.getChildren().addAll(nazwaNieklikalnaLink6, nazwaKlikalnaLink6);

        HBox col130 = new HBox(5);
        col130.setAlignment(Pos.CENTER);
        col130.getChildren().addAll(symbolLink6, adresLink6);

        //Link 7
        Label label15 = new Label("Link 7");
        label15.setTextFill(Color.ORANGE);
        label15.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink7 = new VBox(5);
        vBoxLink7.setAlignment(Pos.CENTER);
        vBoxLink7.getChildren().add(label15);

        HBox col132 = new HBox(5);
        col132.setAlignment(Pos.CENTER);
        col132.getChildren().addAll(nazwaNieklikalnaLink7, nazwaKlikalnaLink7);

        HBox col133 = new HBox(5);
        col133.setAlignment(Pos.CENTER);
        col133.getChildren().addAll(symbolLink7, adresLink7);

        //Link 8
        Label label16 = new Label("Link 8");
        label16.setTextFill(Color.ORANGE);
        label16.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox vBoxLink8 = new VBox(5);
        vBoxLink8.setAlignment(Pos.CENTER);
        vBoxLink8.getChildren().add(label16);

        HBox col134 = new HBox(5);
        col134.setAlignment(Pos.CENTER);
        col134.getChildren().addAll(nazwaNieklikalnaLink8, nazwaKlikalnaLink8);

        HBox col135 = new HBox(5);
        col135.setAlignment(Pos.CENTER);
        col135.getChildren().addAll(symbolLink8, adresLink8);


        VBox col131 = new VBox(5);

        col131.getChildren().addAll(
                vBoxLink1, col117, col118,
                vBoxLink2, col120, col121,
                vBoxLink3, col123, col124,
                vBoxLink4, col125, col126,
                vBoxLink5, col127, col128,
                vBoxLink6, col129, col130,
                vBoxLink7, col132, col133,
                vBoxLink8, col134, col135
        );

        col21.getChildren().addAll(col116, col131);
        hboxAktualnosci.getChildren().add(col21);


        // Col 3
        VBox col31 = new VBox(5);
        col31.getChildren().add(imageViewAktualnosci);

        reset.setMaxWidth(Double.MAX_VALUE);
        genJS.setMaxWidth(Double.MAX_VALUE);
        genHTML.setMaxWidth(Double.MAX_VALUE);
        kopiujLink.setMaxWidth(Double.MAX_VALUE);

        VBox col32 = new VBox(5);
        col32.getChildren().add(reset);

        VBox col33 = new VBox(5);
        col33.getChildren().add(genJS);

        VBox col34 = new VBox(5);
        col34.getChildren().add(genHTML);

        Label label999 = new Label("Pola w takim kolorze są OBOWIĄZKOWE");
        label999.setTextFill(Color.YELLOW);
        label999.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Label label9991 = new Label("Pola w takim kolorze są OPCJONALNE");
        label9991.setTextFill(Color.WHITE);
        label9991.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col35 = new VBox(5);
        col35.getChildren().add(label999);
        col35.setAlignment(Pos.CENTER);

        VBox col36 = new VBox(5);
        col36.getChildren().add(label9991);
        col36.setAlignment(Pos.CENTER);

        Label label9992 = new Label("Przykładowe nazwy ikonek wraz z obrazkami, inne można znaleźć na stronie:");
        label9992.setTextFill(Color.WHITE);
        label9992.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        VBox col37 = new VBox(5);
        col37.getChildren().add(label9992);
        col37.setAlignment(Pos.CENTER);

        VBox col38 = new VBox(5);
        col38.getChildren().add(kopiujLink);


        Image icon1Image = new Image(Main.class.getResourceAsStream("download.png"));
        Image icon2Image = new Image(Main.class.getResourceAsStream("glob.png"));
        Image icon3Image = new Image(Main.class.getResourceAsStream("camera.png"));
        Image icon4Image = new Image(Main.class.getResourceAsStream("film.png"));
        Image icon5Image = new Image(Main.class.getResourceAsStream("headphone.png"));

        ImageView iconImage1 = new ImageView(icon1Image);
        ImageView iconImage2 = new ImageView(icon2Image);
        ImageView iconImage3 = new ImageView(icon3Image);
        ImageView iconImage4 = new ImageView(icon4Image);
        ImageView iconImage5 = new ImageView(icon5Image);

        TextField icon1 = new TextField("glyphicon glyphicon-download-alt");
        icon1.setMinWidth(250);
        icon1.setEditable(false);

        TextField icon2 = new TextField("glyphicon glyphicon-globe");
        icon2.setMinWidth(250);
        icon2.setEditable(false);

        TextField icon3 = new TextField("glyphicon glyphicon-camera");
        icon3.setMinWidth(250);
        icon3.setEditable(false);

        TextField icon4 = new TextField("glyphicon glyphicon-facetime-video");
        icon4.setMinWidth(250);
        icon4.setEditable(false);

        TextField icon5 = new TextField("glyphicon glyphicon-headphones");
        icon5.setMinWidth(250);
        icon5.setEditable(false);

        HBox col139 = new HBox(5);
        col139.setAlignment(Pos.CENTER);
        col139.getChildren().addAll(icon1, iconImage1);

        HBox col140 = new HBox(5);
        col140.setAlignment(Pos.CENTER);
        col140.getChildren().addAll(icon2, iconImage2);

        HBox col141 = new HBox(5);
        col141.setAlignment(Pos.CENTER);
        col141.getChildren().addAll(icon3, iconImage3);

        HBox col142 = new HBox(5);
        col142.setAlignment(Pos.CENTER);
        col142.getChildren().addAll(icon4, iconImage4);

        HBox col143 = new HBox(5);
        col143.setAlignment(Pos.CENTER);
        col143.getChildren().addAll(icon5, iconImage5);
        col143.setPadding(new Insets(0, 0, 10, 0));

        col31.getChildren().addAll(col35, col36, col32, col37, col38, col139, col140, col141, col142, col143, col33, col34);

        hboxAktualnosci.getChildren().addAll(col31);

        aktualnosci.setContent(hboxAktualnosci);
        return aktualnosci;
    }

    private void generujKodJavaScript(){
        String myString = "\n// --------------- Numer "+numerJS.getText()+"\n";
        myString = myString+"$(\"#hide"+numerJS.getText()+"\").click(function(){\n";
        myString = myString+"$(\"#toShow"+numerJS.getText()+"\").toggle();\n";

        myString = myString+"$(\"#hideBis"+numerJS.getText()+"\").toggle();\n";

        myString = myString+"$(\"#hide"+numerJS.getText()+"\").toggle();\n";

        myString = myString+"});\n";

        myString = myString+"$(\"#hideBis"+numerJS.getText()+"\").click(function(){\n";
        myString = myString+"$(\"#toShow"+numerJS.getText()+"\").toggle();\n";

        myString = myString+"$(\"#hideBis"+numerJS.getText()+"\").toggle();\n";

        myString = myString+"$(\"#hide"+numerJS.getText()+"\").toggle();\n";

        myString = myString+"});\n";

        StringSelection stringSelection = new StringSelection(myString);
        java.awt.datatransfer.Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }

    private void generujKodHTML(){
        String myString = "\n<!-- --------------- Aktualnosc nr "+numerJS.getText()+"    -->"+"\n";
        myString=myString+"<div class=\"col-md-12 aktualnosc-style\">\n";
        myString=myString+"    <div class=\"col-sm-6\">\n";
        myString=myString+"        <div class=\"font14\"><i class=\"glyphicon glyphicon-calendar fa-sm\"></i>\n";
        myString=myString+"            <b>Data:</b> "+data.getText()+"\n";
        myString=myString+"        </div>\n";
        myString=myString+"    </div>\n";
        myString=myString+"    <div class=\"col-sm-6\"></div>\n";
        if(file != null) {
            myString=myString+"    <div class=\"col-sm-12 margin-top2 padding-left0\">\n";
            myString=myString+"        <div class=\"col-sm-2\">\n";
            myString=myString+"            <img align=\"left\" src=\"static/images/Aktualnosci/"+file.getName()+"\" class=\"img-border margin-bottom5\" height=\"90\" width=\"120\">\n";
            myString=myString+"        </div>\n";
            myString=myString+"        <div class=\"col-sm-10 padding-tekstNaglowek\">\n";
            myString=myString+"            <h4 class=\"margin-top0 margin-bottom5\">"+temat.getText()+"</h4>\n";
            myString=myString+"            <div class=\"opisKrotki\">"+opisKrotki.getText()+"</div>\n";
            myString=myString+"        </div>\n";
            myString=myString+"    </div>\n";
        } else {
            myString=myString+"    <div class=\"col-sm-12\">\n";
            myString=myString+"        <h4 class=\"margin-top5 margin-bottom5\">" + temat.getText() + "</h4>\n";
            if (opisKrotki.getText().length() > 1)
                myString=myString+"        <div class=\"opisKrotki\">" + opisKrotki.getText() + "</div>\n";
            myString=myString+"    </div>\n";
        }
        myString=myString+"    <div id=\"toShow"+numerJS.getText()+"\" class=\"col-sm-12 ustawienia-ukryty-tekst\">\n";
        if(opisDlugi.getText().length()>1)
            myString=myString+"        <div id=\"opisD"+numerJS.getText()+"\" class=\"opisDlugi\">"+opisDlugi.getText()+"</div>\n";

        myString += createLink(nazwaNieklikalnaLink1, nazwaKlikalnaLink1, adresLink1, symbolLink1);
        myString += createLink(nazwaNieklikalnaLink2, nazwaKlikalnaLink2, adresLink2, symbolLink2);
        myString += createLink(nazwaNieklikalnaLink3, nazwaKlikalnaLink3, adresLink3, symbolLink3);
        myString += createLink(nazwaNieklikalnaLink4, nazwaKlikalnaLink4, adresLink4, symbolLink4);
        myString += createLink(nazwaNieklikalnaLink5, nazwaKlikalnaLink5, adresLink5, symbolLink5);
        myString += createLink(nazwaNieklikalnaLink6, nazwaKlikalnaLink6, adresLink6, symbolLink6);
        myString += createLink(nazwaNieklikalnaLink7, nazwaKlikalnaLink7, adresLink7, symbolLink7);
        myString += createLink(nazwaNieklikalnaLink8, nazwaKlikalnaLink8, adresLink8, symbolLink8);

        myString=myString+"    </div>\n";
        myString=myString+"    <div class=\"col-sm-6\"></div>\n";
        myString=myString+"    <div class=\"col-sm-6 margin-top-15\">\n";
        myString=myString+"        <a class=\"btn pull-right btn-link color-black font13 borderCzytajWiecej\" id=\"hide"+numerJS.getText()+"\">Czytaj wiecej&nbsp;"+"\n";
        myString=myString+"        <i class=\"glyphicon glyphicon-chevron-down fa-lg\"></i></a>\n";
        myString=myString+"        <a class=\"btn pull-right btn-link color-black font13 borderCzytajWiecej\" id=\"hideBis"+numerJS.getText()+"\" style=\"display:none\">Czytaj mniej&nbsp;"+"\n";
        myString=myString+"        <i class=\"glyphicon glyphicon-chevron-up fa-lg\"></i></a>\n";
        myString=myString+"    </div>\n";
        myString=myString+"</div>\n";

        StringSelection stringSelection = new StringSelection(myString);
        java.awt.datatransfer.Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }

    private void wykonajZmianeWielkosciZdjecia() {
        File filee = new File(file.getPath());
        Image image = new Image(filee.toURI().toString(), 120, 90, false, false);
        saveToFile(image, file.getName(), "png");
    }

    private void saveToFile(Image image, String saveName, String rozszerzenie) {
        File outputFile = new File(saveName);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, rozszerzenie, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createLink(TextField nazwaNieklikalnaLink, TextField nazwaKlikalnaLink, TextField adresLink, TextField symbol) {
        String myString = "";

        if(adresLink.getText().length()>1){
            myString=myString+"        <div>"+nazwaNieklikalnaLink.getText()+"<a href=\""+adresLink.getText()+"\" target=\"_blank\">"+nazwaKlikalnaLink.getText();
            if(symbol.getText().length()>1)
                myString=myString+"            <i class=\""+symbol.getText()+"\"></i>"+"\n";
            myString=myString+"        </a></div>\n";
        }

        return myString;
    }

    private Tab createZdjecia(){
        Tab zdjecia = new Tab();
        zdjecia.setClosable(false);
        zdjecia.setText("Zdjecia do slajdera");

        VBox hboxZdjecia = new VBox(5);
        hboxZdjecia.setPadding(new Insets(5,5,5,5));

        // Col 1
        Label label1 = new Label("Wybierz 5 zdjec do slajdera (zostanie im zmieniony rozmiar na szerokość: 445 x wysokość: 250) oraz zdjęcia zostaną ponumerowane od 1 do 5. WSZYSTKIE pola muszą być uzupełnione.");
        label1.setTextFill(Color.YELLOW);
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        wybraneZdjecie1.setTextFill(Color.WHITE);
        wybraneZdjecie2.setTextFill(Color.WHITE);
        wybraneZdjecie3.setTextFill(Color.WHITE);
        wybraneZdjecie4.setTextFill(Color.WHITE);
        wybraneZdjecie5.setTextFill(Color.WHITE);
        wybraneZdjecie1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        wybraneZdjecie2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        wybraneZdjecie3.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        wybraneZdjecie4.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        wybraneZdjecie5.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        wybraneZdjecie1.setMinWidth(250);
        wybraneZdjecie2.setMinWidth(250);
        wybraneZdjecie3.setMinWidth(250);
        wybraneZdjecie4.setMinWidth(250);
        wybraneZdjecie5.setMinWidth(250);

        VBox col2 = new VBox(5);
        col2.setAlignment(Pos.CENTER);
        col2.getChildren().add(label1);

        //Zdjecie 1
        VBox col1 = new VBox(5);
        col1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col1.setPadding(new Insets(10,0,0,0));

        HBox col3 = new HBox(5);
        col3.getChildren().addAll(usunZdjecie1, wczytajZdjecie1, wybraneZdjecie1);
        col3.setAlignment(Pos.CENTER);
        col3.setPadding(new Insets(50,0,0,0));

        col1.getChildren().addAll(col2, col3);

        //Zdjecie 2
        VBox col4 = new VBox(5);
        col4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox col5 = new HBox(5);
        col5.getChildren().addAll(usunZdjecie2, wczytajZdjecie2, wybraneZdjecie2);
        col5.setAlignment(Pos.CENTER);
        col5.setPadding(new Insets(10,0,0,0));

        col4.getChildren().addAll(col5);

        //Zdjecie 3
        VBox col6 = new VBox(5);
        col6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox col7 = new HBox(5);
        col7.getChildren().addAll(usunZdjecie3, wczytajZdjecie3, wybraneZdjecie3);
        col7.setAlignment(Pos.CENTER);
        col7.setPadding(new Insets(10,0,0,0));

        col6.getChildren().addAll(col7);

        //Zdjecie 4
        VBox col8 = new VBox(5);
        col8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox col9 = new HBox(5);
        col9.getChildren().addAll(usunZdjecie4, wczytajZdjecie4, wybraneZdjecie4);
        col9.setAlignment(Pos.CENTER);
        col9.setPadding(new Insets(10,0,0,0));

        col8.getChildren().addAll(col9);

        //Zdjecie 5
        VBox col10 = new VBox(5);
        col10.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox col11 = new HBox(5);
        col11.getChildren().addAll(usunZdjecie5, wczytajZdjecie5, wybraneZdjecie5);
        col11.setAlignment(Pos.CENTER);
        col11.setPadding(new Insets(10,0,0,0));

        col10.getChildren().addAll(col11);


        //Button run
        VBox col12 = new VBox(5);
        col12.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox col13 = new HBox(5);
        col13.getChildren().addAll(skopiujIZmienRozmiar);
        col13.setAlignment(Pos.CENTER);
        col13.setPadding(new Insets(60,0,0,0));

        col12.getChildren().addAll(col13);

        hboxZdjecia.getChildren().addAll(col1, col4, col6, col8, col10, col12);

        zdjecia.setContent(hboxZdjecia);
        return zdjecia;
    }

    private void zmienRozmiarZdjeciomSlider(){
        File filee1 = new File(zdjecieSlider1.getPath());
        File filee2 = new File(zdjecieSlider2.getPath());
        File filee3 = new File(zdjecieSlider3.getPath());
        File filee4 = new File(zdjecieSlider4.getPath());
        File filee5 = new File(zdjecieSlider5.getPath());

        Image image1 = new Image(filee1.toURI().toString(), 445, 250, false, false);
        Image image2 = new Image(filee2.toURI().toString(), 445, 250, false, false);
        Image image3 = new Image(filee3.toURI().toString(), 445, 250, false, false);
        Image image4 = new Image(filee4.toURI().toString(), 445, 250, false, false);
        Image image5 = new Image(filee5.toURI().toString(), 445, 250, false, false);

        saveToFile(image1, "1.jpg", "jpg");
        saveToFile(image2, "2.jpg", "jpg");
        saveToFile(image3, "3.jpg", "jpg");
        saveToFile(image4, "4.jpg", "jpg");
        saveToFile(image5, "5.jpg", "jpg");
    }

    private Tab createZdjeciaInstrukcja(){
        Tab zdjecia = new Tab();
        zdjecia.setClosable(false);
        zdjecia.setText("Instrukcja do Zdjecia");

        instrukcjaZdjecia.setWrapText(true);
        instrukcjaZdjecia.setEditable(false);

        zdjecia.setContent(instrukcjaZdjecia);
        return zdjecia;
    }

    private Tab createAktualnosciInstrukcja(){
        Tab zdjecia = new Tab();
        zdjecia.setClosable(false);
        zdjecia.setText("Instrukcja do Aktualności");

        instrukcjaAktualnosci.setWrapText(true);
        instrukcjaAktualnosci.setEditable(false);

        zdjecia.setContent(instrukcjaAktualnosci);
        return zdjecia;
    }

    private String readTextFromFile(String realtivePath) throws IOException {
        InputStream in = getClass().getResourceAsStream(realtivePath);
        BufferedReader input = new BufferedReader(new InputStreamReader(in, "UTF8"));

        StringBuilder returnedString = new StringBuilder();
        String aux;

        while ((aux = input.readLine()) != null)
            returnedString.append(aux).append("\n");

        return returnedString.toString();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}