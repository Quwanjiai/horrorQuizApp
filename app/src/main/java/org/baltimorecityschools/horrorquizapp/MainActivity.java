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
        q1 = new Questions("You're lost in a graveyard at midnight all by yourself. And you see a tall figure in the shodaw;s looking at you with white eyes. What do you do?",
                "C",
                "Approach the figure to ask if they can help you find your way",
                " Run in the opposite direction as fast as you can.",
                "Stay completely still and observe the figure for a moment",
                "Call out to the figure, trying to communicate.");

        q2 = new Questions("If you hear tapping on your window at night and turn to see a figure looking at you what will you do?",
                "B",
                "Open the window to see what the figure wants",
                "Turn off the lights and hide under the bed.",
                "Grab your phone to call for help.",
                "Stay silent and watch the figure closely.");

        q3 = new Questions("There’s a man following you and as you start to walk fast and he starts running at you, what's your next move?","A",
                " Run in the opposite direction as fast as you can",
                "Turn around and confront him, asking what he wants.",
                "Look for a nearby place to hide, like a store or alley.",
                "Yell for help to attract attention.");

        q4 = new Questions("You’re trapped in a cabin with two famous horror movie characters: Jason Voorhees from Friday the 13th and Freddy Krueger from A Nightmare on Elm Street. You have to choose one to face, knowing you may survive",
                "A",
                "Face Jason Voorhees in the cabin",
                "Confront Freddy Krueger in your dreams",
                "Try to escape the cabin through a window",
                " Attempt to negotiate with one of them for your life.");

        q5 = new Questions("You’re wandering through the Texas countryside when you encounter Leatherface from The Texas Chainsaw Massacre. You spot two ways to escape?",
                "D",
                "Hide in a nearby thicket of trees",
                "Climb a fence to get to a neighboring property",
                "Try to reason with Leatherface, hoping he’ll let you go",
                "Run down the open dirt road where you might find help.");

        q6 = new Questions("You wake up chained in a dark room, and Jigsaw** fromSaw* gives you four choices to escape?",
                "C",
                "Solve a series of puzzles he has laid out for you",
                "Attempt to break the chains using any nearby tools",
                "Follow the instructions of a recorded message from Jigsaw",
                "Call out for help, hoping someone will hear you.");

        q7 = new Questions("You’re stuck in a creepy hotel, and Jack Torrance from The Shining is coming after you with an axe. You see 4 possible exits?",
                "B",
                " The emergency exit door down the hall.",
                "The snow-covered maze outside.",
                "A window you could break to escape.",
                "A staircase leading to the upper floors.");

        q8 = new Questions("You find yourself in a rural area where The Creeper from Jeepers Creepers is hunting for his next victim. You have two ways to escape?",
                "D",
                "Hide in a nearby barn and wait for him to leave.",
                "Try to find a vehicle and drive away.",
                "Climb onto the roof of a house to get a better vantage point.",
                "Run into the dense woods to find shelter.");

        q9 = new Questions("You’re in a haunted house, and The Babadook is lurking in the shadows. You have two options to survive?",
                "B",
                "Confront The Babadook and try to reason with it.",
                "Find a way to banish it using items from the house",
                "Hide in a closet and stay silent.",
                "Search for a way out through the back door");

        q10 = new Questions("You’re being stalked by The Predator in a dense jungle. You have two options for survival?",
                "A",
                "Cover yourself in ,ud to mask your heat signature",
                "Hide in the trees and stay silent",
                "Set traps using vine and rocks",
                "Run around yelling like a fool");
        
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

    public String CHeckuser(String userchoice, String correct) {
        if (userchoice.equals(correct)){
            score+=9;
            toastMsg = "you got ir correct";
        }
        else {
            toastMsg = "loser you got it wrong";
        }
        return userchoice;
    }
}