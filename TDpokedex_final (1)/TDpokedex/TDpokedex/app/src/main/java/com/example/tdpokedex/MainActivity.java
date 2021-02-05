package com.example.tdpokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.helper.widget.Flow.HORIZONTAL;
import static com.example.tdpokedex.JsonPlaceHolderAPI1.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        //les boutons pour les générations

        Button butGen1 = findViewById(R.id.button1);
        Button butGen2 = findViewById(R.id.button2);
        Button butGen3 = findViewById(R.id.button3);
        Button butGen4 = findViewById(R.id.button4);
        Button butGen5 = findViewById(R.id.button5);
        Button butGen6 = findViewById(R.id.button6);
        Button butGen7 = findViewById(R.id.button7);
        Button butGen8 = findViewById(R.id.button8);

        butGen1.setOnClickListener(this); //action des boutons sur la MainActivity
        butGen2.setOnClickListener(this);
        butGen3.setOnClickListener(this);
        butGen4.setOnClickListener(this);
        butGen5.setOnClickListener(this);
        butGen6.setOnClickListener(this);
        butGen7.setOnClickListener(this);
        butGen8.setOnClickListener(this);


         ArrayList<Pokemon> listpokemon = new  ArrayList<Pokemon>();


        //Utilisation de l'appel API concernant les générations de pokémon

        JsonPlaceHolderAPI1 jsonPlaceHolderAPI1 = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JsonPlaceHolderAPI1.class);

        //paramètre pour l'appel des générations
        int offset=0; //curseur de début
        int limit=151; // nombre de pokémon récupéré à partir du curseur



        jsonPlaceHolderAPI1.getPokemonGen(offset,limit).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                assert response.body() != null;
                


                for (Pokemon pokemon:response.body().getResults()) {

                    listpokemon.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                }
                if( !listpokemon.isEmpty())
                {
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3); //on aura 3 pokémons par ligne car on a partagé notre layout en 3 colonnes
                    recyclerView.setLayoutManager(layoutManager);

                    PokemonListAdapter adapter = new PokemonListAdapter(listpokemon);
                    recyclerView.setAdapter(adapter);
                }


            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Log.d("404","error");
            }


        });




    }

    // switch case en 8



    @Override
    public void onClick(View view) {

        //Déclaration des boutons

        Button butGen1 = findViewById(R.id.button1);
        Button butGen2 = findViewById(R.id.button2);
        Button butGen3 = findViewById(R.id.button3);
        Button butGen4 = findViewById(R.id.button4);
        Button butGen5 = findViewById(R.id.button5);
        Button butGen6 = findViewById(R.id.button6);
        Button butGen7 = findViewById(R.id.button7);
        Button butGen8 = findViewById(R.id.button8);


        switch (view.getId()){




            //début cas 1
            case R.id.button1:
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon = new  ArrayList<Pokemon>();



                //initialisation des couleurs des boutons en fonction du cas actif
                butGen1.setTextColor(Color.RED);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.WHITE);




                int offset=0;
                int limit=151;

                JsonPlaceHolderAPI1 jsonPlaceHolderAPI1 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);




                jsonPlaceHolderAPI1.getPokemonGen(offset,limit).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;



                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon);
                            recyclerView.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });



                break;


            //début cas 2
            case R.id.button2:



                RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon2 = new  ArrayList<Pokemon>();



                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.RED);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.WHITE);



                int offset2=151;
                int limit2=100;

                JsonPlaceHolderAPI1 jsonPlaceHolderAPI12 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);



                jsonPlaceHolderAPI12.getPokemonGen(offset2,limit2).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;
                        List<Pokemon> pokemons = response.body().getResults();
                        /*recyclerAdapterpics.setpokemons(pokemons,debut,fin);*/


                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon2.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon2.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView2.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon2);
                            recyclerView2.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });


                break;



            //début cas 3
            case R.id.button3:


                RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon3 = new  ArrayList<Pokemon>();


                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.RED);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.WHITE);




                JsonPlaceHolderAPI1 jsonPlaceHolderAPI13 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);

                int offset3=251;
                int limit3=135;



                jsonPlaceHolderAPI13.getPokemonGen(offset3,limit3).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;


                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon3.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon3.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView3.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon3);
                            recyclerView3.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });


                break;



            //début cas 4
            case R.id.button4:


                RecyclerView recyclerView4 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon4 = new  ArrayList<Pokemon>();


                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.RED);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.WHITE);



                JsonPlaceHolderAPI1 jsonPlaceHolderAPI14 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);

                int offset4=386;
                int limit4=108;



                jsonPlaceHolderAPI14.getPokemonGen(offset4,limit4).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;


                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon4.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon4.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView4.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon4);
                            recyclerView4.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });

                break;


            //début cas 5
            case R.id.button5:


                RecyclerView recyclerView5 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon5 = new  ArrayList<Pokemon>();

                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.RED);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.WHITE);


                JsonPlaceHolderAPI1 jsonPlaceHolderAPI15 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);

                int offset5=494;
                int limit5=155;



                jsonPlaceHolderAPI15.getPokemonGen(offset5,limit5).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;


                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon5.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon5.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView5.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon5);
                            recyclerView5.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });

                break;



             //début cas 6
            case R.id.button6:


                RecyclerView recyclerView6 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon6 = new  ArrayList<Pokemon>();

                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.RED);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.WHITE);


                JsonPlaceHolderAPI1 jsonPlaceHolderAPI16 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);

                int offset6=649;
                int limit6=72;



                jsonPlaceHolderAPI16.getPokemonGen(offset6,limit6).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;


                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon6.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon6.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView6.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon6);
                            recyclerView6.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });

                break;


                //début cas 7
            case R.id.button7:


                RecyclerView recyclerView7 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon7 = new  ArrayList<Pokemon>();


                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.RED);
                butGen8.setTextColor(Color.WHITE);



                JsonPlaceHolderAPI1 jsonPlaceHolderAPI17 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);

                int offset7=721;
                int limit7=88;



                jsonPlaceHolderAPI17.getPokemonGen(offset7,limit7).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;


                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon7.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon7.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView7.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon7);
                            recyclerView7.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });

                break;


            //début cas 8
            case R.id.button8:



                RecyclerView recyclerView8 = (RecyclerView) findViewById(R.id.recycler);
                ArrayList<Pokemon> listpokemon8 = new  ArrayList<Pokemon>();


                butGen1.setTextColor(Color.WHITE);
                butGen2.setTextColor(Color.WHITE);
                butGen3.setTextColor(Color.WHITE);
                butGen4.setTextColor(Color.WHITE);
                butGen5.setTextColor(Color.WHITE);
                butGen6.setTextColor(Color.WHITE);
                butGen7.setTextColor(Color.WHITE);
                butGen8.setTextColor(Color.RED);



                JsonPlaceHolderAPI1 jsonPlaceHolderAPI18 = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderAPI1.class);

                int offset8=809;
                int limit8=88;



                jsonPlaceHolderAPI18.getPokemonGen(offset8,limit8).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        assert response.body() != null;



                        for (Pokemon pokemon:response.body().getResults()) {

                            listpokemon8.add(new Pokemon(pokemon.getName(),pokemon.getUrl()));
                        }
                        if( !listpokemon8.isEmpty())
                        {
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
                            recyclerView8.setLayoutManager(layoutManager);

                            PokemonListAdapter adapter = new PokemonListAdapter(listpokemon8);
                            recyclerView8.setAdapter(adapter);
                        }


                    }
                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }

                });

                break;




        }

    }


}