package com.example.apcsa_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.Integer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameOne extends AppCompatActivity {
    int guess;
    int answer = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    int tries = 0;
    int score = 0;
    public void returnHome(View v)
    {

        EditText text = (EditText) findViewById(R.id.editTextNumber);
        String temp = text.getText().toString();
        Log.i("info", "Temp holds: " + temp);
        guess = Integer.parseInt(temp);
        tries++;

        if (guess < answer)
        {
            Toast.makeText(this, "TOO LOW!", Toast.LENGTH_SHORT).show();


        } else if (guess > answer)
        {
            Toast.makeText(this, "TOO HIGH!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "YOU GOT IT!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(GameOne.this, Screen3.class));
        }

    }
}
