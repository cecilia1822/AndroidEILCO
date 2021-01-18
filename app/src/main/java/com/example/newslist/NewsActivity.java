package com.example.newslist;

import android.content.Intent;
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
        Button rollButton = (Button) findViewById(R.id.button);

        // On donne à ce boutton une action quand on clique dessus
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this, AutreActivity.class); startActivity(intent);


            }
        });
    }
}
