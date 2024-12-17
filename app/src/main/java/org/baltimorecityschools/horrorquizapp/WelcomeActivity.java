package org.baltimorecityschools.horrorquizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    Button srtBTN,conBTN;
    Intent GoToMenu;
    EditText userNET;
    String name;
    String greet;
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
                GoToMenu = new Intent(WelcomeActivity.this, MainActivity.class );
                startActivity(GoToMenu);
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