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
    int count=0;
    String output;
    TextView textView3;
    TextView textView4;



    public void reStart(View view2){
        output = " Restarted";

        generateRandom();
    }


    public void generateRandom(){
       count = 0;
        Random random = new Random();
        randomNumber = random.nextInt(100)+1;
    }
    public void guessNumber(View view){
//        Log.i("info","button pressed");
        count++;
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
                textView4.setText("You guess the number in "+String.valueOf(count)+ " guesses");
                mediaPlayer.start();
                generateRandom();
            }
            textView3.setText(output);

//            Toast.makeText(this, output, Toast.LENGTH_LONG).show();
            Log.i("Count", String.valueOf(count));


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandom();
        Log.i("info","Random number generated.");

        mediaPlayer = MediaPlayer.create(this,R.raw.winsound);
       mediaPlayer1 = MediaPlayer.create(this,R.raw.wrongsound);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);



    }
}