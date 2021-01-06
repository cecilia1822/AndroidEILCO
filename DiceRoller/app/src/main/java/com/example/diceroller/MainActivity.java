package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On déclare une variable bouton qui prend les caractéristiques du button avec l'id "button"
        Button rollButton = (Button) findViewById(R.id.button);

        // On donne à ce boutton une action quand on clique dessus
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //On déclare une variable EditText qui prend les caractéristiques du EditText avec l'id "EditText"
                TextView total4 = (EditText)findViewById(R.id.EditText);
                //On récupére le contenue de l'éditText et on le met dans une variable String
                String value= total4.getText().toString();
                //On transforme la variable récupérer en entien pour pouvoir l'utiliser plus tard
                int finalValue=Integer.parseInt(value);


                //On crée le un nombre aléatoire compris entre 1 et le nombre entrer dans l'Edit Text
                double nombre1 = Math.floor(Math.random() * ( finalValue - 1) +1 );
                //On récupère la partie entière des nombre pour qu'il affiche que des nombre entier
                int nombre = (int)nombre1;

                //On déclare une variable TextView qui prend les caractéristiques du TextView avec l'id "TextView"
                TextView total = (TextView )findViewById(R.id.TextView);
                //On affiche ensuitre le nombre obtenue aléatoirement dans le TextView récupérer dans la variable plus haut
                total.setText(String.valueOf( nombre ));



                //On refait pareil pour le deuxième TextView


                //On crée le un nombre aléatoire compris entre 1 et le nombre entrer dans l'Edit Text
                double nombre2 = Math.floor(Math.random() * ( finalValue - 1 ) +1);
                //On récupère la partie entière des nombre pour qu'il affiche que des nombre entier
                int nombre3 = (int)nombre2;

                //On déclare une variable TextView qui prend les caractéristiques du TextView avec l'id "TextView1"
                TextView total3 = (TextView )findViewById(R.id.TextView1);
                //On affiche ensuitre le nombre obtenue aléatoirement dans le TextView récupérer dans la variable plus haut
                total3.setText(String.valueOf( nombre3 ));


                    Toast toast = Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT);
                    toast.show();





            }
        });



    }


}