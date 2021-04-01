package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add(View v){

        EditText name = (EditText) findViewById(R.id.txtname) ;
        EditText desc = (EditText) findViewById(R.id.txtdesc) ;

        DbHelper dbh = new DbHelper(this);

        boolean result = dbh.addUser(name.getText().toString(), desc.getText().toString());

        //onCall();

        if (result) {
            Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "UnSuccessfully", Toast.LENGTH_SHORT).show();
        }

    }


    public void list(View v){
        Intent i = new Intent(MainActivity.this,ListActivity.class);
        startActivity(i);
    }
}
