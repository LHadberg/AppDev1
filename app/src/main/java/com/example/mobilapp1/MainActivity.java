package com.example.mobilapp1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Create fields for components
    private Button btnGetName, btnGetColor;
    private TextView txtPlaceHolder;
    private String chosenType;
    private String chosenName;
    private String chosenColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get component IDs
        btnGetName = findViewById(R.id.btnGetOnesName);
        btnGetColor = findViewById(R.id.btnGetOnesColor);
        txtPlaceHolder = findViewById(R.id.txtNamePlaceholder);

        //INITIAL VALUES
        chosenType = "";
        chosenName = "";

        //btnGetName Event Handlers
        ActivityResultLauncher<Intent> nameLauncher;
        nameLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        chosenName = result.getData().getStringExtra("name");
                        txtPlaceHolder.setText(chosenName);
                        Toast.makeText(MainActivity.this, "From NameActivity", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                nameLauncher.launch(intent);
            }
        });

        //btnGetColor Event Handlers
        ActivityResultLauncher<Intent> colorLauncher;
        colorLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        chosenColor = result.getData().getStringExtra("color");
                        txtPlaceHolder.setBackgroundColor(Color.parseColor(chosenColor));
                        Toast.makeText(MainActivity.this, "Color chosen: " + chosenColor, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnGetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("type", chosenType);
                 colorLauncher.launch(intent);
            }
        });
    }
}