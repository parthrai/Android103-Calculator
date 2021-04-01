package com.example.android102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnResult(View v){
        //1. Grab the value for TextBox 1

        EditText numA = (EditText)findViewById(R.id.txtNumA);

        //2. Grab the value for TextBox 2

        EditText numB = (EditText)findViewById(R.id.txtNumB);



        //3. Show the result in TextView (Label)

        TextView result = (TextView)findViewById(R.id.lblResult);

        if(numA.getText().toString().equals("") || numB.getText().toString().equals("")){
            result.setText("Please enter valid values.");
            return;
        }

        float answer = 0;

        switch (v.getId()){

            case R.id.btnAdd:
                 answer = Integer.parseInt(numA.getText().toString()) + Integer.parseInt(numB.getText().toString());
                break;
            case R.id.btnMulti:
                 answer = Integer.parseInt(numA.getText().toString()) * Integer.parseInt(numB.getText().toString());
                break;
            case R.id.btnSub:
                answer = Integer.parseInt(numB.getText().toString()) - Integer.parseInt(numA.getText().toString());
                break;
            case R.id.btnDivide:
                answer = Float.parseFloat(numA.getText().toString()) / Float.parseFloat(numB.getText().toString());
                break;

        }


        result.setText(Float.toString(answer));


    }


}
