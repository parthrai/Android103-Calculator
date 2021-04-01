package com.example.texttospeech;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                tts.setLanguage(Locale.US);
            }
        });

        Toast.makeText(this,"I am inside onCreate",Toast.LENGTH_LONG).show();

        Log.i("$$$$$$$$$$$$$$","I am inside onCreate");



    }


    @Override
    protected void onStart() {
        super.onStart();

       Toast.makeText(this,"I am inside onStart",Toast.LENGTH_LONG).show();

      Log.i("$$$$$$$$$$$$$$","I am inside onState");


    }

    @Override
    protected void onResume() {
        super.onResume();

        tts.speak("Inside on resume",TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("$$$$$$$$$$$$$$","I am inside onPause");

       // tts.speak("Inside on pause",TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("$$$$$$$$$$$$$$","I am inside onStop");

       // tts.speak("Bye",TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("$$$$$$$$$$$$$$","I am inside onDestroy");

       // tts.speak("destroyed",TextToSpeech.QUEUE_FLUSH,null);


    }

    public void play(View v){


        if(tts.isSpeaking()){
            return;
        }


        int clicked = v.getId();

        Set<String> a=new HashSet<>();

        if(clicked == R.id.btnFemale){

            a.add("female");//here you can give male if you want to select mail voice.
            Voice voice=new Voice("en-us-x-sfg#female_2-local",new Locale("en","US"),400,200,true,a);
            tts.setVoice(voice);

        }else{
            a.add("male");//here you can give male if you want to select mail voice.
            Voice voice=new Voice("en-ind-x-sfg#male_2-local",new Locale("en","IND"),400,200,true,a);
            tts.setVoice(voice);

        }


        EditText textToSpeak = (EditText) findViewById(R.id.ETtext);

        SeekBar pitch = (SeekBar) findViewById(R.id.SBpitch);
        float pitchVal = (float) pitch.getProgress()/50;

        SeekBar rate = (SeekBar) findViewById(R.id.SBRate);
        float rateVal = (float) rate.getProgress()/50;

        tts.setPitch(pitchVal);
        tts.setSpeechRate(rateVal);





        tts.speak(textToSpeak.getText().toString(), TextToSpeech.QUEUE_FLUSH,null);
    }



    public void SwitchActivity(View view){

        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("name ","John Doe");
        startActivity(i);
    }



}
