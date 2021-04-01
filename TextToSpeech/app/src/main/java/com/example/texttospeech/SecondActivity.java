package com.example.texttospeech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv  = (TextView) findViewById(R.id.textView4);

       // tv.setText(getIntent().getStringExtra("name"));
        tv.setText("HHHHHHH");


        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");

        tv.setText(name);

    }


    public void SwitchActivity(View view){

        Intent in = new Intent(SecondActivity.this,MainActivity.class);

        startActivity(in);
    }
}
