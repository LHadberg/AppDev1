package com.example.mobilapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private Spinner spnRed, spnGreen, spnBlue;
    private View rectChosenColor;
    public String chosenRed, chosenGreen, chosenBlue;
    public Button btnSendColor;
    public TextView txtColorHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        //PROPS
        String type = getIntent().getStringExtra("type");

        //SET DEFAULT COLORS
        chosenRed = "00";
        chosenGreen = "00";
        chosenBlue = "00";

        //GET COMPONENTS BY IDs
        spnRed = findViewById(R.id.spnRedColor);
        spnGreen = findViewById(R.id.spnGreenColor);
        spnBlue = findViewById(R.id.spnBlueColor);
        rectChosenColor = findViewById(R.id.rect_chosen_color);
        btnSendColor = findViewById(R.id.btnSendColor);
        txtColorHeader = findViewById(R.id.txtColorHeader);

        //SET HEADER TEXT
        txtColorHeader.setText(type + " " + "Color");

        //DEFINE PICKER CHOICES
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("00");
        arrayList.add("10");
        arrayList.add("20");
        arrayList.add("30");
        arrayList.add("40");
        arrayList.add("50");
        arrayList.add("60");
        arrayList.add("70");
        arrayList.add("80");
        arrayList.add("90");
        arrayList.add("A0");
        arrayList.add("B0");
        arrayList.add("C0");
        arrayList.add("D0");
        arrayList.add("E0");
        arrayList.add("F0");
        arrayList.add("FF");

        //ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                ColorActivity.this,
                android.R.layout.simple_spinner_item,
                arrayList);

        //ADD ADAPTER CHOICES TO PICKERS
        spnRed.setAdapter(adapter);
        spnGreen.setAdapter(adapter);
        spnBlue.setAdapter(adapter);

        //SPINNER SELECTION CHANGE
        spnRed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String color = "red";

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Integer chosenColor = Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue);
                handleSpinnerSelection(color, spnRed.getSelectedItem().toString());
                rectChosenColor.setBackgroundColor(chosenColor);
                Toast.makeText(ColorActivity.this, "#" + chosenRed + chosenGreen + chosenBlue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                handleSpinnerSelection(color, "00");
                rectChosenColor.setBackgroundColor(Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue));
            }
        });
        spnGreen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String color = "green";

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Integer chosenColor = Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue);
                handleSpinnerSelection(color, spnGreen.getSelectedItem().toString());
                rectChosenColor.setBackgroundColor(Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue));
                Toast.makeText(ColorActivity.this, "#" + chosenRed + chosenGreen + chosenBlue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                handleSpinnerSelection(color, "00");
                rectChosenColor.setBackgroundColor(Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue));
            }
        });
        spnBlue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String color = "blue";

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Integer chosenColor = Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue);
                handleSpinnerSelection(color, spnBlue.getSelectedItem().toString());
                rectChosenColor.setBackgroundColor(Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue));
                Toast.makeText(ColorActivity.this, "#" + chosenRed + chosenGreen + chosenBlue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                handleSpinnerSelection(color, "00");
                rectChosenColor.setBackgroundColor(Color.parseColor("#" + chosenRed + chosenGreen + chosenBlue));
            }
        });
        btnSendColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = "#" + chosenRed + chosenGreen + chosenBlue;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("color", color);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    public void handleSpinnerSelection(String color, String hexFragment) {
        switch (color) {
            case "red":
                chosenRed = hexFragment;
                break;
            case "green":
                chosenGreen = hexFragment;
                break;
            case "blue":
                chosenBlue = hexFragment;
                break;

        }
    }

    ;
}