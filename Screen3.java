package com.example.apcsa_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    int added;
    ArrayList<Integer> arr = new ArrayList<Integer>();

    public void addClick(View v)
    {
        EditText text = findViewById(R.id.editTextNumber2);
        String temp = text.getText().toString();
        added = Integer.parseInt(temp); //gets each int from the input

        arr.add(added);//adds the int to the ArrayList
        Toast.makeText(this, "Added: "+ added, Toast.LENGTH_SHORT).show();


        text.setText("");

    }

    public void onSort(View v)//when pressed will sort the array
    {

        int n = arr.size();
        for (int i = 1; i < n; i++)//sorts the Array from Least to Greatest using Insertion sort algorithm
        {
            int temp = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > temp)//(differnt loop type)
            {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, temp);


            String theString = "";
            for(int item: arr)//adds each item from the ArrayList to a string
            {
                theString += item+", ";
            }
            TextView output = (TextView) findViewById(R.id.textView7);
            output.setText(theString);//adds the string to the textView so it will show
        }
    }
    public void check(View v)
    {
        String result="This Array Does Not contain a 16";
        for(int item: arr)//runs through the array and checks if there is a 16.
        {
            if (item==16)//if inside the context of a loop
            {
                result = "This array does contain a 16";
            }

        }
        TextView output = (TextView) findViewById(R.id.textView7);
        output.setText(result);
    }
    public void LastScreen(View v)
    {
        startActivity(new Intent(Screen3.this, FinalScreen.class));
    }
}
