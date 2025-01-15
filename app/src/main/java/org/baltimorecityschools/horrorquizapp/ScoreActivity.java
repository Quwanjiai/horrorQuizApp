package org.baltimorecityschools.horrorquizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "org.codeintheschools.android.unit3_lesson1_a";

    ArrayList<HighScoreEN> players;

    HighScoreEN player;

    TextView scoreTV;
    int score;
    int sc1,sc2,sc3,sc4,sc5,sc6;
    Intent welcomeSA,GoToMenu;;
    Button sendEM,sendHB,rrBTN;
    HighScoreEN p1,p2,p3,p4,p5;
    TextView pt1,pt2,pt3,pt4,pt5,title;
    String plr1,plr2,plr3,plr4,plr5,plr6;
    String username;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        sc1 = 0;
        sc2 = 0;
        sc3 = 0;
        sc4 = 0;
        sc5 = 0;
        sc6 = 0;

        plr1 = "";
        plr2 = " ";
        plr3 = "";
        plr4 = "";
        plr5 = "";
        plr6 = "";

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("highscore");

        players = new ArrayList<HighScoreEN>();

        pt1 = (TextView) findViewById(R.id.player1);
        pt2 = (TextView) findViewById(R.id.player2);
        pt3 = (TextView) findViewById(R.id.player3);
        pt4 = (TextView) findViewById(R.id.player4);
        pt5 = (TextView) findViewById(R.id.player5);

        scoreTV = findViewById(R.id.scoreTV);
        sendEM = findViewById(R.id.sendEM);
        welcomeSA = getIntent();
        rrBTN = (Button) findViewById(R.id.resetBTN);
        sendHB = (Button) findViewById(R.id.sendFBTN);
        score = welcomeSA.getIntExtra("score",0);
        scoreTV.setText("MY SCORE " + score);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        username = mPreferences.getString("username","player");

        sendEM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[] {"daquanaplo@gmail.com"};
                String subject = "New Score on the Horror Quiz App";
                String body = username + "\t" + "Score on your quiz "+ score;
                composeEmail(addresses, subject, body);


            }
        });

        sendHB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("highscore");

                p1 = new HighScoreEN(username,score);

                String key =myRef.push().getKey();
                myRef.child(key).setValue(p1);
            }
        });

        rrBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GoToMenu = new Intent(ScoreActivity.this, MainActivity.class );
                startActivity(GoToMenu);

                score = 0;
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot highscoreSnapShot : snapshot.getChildren()){
                    HighScoreEN myHighscoreHE = highscoreSnapShot.getValue(HighScoreEN.class);

                    Log.d("onDataChange()", "New Player" + myHighscoreHE.getNameRK());
                    players.add(myHighscoreHE);
                }

                Collections.sort(players);

                if (players.size()>0) {
                    player = players.get(0);
                    String line = player.getNameRK() + "\t"+ "    " + player.getScore();
                    pt1.setText(line);

                    if (players.size()>1) {
                        player = players.get(1);
                        line = player.getNameRK() + "\t"+ "    " + player.getScore();
                        pt2.setText(line);

                        if (players.size()>2){
                            player = players.get(2);
                            line = player.getNameRK() + "\t"+ "    " + player.getScore();
                            pt3.setText(line);

                            if (players.size()>3) {
                                player = players.get(3);
                                line = player.getNameRK() + "\t"+ "    " + player.getScore();
                                pt4.setText(line);

                                if (players.size()>4) {
                                    player = players.get(4);
                                    line = player.getNameRK() + "\t"+ "    " + player.getScore();
                                    pt5.setText(line);
                                }
                            }
                        }
                    }
                }



//                HighScoreEN highScoreEN = players.get(0);
//                String line = highScoreEN.getNameRK() + "\t"+ "    " + highScoreEN.getScore();
//                pt1.setText(line);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    private  void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}