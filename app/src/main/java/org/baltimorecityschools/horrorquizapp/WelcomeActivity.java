package org.baltimorecityschools.horrorquizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

public class WelcomeActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "org.codeintheschools.android.unit3_lesson1_a";


    Button srtBTN,conBTN;
    Intent GoToMenu;
    EditText userNET;
    String name;
    TextView NameLtt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        srtBTN = (Button) findViewById(R.id.strtBTN);
        userNET = (EditText) findViewById(R.id.userBTN);
        conBTN = (Button) findViewById(R.id.confBTN);
        NameLtt = (TextView) findViewById(R.id.NameLtL);


        srtBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = userNET.getText().toString().trim();

                if (!username.isEmpty()) {
                    mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putString("username", username);
                    editor.apply();

                    GoToMenu = new Intent(WelcomeActivity.this, MainActivity.class );
                    startActivity(GoToMenu);
                }


            }
        });

        conBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = userNET.getText().toString();
                NameLtt.setText("Welcome " + name);
            }
        });



    }
}