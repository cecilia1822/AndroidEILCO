package com.example.tdpokedex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


import com.airbnb.lottie.LottieAnimationView;

public class LoadingScreen extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.animation1);


        //rediriger vers "page1" après 5 secondes

        Runnable runnable = new Runnable() {
            @Override
            public void run(){
                //Démarrer une page
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //on finit l'activitée actuelle sinon elle sera en fond
                finish();

            }
        };

        // handler post delayed
        new Handler().postDelayed(runnable, 5000);


    }


}
