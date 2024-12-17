package org.baltimorecityschools.horrorquizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    int score;
    Intent welcomeSA;
    Button sendEM,sendHB;
    HighScoreEN p1,p2,p3,p4,p5,p6;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = findViewById(R.id.scoreTV);
        sendEM = findViewById(R.id.sendEM);
        welcomeSA = getIntent();
        sendHB = (Button) findViewById(R.id.sendFBTN);
        score = welcomeSA.getIntExtra("score",0);
        scoreTV.setText("MY SCORE " + score);

        sendEM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[] {"daquanaplo@gmail.com"};
                String subject = "New Score on the Horror Quiz App";
                String body = "Score on your quiz "+score;
                composeEmail(addresses, subject, body);


            }
        });

        sendHB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("User " + score);
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