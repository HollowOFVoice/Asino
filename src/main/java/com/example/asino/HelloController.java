package com.example.asino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class HelloController {

    @FXML
    private Text textSpining;

    @FXML
    private Text textWin;

    @FXML
    private Text allSpin;
    @FXML
    private Text win;
    @FXML
    private ImageView image;

    @FXML
    private Button exit;

    @FXML
    private Text oneN;

    @FXML
    private Button spin;

    @FXML
    private Text threeN;

    @FXML
    private Text twoN;
    @FXML
    private Text luck;

double taps =0;
double winN =0;
    double l = 0;

    @FXML private void initialize (){
        try {
            String content = Files.readString(Paths.get("users.txt"));

            taps = Double.parseDouble(content);
            allSpin.setText(String.valueOf(taps));

            String lucki = Files.readString(Paths.get("luck.txt"));

            l = Double.parseDouble(lucki);
            luck.setText(String.valueOf(l));

            String wining = Files.readString(Paths.get("win.txt"));

            winN = Double.parseDouble(wining);
            win.setText(String.valueOf(winN));
            // Process the content as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ButtonSpin(ActionEvent event) {

        Random rand = new Random();

        taps++;
//

        int max = 9, min = 0;
        oneN.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        twoN.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        threeN.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
//oneN.setText("7");
//twoN.setText("7");
//threeN.setText("7");
        String s = "7";
        if (oneN.getText().equals(s) || twoN.getText().equals(s) || threeN.getText().equals(s)) {
            winN++;
            win.setText(String.valueOf(Math.round(winN)));
            image.setOpacity(1);
        } else image.setOpacity(0);

        allSpin.setText(String.valueOf(Math.round(taps)));
        l = Math.round(winN / taps * 100);
        luck.setText(String.valueOf(Math.round(l)));

        PrintWriter fw = null;
        PrintWriter fw2 = null;
        PrintWriter fw3 = null;
        try {
            fw = new PrintWriter("users.txt");
            fw2 = new PrintWriter("luck.txt");
            fw3 = new PrintWriter("win.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw.write(allSpin.getText());
            bw2.write(luck.getText());
            bw3.write(win.getText());
            bw.close();  //missing this won't write anything into file
            fw.close();
            bw2.close();  //missing this won't write anything into file
            fw2.close();
            bw3.close();  //missing this won't write anything into file
            fw3.close();

        } catch (IOException e) {
            e.printStackTrace();
            fw.close();
            fw2.close();
            fw3.close();
        }

    }


    @FXML
    void ex(ActionEvent event){
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
}


}