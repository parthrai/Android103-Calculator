package com.example.android103_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateResult(View v){

        // 1. Grab the data from text box

        EditText ed_numbers = (EditText) findViewById(R.id.txtNumbers);
        String numbers = ed_numbers.getText().toString(); // 2+2+100+43+99 => 221004399  =246

        String[] arr_numbers = numbers.split("\\+");

        int result = 0 ;

        for(int i = 0; i < arr_numbers.length; i++){

            result = result + Integer.parseInt(arr_numbers[i]);
        }

        TextView output = (TextView) findViewById(R.id.lblResult);

        output.setText(Integer.toString(result));
    }

    public void selectNumber(View v){
        //1. Grab the values from EditText

        EditText ed_numbers = (EditText)findViewById(R.id.txtNumbers);
        String numbers = ed_numbers.getText().toString();

        //2. Determine which number was pressed

        switch (v.getId()){
            case R.id.btn0:
                numbers = numbers + Integer.toString(0);
                break;
            case R.id.btn1:
                numbers = numbers + Integer.toString(1);
                break;
            case R.id.btn2:
                numbers = numbers + Integer.toString(2);
                break;
            case R.id.btn3:
                numbers = numbers + Integer.toString(3);
                break;
            case R.id.btn4:
                numbers = numbers + Integer.toString(4);
                break;
            case R.id.btn5:
                numbers = numbers + Integer.toString(5);
                break;
            case R.id.btn6:
                numbers = numbers + Integer.toString(6);
                break;
            case R.id.btn7:
                numbers = numbers + Integer.toString(7);
                break;

            case R.id.btn8:
                numbers = numbers + Integer.toString(8);
                break;

            case R.id.btn9:
                numbers = numbers + Integer.toString(9);
                break;

            case R.id.btnClear:
                numbers = "";
                break;

            case R.id.btnAdd:
                if(numbers.charAt(numbers.length() - 1) != '+') {


                    String[] arr_numbers = cleanData(numbers);

                    int result = Integer.parseInt(arr_numbers[0]) ;

                    for(int i = 1; i < arr_numbers.length; i++){

                        result = result + Integer.parseInt(arr_numbers[i]);
                    }

                    numbers = result + "+";
                }
                break;

            case R.id.btnSub:
                if(numbers.charAt(numbers.length() - 1) != '-') {


                    String[] arr_numbers = cleanData(numbers);

                    int result = Integer.parseInt(arr_numbers[0]) ;


                    for(int i = 1; i < arr_numbers.length; i++){

                        result = result - Integer.parseInt(arr_numbers[i]);
                    }

                    numbers = result + "-";
                }
                break;
        }

        //3. Append the value for EditText
        ed_numbers.setText(numbers);

    }

    public String[] cleanData(String numbers){ //10 + 2- => [10,2]


        String[] arr = numbers.split("[-+]");


        return arr;

    }
}
