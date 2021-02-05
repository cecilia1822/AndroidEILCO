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

import com.bumptech.glide.Glide;

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
        TextView PokeName,PokeDesc,PokeHeight,PokeWeight,PokeTypes;
        PokeName=findViewById(R.id.PokeName);
        PokeDesc=findViewById(R.id.PokeDesc);
        PokeHeight=findViewById(R.id.PokeSize);
        PokeWeight=findViewById(R.id.PokeWeight);
        PokeTypes=findViewById(R.id.PokeTypes);
        ImageView PokeImage = findViewById(R.id.PokeImage);






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

                PokeName.setText(detail.name);
                //PokeDesc.setText(detail.flavor_text.toString());
                PokeHeight.setText("Taille: "+detail.height.toString()+"m");
                PokeWeight.setText("Poids: "+detail.weight.toString()+"kg");
                PokeTypes.setText("Types: "+detail.types.toString());
                Glide.with(PageTest.this).load("https://pokeres.bastionbot.org/images/pokemon/"+Id+".png").into(PokeImage);
                Log.d("ezffzefzefze","feezfffffffffffffffffffffffffffffffffffffffffffff");

            }
            @Override
            public void onFailure(Call<PokemonFullData> call, Throwable t)
            {
                Log.d("ezffzefzefze","feezfffffffffffffffffffffffffffffffffffffffffffff");
            }

        });


        jsonPlaceHolderAPI1.getSpecies(Id).enqueue(new Callback<PokemonFullData.Species>() {
            @Override
            public void onResponse(Call<PokemonFullData.Species> call, Response<PokemonFullData.Species> response) {
                PokemonFullData.Species species = response.body();

                for(PokemonFullData.FlavorTextEntry lang : species.flavor_text_entries){
                    if(lang.language.name.equals("fr")){

                        PokeDesc.setText(lang.flavor_text.replace("\n"," "));
                        break;
                    }


                    PokeDesc.setText(species.flavor_text_entries.get(0).toString().replace("\n"," "));


                }

             /*PokeDesc.setText(species.flavor_text_entries.get(0).toString().replace("\n"," "));*/



            }
            @Override
            public void onFailure(Call<PokemonFullData.Species> call, Throwable t)
            {
                Log.d("ezffzefzefze","feezfffffffffffffffffffffffffffffffffffffffffffff");
            }

        });




    }


}
