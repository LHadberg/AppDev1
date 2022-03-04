package com.example.mobilapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NameActivity extends AppCompatActivity {
    public RadioGroup rgType;
    public RadioButton rbMother, rbFather, rbCat, rbDog;
    public EditText etEnterName;
    public Button btnSendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        rgType = findViewById(R.id.rgNameTypePicker);
        rbMother = findViewById(R.id.rbMother);
        rbFather = findViewById(R.id.rbFather);
        rbCat = findViewById(R.id.rbCat);
        rbDog = findViewById(R.id.rbDog);
        etEnterName = findViewById(R.id.etEnterName);
        btnSendName = findViewById(R.id.btnSendName);

        btnSendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                String nameString = "";
                if (rbMother.isChecked()) {
                    resultIntent.putExtra("name", rbMother.getText() + ": " + etEnterName.getText());
                } else if (rbFather.isChecked()) {
                    resultIntent.putExtra("name", rbFather.getText() + ": " + etEnterName.getText());
                } else if (rbCat.isChecked()) {
                    resultIntent.putExtra("name", rbCat.getText() + ": " + etEnterName.getText());
                } else if (rbDog.isChecked()) {
                    resultIntent.putExtra("name", rbDog.getText() + ": " + etEnterName.getText());
                }
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}