package com.example.newslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());

        //On déclare une variable bouton qui prend les caractéristiques du button avec l'id "button"
        Button rollButton = (Button) findViewById(R.id.buttonLogin);

        // On donne à ce boutton une action quand on clique dessus
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);


            }
        });







    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
