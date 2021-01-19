package com.example.newslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        //On déclare une variable bouton qui prend les caractéristiques du button avec l'id "button"
        Button rollButton1 = (Button) findViewById(R.id.buttondetail);

        Button rollButton2 = (Button) findViewById(R.id.buttonlogout);

        // On donne à ce boutton une action quand on clique dessus
        rollButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdetail = new Intent(getApplicationContext(), DetailsActivity.class);
                startActivity(intentdetail);


            }
        });

        rollButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlogout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentlogout);


            }
        });

        Button rollButton3 = (Button) findViewById(R.id.buttonSearch);

        // On donne à ce boutton une action quand on clique dessus
        rollButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
