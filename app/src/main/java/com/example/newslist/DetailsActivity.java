package com.example.newslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());

        Button rollButton2 = (Button) findViewById(R.id.buttonlogout);

        // On donne à ce boutton une action quand on clique dessus
        rollButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdetail = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intentdetail);


            }
        });
    }

}
