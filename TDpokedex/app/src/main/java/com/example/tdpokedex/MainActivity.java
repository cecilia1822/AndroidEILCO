package com.example.tdpokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import android.os.Handler;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.helper.widget.Flow.HORIZONTAL;
import static com.example.tdpokedex.JsonPlaceHolderAPI1.*;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        //lottieAnimationView = findViewById(R.id.);

         ArrayList<Pokemon> listpokemon = new  ArrayList<Pokemon>();

        /*textView = findViewById(R.id.my_text1);*/


        //partie test

      /*  Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderAPItest jsonPlaceHolderApitest = retrofit.create(JsonPlaceHolderAPItest.class);
        Call<List<PostTest>> call = jsonPlaceHolderApitest.getPosts();
        call.enqueue(new Callback<List<PostTest>>() {
            @Override
            public void onResponse(Call<List<PostTest>> call, Response<List<PostTest>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }
                List<PostTest> posts = response.body();
                for (PostTest post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    textView.append(content);
                }



            }

            @Override
            public void onFailure(Call<List<PostTest>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });*/

        //partie normale



        JsonPlaceHolderAPI1 jsonPlaceHolderAPI1 = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JsonPlaceHolderAPI1.class);


        // switch case  en 8 à faire avec osef == 0;
        //


        jsonPlaceHolderAPI1.getPokemonGen1().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                assert response.body() != null;
                List<Pokemon> pokemons = response.body().getResults();
                /*recyclerAdapterpics.setpokemons(pokemons,debut,fin);*/
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




        //rediriger vers "page1" après 5 secondes

      /*  Runnable runnable = new Runnable() {
            @Override
            public void run(){
            //Démarrer une page
            Intent intent = new Intent(getApplicationContext(),Page1.class);
            startActivity(intent);
            //on finit l'activitée actuelle sinon elle sera en fond
            finish();

            }
        };*/

        // handler post delayed
       // new Handler().postDelayed(runnable, 5000);

    }
}