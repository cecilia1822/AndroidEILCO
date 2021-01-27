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
        PokeTypes=findViewById(R.id.PokeType);
        ImageView PokeImage = findViewById(R.id.PokeImage);






        JsonPlaceHolderAPI1 jsonPlaceHolderAPI1 = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JsonPlaceHolderAPI1.class);

        jsonPlaceHolderAPI1.getDetails(Id).enqueue(new Callback<PokeDetail>() {
            @Override
            public void onResponse(Call<PokeDetail> call, Response<PokeDetail> response) {
                assert response.body() != null;
                PokeDetail detail = response.body();

                PokeName.setText(detail.name);
                //PokeDesc.setText(detail.de);
                //PokeHeight.setText(detail.height);
                //PokeWeight.setText(detail.weight);
                PokeTypes.setText(detail.types.toString());
                Glide.with(PageTest.this).load("https://pokeres.bastionbot.org/images/pokemon/"+Id+".png").into(PokeImage);
                Log.d("ezffzefzefze","feezfffffffffffffffffffffffffffffffffffffffffffff");

            }
            @Override
            public void onFailure(Call<PokeDetail> call, Throwable t)
            {
                Log.d("ezffzefzefze","feezfffffffffffffffffffffffffffffffffffffffffffff");
            }

        });


    }


}
