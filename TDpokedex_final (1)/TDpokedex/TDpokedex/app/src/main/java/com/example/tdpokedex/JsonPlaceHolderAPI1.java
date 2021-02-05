package com.example.tdpokedex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface JsonPlaceHolderAPI1 {

    public static final String ENDPOINT = "https://pokeapi.co/api/v2/";



    //Pour les générations de pokémon
    @GET("pokemon?")
    Call<Post> getPokemonGen(@Query("offset")int offset,@Query("limit")int limit);

    //Pour les détails sur les pokémons (la taille, le poids, etc...)
    @GET("/api/v2/pokemon/{id}")
    Call<PokemonFullData> getDetails(@Path("id")String Id);
    //Pour la description des pokémons
    @GET("/api/v2/pokemon-species/{id}")
    Call<PokemonFullData.Species> getSpecies(@Path("id")String Id);



    }



