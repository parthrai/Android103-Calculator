package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void greetingsBtnClick(View view){

        // 1. Grab the value of the text box

        EditText name = (EditText)findViewById(R.id.txtName);


        // 2. show the greeting msg

        TextView greetingsLbl = (TextView) findViewById(R.id.greetingMsg);

        greetingsLbl.setText("Welcome "+ name.getText());
    }
}
