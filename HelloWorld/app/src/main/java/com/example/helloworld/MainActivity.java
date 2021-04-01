package com.example.helloworld;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private TextToSpeech mTTs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    mTTs.setLanguage(Locale.CHINA);


                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


    }


    public void BtnClick(View myviw){

        String text ="hello, how are you ";


        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH, null);








    }


}
