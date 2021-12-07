package com.example.bartabalazs_lotto;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.*;

public class HelloController {
    private Random random;
    @FXML
    public Label szamEppen;
    @FXML
    public Label szamok;
    private List<Integer> szamokVoltak;
    private String szamokVoltakString;
    private int sorsoltIndex=0;
    private Timer stopperTimer;
    private boolean vanSzam;
    private int idozito;
    int szam;
    @FXML
    public void initialize(){
        random = new Random();
        szamokVoltak = new ArrayList<>();
    }

    public void sorsol(ActionEvent actionEvent){

        vanSzam=true;

        if(sorsoltIndex<5) {
            while (vanSzam) {
                szam = random.nextInt(90)+1;
                if (!szamokVoltak.contains(szam)) {
                    stopperTimer = new Timer();
                    idozito=0;
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            idozito++;
                            Platform.runLater(() -> szamEppen.setText(String.format("%d", random.nextInt(90) + 1)));
                            if (idozito == 1000) {
                                stopperTimer.cancel();
                                szamokVoltakString = "";
                                szamEppen.setText(""+szam);
                                szamokVoltak.add(szam);
                                for (int egyikszam : szamokVoltak) {
                                    szamokVoltakString+= egyikszam;
                                }
                                szamok.setText(szamokVoltakString);
                                vanSzam = false;
                                sorsoltIndex++;
                            }
                        }
                    };
                    stopperTimer.schedule(timerTask, 0, 1);
                } else {
                    szam = random.nextInt(90)+1;
                }
            }
        } else {
            szamEppen.setText("csak 5 számot lehet sorsolni");
        }
    }
}