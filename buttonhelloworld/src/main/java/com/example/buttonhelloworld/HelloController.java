package com.example.buttonhelloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
Rovná se (==): Porovnává, zda jsou dvě hodnoty stejné.

Nerovná se (!=): Porovnává, zda dvě hodnoty nejsou stejné.

Menší než (<): Porovnává, zda je první hodnota menší než druhá hodnota.

Větší než (>): Porovnává, zda je první hodnota větší než druhá hodnota.

Menší nebo rovno (<=): Porovnává, zda je první hodnota menší nebo rovna druhé hodnotě.

Větší nebo rovno (>=): Porovnává, zda je první hodnota větší nebo rovna druhé hodnotě.
*/

public class HelloController {
    @FXML
    private Text ahoj;

    @FXML
    private Button tlacitko;


    @FXML
    private Text cisloText;

    @FXML
    private Button scitani;

    private int cislo = 0;

    @FXML
    private Button dark;

    @FXML
    private Button light;

    @FXML
    private ImageView off;

    @FXML
    private ImageView on;

    @FXML
    private Text vysledekText;

    @FXML
    private Button hoditButton;

    @FXML
    private Button hraniImg;

    @FXML
    private ImageView dice1, dice2, dice3, dice4, dice5, dice6;

    @FXML
    private final Random kostka = new Random();

    private boolean textVisible = false; // Přidáme proměnnou pro sledování stavu viditelnosti

    @FXML
    private TextArea preklad;

    @FXML
    private TextField vypln;

   @FXML
   private final Map<Character, String> morseMap = new HashMap<>();




    @FXML
    private TextField polomerTextField;

    @FXML
    private TextField vyskaTextField;

    @FXML
    private Text vysledek;

    @FXML
    private Button objem;

    @FXML
    private Button povrch;

    @FXML
    private TextField vyskaTextField2;

    @FXML
    private TextField hmotnostTextField;

    @FXML
    private Text vysledek2;

    @FXML
    private Button vypocet;
    @FXML
    private TextArea textArea;



    @FXML
    private TextField urlTextField;
    @FXML
    private WebView webView;
    private WebEngine webEngine;
    private WebHistory webHistory;


    public void initialize() {
        webEngine = webView.getEngine();
        webHistory = webEngine.getHistory();

        // Nastavení domovské stránky na Google
        String homePage = "https://www.google.com";
        webEngine.load(homePage);

// Nastavíme akci pro změnu URL
        webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
            urlTextField.setText(newValue);
        });

    // Nastavíme akci pro změnu obsahu v TextFieldu
        urlTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                webEngine.load(newValue); // Vyhledávání
            }
        });
    }




    @FXML
    protected void onHelloButtonClick() {
        if (textVisible) {
            ahoj.setVisible(false); // Pokud je text viditelný, skryjeme ho
            textVisible = false;
        } else {
            ahoj.setVisible(true); // Jinak ho zobrazíme
            textVisible = true;
        }
    }


    //**Sčítání**\\

    @FXML
    protected void onButtonClick() {
        cislo++;
        cisloText.setText(Integer.toString(cislo));
    }

//**On off žárovka**\\


    @FXML
    protected  void onLightBulb(){
 on.setVisible(true);
 off.setVisible(false);
 dark.setVisible(true);
 light.setVisible(false);
    }

    @FXML
    protected void offLightBulb(){
        on.setVisible(false);
        off.setVisible(true);
        light.setVisible(true);
        dark.setVisible(false);
    }

    //**Hrací kostka na tlačítko**\\

    @FXML
    protected void  onClickKostka(){
        Random rand = new Random();
        int cislo = rand.nextInt(6) + 1;
        vysledekText.setText(String.valueOf(cislo));
    }
//**Hrací kostka s obrázky**\\
    @FXML
    protected void  onImgKostka(){
int randomNumber = kostka.nextInt(6) + 1;
        dice1.setVisible(false);
        dice2.setVisible(false);
        dice3.setVisible(false);
        dice4.setVisible(false);
        dice5.setVisible(false);
        dice6.setVisible(false);
switch (randomNumber){
            case 1:
                dice1.setVisible(true);
        break;
            case 2:
                dice2.setVisible(true);
                break;

            case 3:
                dice3.setVisible(true);
                break;
            case 4:
                dice4.setVisible(true);
                break;
            case 5:
                dice5.setVisible(true);
                break;
            case 6:
                dice6.setVisible(true);
                break;
            }
}

//**Morseovka**\\
    @FXML
protected void negr(){
    String vyplnText = vypln.getText().toUpperCase(); // Získání textu z textFieldu a převod na velká písmena
    StringBuilder prekladText = new StringBuilder();

    // Překlad jednotlivých znaků do Morseovy abecedy
    for (int i = 0; i < vyplnText.length(); i++) {
        char character = vyplnText.charAt(i);
        if (morseMap.containsKey(character)) {
            prekladText.append(morseMap.get(character)).append(" ");
        }

    }

    // Nastavení přeloženého textu do TextArea
    preklad.setText(prekladText.toString());


    {
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");
        morseMap.put(' ', "/");
    }


}


//**Objem a povrch válce**\\
@FXML
protected void onObjemClick() {
    try {
        double polomer = Double.parseDouble(polomerTextField.getText());
        double vyska = Double.parseDouble(vyskaTextField.getText());

        double objem = Math.PI * Math.pow(polomer, 2) * vyska;

        // Zaokrouhlení na jedno desetinné místo
        DecimalFormat df = new DecimalFormat("#.#");
        String formattedObjem = df.format(objem);

        vysledek.setText("Objem = " + formattedObjem);
    } catch (NumberFormatException e) {
        vysledek.setText("Zadejte číslo");
    }
}

    @FXML
    protected void onPovrchClick() {
        try {
            double polomer = Double.parseDouble(polomerTextField.getText());
            double vyska = Double.parseDouble(vyskaTextField.getText());

            double povrch = 2 * Math.PI * polomer * (polomer + vyska);

            // Zaokrouhlení na jedno desetinné místo
            DecimalFormat df = new DecimalFormat("#.#");
            String formattedPovrch = df.format(povrch);

            vysledek.setText("Povrch = " + formattedPovrch);
        } catch (NumberFormatException e) {
            vysledek.setText("Zadejte číslo");
        }
    }

//**BMI**\\

    @FXML
    protected void onVypocetButton(){
        try{
            double vyska = Double.parseDouble(vyskaTextField2.getText());
            double hmotnost = Double.parseDouble(hmotnostTextField.getText());

            //BMI vypočet
            double bmi = hmotnost / Math.pow(vyska / 100, 2);

            //Jedno desetinné místo
            DecimalFormat df = new DecimalFormat("#.#");
            String formattedBMI =df.format(bmi);

            //vysledek
            vysledek2.setText(formattedBMI);



        } catch (NumberFormatException e) {
            vysledek2.setText("Zadejte číslo");
        }

    }

    //**WWW prohlížeč**\\
    @FXML
    protected void onGoButton() {
        String url = urlTextField.getText();
        webEngine.load(url);
    }


    @FXML
    protected void onBackButton() {
        if (webHistory.getCurrentIndex() > 0) {
            webHistory.go(-1);
        }
    }

    @FXML
    protected void onForwardsButton() {
        if (webHistory.getCurrentIndex() < webHistory.getEntries().size() - 1) {
            webHistory.go(1);
        }
    }


//**Procházeč souborů**\\


    @FXML
    protected void onClickProchazet(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Vyberte Soubor");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            readFile(selectedFile);
        }

    }

    private void readFile(File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null ) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }




}