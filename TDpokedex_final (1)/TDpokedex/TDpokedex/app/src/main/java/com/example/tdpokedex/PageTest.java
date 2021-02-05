package com.example.tdpokedex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.example.tdpokedex.JsonPlaceHolderAPI1.ENDPOINT;

public class PageTest extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagetest);
        Intent intent = getIntent();
        String Id = intent.getStringExtra("Id");

        //Déclaration des textView que l'on va remplacer dans le layout
        TextView PokeName,PokeDesc,PokeHeight,PokeWeight,PokeTypes,PokeNum,ColorType;
        PokeName=findViewById(R.id.PokeName);
        PokeDesc=findViewById(R.id.PokeDesc);
        PokeHeight=findViewById(R.id.PokeSize);
        PokeWeight=findViewById(R.id.PokeWeight);
        PokeTypes=findViewById(R.id.PokeTypes);
        PokeNum=findViewById(R.id.PokedexNum);
        ColorType=findViewById(R.id.ColorType);
        ImageView PokeImage = findViewById(R.id.PokeImage);




        //Utilisation de l'appel API concernant les détails des pokémons

        JsonPlaceHolderAPI1 jsonPlaceHolderAPI1 = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JsonPlaceHolderAPI1.class);

        jsonPlaceHolderAPI1.getDetails(Id).enqueue(new Callback<PokemonFullData>() {
            @Override
            public void onResponse(Call<PokemonFullData> call, Response<PokemonFullData> response) {
                assert response.body() != null;
                PokemonFullData detail = response.body();


                PokeName.setText(detail.name.substring(0, 1).toUpperCase() + detail.name.substring(1).toLowerCase()); //on prend le nom du pokémon et on met en majuscule la première lettre
                PokeNum.setText("#"+detail.id); //on récupère le numéro pokédex


                //modification des couleurs en fonction du type du pokémon

                if(detail.types.toString().contains("[fire")){


                    ColorType.setBackgroundResource(R.drawable.arrondi);


                }


                if(detail.types.toString().contains("[grass")){


                    ColorType.setBackgroundResource(R.drawable.arrondi3);

                }



                if(detail.types.toString().contains("[water")){


                    ColorType.setBackgroundResource(R.drawable.arrondi4);

                }

                if(detail.types.toString().contains("[normal")){


                    ColorType.setBackgroundResource(R.drawable.arrondi5);

                }


                if(detail.types.toString().contains("[electric")){


                    ColorType.setBackgroundResource(R.drawable.arrondi6);

                }

                if(detail.types.toString().contains("[poison")){


                    ColorType.setBackgroundResource(R.drawable.arrondi7);

                }

                if(detail.types.toString().contains("[psychic")){


                    ColorType.setBackgroundResource(R.drawable.arrondi8);

                }

                if(detail.types.toString().contains("[ground")){


                    ColorType.setBackgroundResource(R.drawable.arrondi9);

                }

                if(detail.types.toString().contains("[rock")){


                    ColorType.setBackgroundResource(R.drawable.arrondi10);

                }


                if(detail.types.toString().contains("[dragon")){


                    ColorType.setBackgroundResource(R.drawable.arrondi11);

                }


                if(detail.types.toString().contains("[ice")){


                    ColorType.setBackgroundResource(R.drawable.arrondi12);

                }

                if(detail.types.toString().contains("[bug")){


                    ColorType.setBackgroundResource(R.drawable.arrondi13);

                }

                if(detail.types.toString().contains("[ghost")){


                    ColorType.setBackgroundResource(R.drawable.arrondi14);

                }

                if(detail.types.toString().contains("[fighting")){


                    ColorType.setBackgroundResource(R.drawable.arrondi15);

                }




                PokeHeight.setText("Taille: "+detail.height.toString()+"m"); //on récupère la hauteur du pokémon
                PokeWeight.setText("Poids: "+detail.weight.toString()+"kg"); //on récupère le poids du pokémon
                PokeTypes.setText("Types: "+detail.types.toString()); //on récupère le type du pokémon
                Glide.with(PageTest.this).load("https://pokeres.bastionbot.org/images/pokemon/"+Id+".png").into(PokeImage); // on récupère l'image du pokémon


            }
            @Override
            public void onFailure(Call<PokemonFullData> call, Throwable t)
            {
                Log.d("404","error");
            }

        });


        //Utilisation de l'appel API concernant les pokemon-species surtout pour les descriptions

        jsonPlaceHolderAPI1.getSpecies(Id).enqueue(new Callback<PokemonFullData.Species>() {
            @Override
            public void onResponse(Call<PokemonFullData.Species> call, Response<PokemonFullData.Species> response) {
                PokemonFullData.Species species = response.body();

                for(PokemonFullData.FlavorTextEntry lang : species.flavor_text_entries){

                    //on récupère la description en français
                    if(lang.language.name.equals("fr")){

                        PokeDesc.setText(lang.flavor_text.replace("\n"," "));
                        break;
                    }


                    PokeDesc.setText(species.flavor_text_entries.get(0).toString().replace("\n"," ")); //on récupère le premier élément qui est la description et on retire les sauts de ligne insérés de base


                }



            }
            @Override
            public void onFailure(Call<PokemonFullData.Species> call, Throwable t)
            {
                Log.d("404","error");
            }

        });




    }


}
