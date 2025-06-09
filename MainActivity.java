package com.example.apcsa_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    String answer = "air";
    String guess;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void checkBtn(View v)
    {
        EditText riddle = findViewById(R.id.editTextText);
        guess = riddle.getText().toString();

        if(guess.equalsIgnoreCase(answer))
        {
            Toast.makeText(this, guess, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, GameOne.class));
        }
        else
        {
                Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
        }
    }
}
