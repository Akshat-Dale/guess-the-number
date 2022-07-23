package com.akshatdale.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    int randomNumber;
    String output;


    public void reStart(View view2){
        output = " Restarted";

        generateRandom();
    }


    public void generateRandom(){

        Random random = new Random();
        randomNumber = random.nextInt(100)+1;
    }
    public void guessNumber(View view){
//        Log.i("info","button pressed");

        EditText editText = findViewById(R.id.editTextNumber);

            String inputNumber = editText.getText().toString();
            int userInputNumber = Integer.parseInt(inputNumber);


            if (userInputNumber > randomNumber) {
                output = "Guess Lower Number !";
                mediaPlayer1.start();

            }
            else if (userInputNumber < randomNumber) {
                output = "Guess Higher Number !";
                mediaPlayer1.start();
            }
            else {
                output = "You Guessed Correct Number !";
                mediaPlayer.start();
                generateRandom();
            }
            Toast.makeText(this, output, Toast.LENGTH_LONG).show();



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandom();
        Log.i("info","Random number generated.");

        mediaPlayer = MediaPlayer.create(this,R.raw.winsound);
       mediaPlayer1 = MediaPlayer.create(this,R.raw.wrongsound);




    }
}