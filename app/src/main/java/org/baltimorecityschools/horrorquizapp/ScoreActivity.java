package org.baltimorecityschools.horrorquizapp;

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

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    int score;
    Intent welcomeSA;
    Button sendEM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = findViewById(R.id.scoreTV);
        welcomeSA = getIntent();
        score = welcomeSA.getIntExtra("score",0);
        scoreTV.setText("" + score);

        sendEM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[] {"daquanaplo@gmail.com"};
                String subject = "New Score on the Horror Quiz App";
                String body = "Score on your quiz";
                composeEmail(addresses, subject);
            }
        });
    }

    private  void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("maitlto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}