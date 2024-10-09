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

    RadioButton WrongBTN1,WrongBTN2,WrongBTN3,WrongBTN4;
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


        q1 = new Questions(getString(R.string.q1Text), "C",
                getString(R.string.q1ChoiceA),
                getString(R.string.q1ChoiceB),
                getString(R.string.q1ChoiceC),
                getString(R.string.q1ChoiceD));

        q2 = new Questions(getString(R.string.q2Text),
                "B",
                getString(R.string.q2ChoiceA),
                getString(R.string.q2ChoiceB),
                getString(R.string.q2ChoiceC),
                getString(R.string.q2ChoiceD));

        q3 = new Questions(getString(R.string.q3text),"A",
                getString(R.string.q3ChoiceA),
                getString(R.string.q3ChoiceB),
                getString(R.string.q3ChoiceC),
                getString(R.string.q3ChoiceD));

        q4 = new Questions(getString(R.string.q4text),
                "A",
                getString(R.string.q4ChoiceA),
                getString(R.string.q4ChoiceB),
                getString(R.string.q4ChoiceC),
                getString(R.string.q4ChoiceD));

        q5 = new Questions(getString(R.string.q5text),
                "D",
                getString(R.string.q5ChoiceA),
                getString(R.string.q5ChoiceB),
                getString(R.string.q5ChoiceC),
                getString(R.string.q5ChoiceD));

        q6 = new Questions(getString(R.string.q6text),
                "C",
                getString(R.string.q6ChoiceA),
                getString(R.string.q6ChoiceB),
                getString(R.string.q6ChoiceC),
                getString(R.string.q6ChoiceD));

        q7 = new Questions(getString(R.string.q7Text),
                "B",
                getString(R.string.q7ChoiceA),
                getString(R.string.q7ChoiceB),
                getString(R.string.q7ChoiceC),
                getString(R.string.q7ChoiceD));

        q8 = new Questions(getString(R.string.q8Text),
                "D",
                getString(R.string.q8ChoiceA),
                getString(R.string.q8ChoiceB),
                getString(R.string.q8ChoiceC),
                getString(R.string.q8ChoiceD));

        q9 = new Questions(getString(R.string.q9Text),
                "B",
                getString(R.string.q9ChoiceA),
                getString(R.string.q9ChoiceB),
                getString(R.string.q9ChoiceC),
                getString(R.string.q9ChoiceD));

        q10 = new Questions(getString(R.string.q10Text),
                "A",
                getString(R.string.q10ChoiceA),
                getString(R.string.q10ChoiceB),
                getString(R.string.q10ChoiceC),
                getString(R.string.q10ChoiceD));
        
        questionss = new Questions[] {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};
        WrongBTN2 = (RadioButton) findViewById(R.id.WrongBTN2);
        WrongBTN3 = (RadioButton) findViewById(R.id.WrongBTN3);
        WrongBTN4 = (RadioButton) findViewById(R.id.WrongBTN4);
        NextBTN = (Button) findViewById(R.id.NextBTN);
        QuestiovTv = (TextView) findViewById(R.id.QuestiovTv);
        toastMsg = getString(R.string.correct_msg);

        currentq = q1;
        QuestiovTv.setText(currentq.getqText());
        WrongBTN1.setText(currentq.getChoiceA());
        WrongBTN2.setText(currentq.getChoiceB());
        WrongBTN3.setText(currentq.getChoiceB());
        WrongBTN4.setText(currentq.getChoiceD());


        NextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                duration = Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();

                // checking if more questions are available
                if (currentIndex == 9) {
                    GoToSA = new Intent(MainActivity.this, ScoreActivity.class);
                    GoToSA.putExtra("score",score);
                    startActivity(GoToSA);

                } else {
                    // updates the radiobuttons questions
                    currentIndex++;
                    currentq = questionss[currentIndex];
                    QuestiovTv.setText(currentq.getqText());
                    WrongBTN1.setText(currentq.getChoiceA());
                    WrongBTN2.setText(currentq.getChoiceB());
                    WrongBTN3.setText(currentq.getChoiceB());
                    WrongBTN4.setText(currentq.getChoiceD());

                }

            }
        });

    }

    public String CHeckuser(String userchoice, String correct) {
        if (userchoice.equals(correct)){
            score+=9;
            toastMsg = getString(R.string.correct_msg);
        }
        else {
            toastMsg = getString(R.string.wrong_msg);
        }
        return userchoice;
    }

}