package com.example.bartabalazs_lotto;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
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
    private List<Integer> szamokVoltak;
    private String szamokVoltakString;
    private int sorsoltIndex=0;
    private Timer stopperTimer;
    private LocalDateTime startTime;
    private boolean vanSzam;
    private Duration leallitasIdeje;
    private int idozito;
    @FXML
    public void initialize(){
        random = new Random();
        szamokVoltak = new ArrayList<>();
        voltSzamok = new ArrayList<>();
        leallitasIdeje = Duration.ZERO;
    }







    public void sorsol(ActionEvent actionEvent){

        vanSzam=true;

        if(sorsoltIndex<5) {
            while (vanSzam) {
                int szam = random.nextInt(90)+1;
                if (!voltSzamok.contains(szam)) {
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
                                voltSzamok.add(szam);
                                szamokVoltak.add(szam);
                                for (int egyikSzam : szamokVoltak) {
                                    szamokVoltakString += " " + egyikSzam;
                                }
                                szamok.setText(szamokVoltakString);
                                vanSzam = false;
                                sorsoltIndex++;
                            }
                        }
                    };
                    stopperTimer.schedule(timerTask, 0, 1);


                }
            }
        } else {
            szamEppen.setText("csak 5 számot lehet sorsolni");
        }
    }
}