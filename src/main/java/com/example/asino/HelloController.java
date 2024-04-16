package com.example.asino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
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
    @FXML
    void ButtonSpin(ActionEvent event) {


        Random rand = new Random();
        taps++;
        int max = 9, min = 0;
        oneN.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        twoN.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        threeN.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
//oneN.setText("7");
//twoN.setText("7");
//threeN.setText("7");
        String s = "7";
        if (oneN.getText().equals(s) && twoN.getText().equals(s) && threeN.getText().equals(s)) {
            winN++;
            win.setText(String.valueOf(winN));
            image.setOpacity(1);
        } else image.setOpacity(0);

        allSpin.setText(String.valueOf(taps));
        double l = Math.round(winN / taps * 100);
        luck.setText(String.valueOf(l));

        PrintWriter fw = null;

        try {
            fw = new PrintWriter("users.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(luck.getText());
            bw.newLine();
            bw.write(allSpin.getText());

            bw.close();  //missing this won't write anything into file
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
            fw.close();
        }

    }


@FXML
    void ex(ActionEvent event){
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
}

@FXML
    void setImage(){

}
}