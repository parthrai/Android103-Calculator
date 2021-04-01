package com.example.images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void changeImage(View v){

        ImageView img = (ImageView) findViewById(R.id.IVJeep);

        int btnClicked = v.getId();

        if(btnClicked == R.id.btnBlack){
            img.setImageResource(R.mipmap.black);
        }

        else if(btnClicked == R.id.btnRed){
            img.setImageResource(R.mipmap.red);
        }

        else if(btnClicked == R.id.btnWhite){
            img.setImageResource(R.mipmap.white);
        }

    }

//    public void changeImageRed(View v){
//
//        ImageView img = (ImageView) findViewById(R.id.IVJeep);
//
//        img.setImageResource(R.mipmap.red);
//    }
//
//    public void changeImageBlack(View v){
//
//        ImageView img = (ImageView) findViewById(R.id.IVJeep);
//
//        img.setImageResource(R.mipmap.black);
//    }
}
