package org.baltimorecityschools.horrorquizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton WrongBTN1,WrongBTN2;
    TextView QuestiovTv;
    Button NextBTN;
    String toastMsg;
    Toast myToast;
    int duration,score;
    Intent GoToSA;
    String userChoice;
    String correctAnss;
    Questions q1,q2,q3,q4,q5,q6,q7,q8,q9,q10, currentq;
    Questions[] questionss;
    int currentIndex;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WrongBTN1 = (RadioButton) findViewById(R.id.WrongBTN1);
        currentIndex = 0;
        currentq = q1;
        q1 = new Questions("You're lost in a graveyard at midnight all by yourself. And you see a tall figure in the shodaw;s looking at you with white eyes. What do you do?",);
        q2 = new Questions("If you hear tapping on your window at night and turn to see a figure looking at you what will you do?",);
        q3 = new Questions("There’s a man following you and as you start to walk fast and he starts running at you, what's your next move?",);
        q4 = new Questions("You’re trapped in a cabin with two famous horror movie characters: Jason Voorhees from Friday the 13th and Freddy Krueger from A Nightmare on Elm Street. You have to choose one to face, knowing you may survive",);
        q5 = new Questions("You’re wandering through the Texas countryside when you encounter Leatherface from The Texas Chainsaw Massacre. You spot two ways to escape?",);
        q6 = new Questions("You wake up chained in a dark room, and Jigsaw** fromSaw* gives you four choices to escape?",);
        q7 = new Questions("You’re stuck in a creepy hotel, and Jack Torrance from The Shining is coming after you with an axe. You see two possible exits?",);
        q8 = new Questions("You find yourself in a rural area where The Creeper from Jeepers Creepers is hunting for his next victim. You have two ways to escape?",);
        q9 = new Questions("You’re in a haunted house, and The Babadook is lurking in the shadows. You have two options to survive?",);
        q10 = new Questions("You’re being stalked by The Predator in a dense jungle. You have two options for survival?",);
        questionss = new Questions[] {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};
        WrongBTN2 = (RadioButton) findViewById(R.id.WrongBTN2);
        NextBTN = (Button) findViewById(R.id.NextBTN);
        QuestiovTv = (TextView) findViewById(R.id.QuestiovTv);
        toastMsg = "You Got it Correct";


        NextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                duration = Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

                if (currentIndex == 9) {
                    GoToSA = new Intent(MainActivity.this, ScoreActivity.class);
                    GoToSA.putExtra("score",score);
                    startActivity(GoToSA);

                }
                else {
                    currentIndex++;
                    currentq = questionss[currentIndex];
                    QuestiovTv.setText(currentq.getqText());

                }


            }
        });
        



        }
    }