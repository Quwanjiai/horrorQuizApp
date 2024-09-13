package org.baltimorecityschools.horrorquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton WrongBTN1,WrongBTN2;
    Button DoneBTN;
    String toastMsg;
    Toast myToast;
    int duration,score;
    Intent GoToSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WrongBTN1 = (RadioButton) findViewById(R.id.WrongBTN1);
        WrongBTN2 = (RadioButton) findViewById(R.id.WrongBTN2);
        DoneBTN = (Button) findViewById(R.id.DoneBTN);
        toastMsg = "You Got it Correct";


        DoneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (WrongBTN1.isChecked()){
                    score+=9;
                    toastMsg = "You Got it Correct";
                }
                else if (WrongBTN2.isChecked()){
                    toastMsg = "Loser";
                }

                duration = Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

                GoToSA = new Intent(MainActivity.this, ScoreActivity.class);
                GoToSA.putExtra("score",score);
                startActivity(GoToSA);

            }
        });

        }
    }