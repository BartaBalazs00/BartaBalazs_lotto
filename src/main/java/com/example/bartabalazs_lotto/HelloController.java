package com.example.bartabalazs_lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button btn_sorsol;
    private List<Integer> voltSzamok;
    private Random random;
    public Label szamEppen;
    public Label szamok;
    private String szamokVoltak;
    @FXML
    public void initialize(){
        random = new Random();
        szamokVoltak = "";
        voltSzamok = new ArrayList<>();
    }

    public void sorsol(ActionEvent actionEvent) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int szam = random.nextInt(90)+1;
            if(!voltSzamok.contains(szam)){
                TimeUnit.SECONDS.sleep(2);
                szamEppen.setText(""+szam);
                voltSzamok.add(szam);
                szamokVoltak+= " "+szam;
                szamok.setText(szamokVoltak);
            } else {
                i--;
            }
        }
    }
}