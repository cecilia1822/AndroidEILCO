package com.example.tdpokedex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface JsonPlaceHolderAPI1 {

    public static final String ENDPOINT = "https://pokeapi.co/api/v2/";
    public static final String ENDPOINT2 = " https://pokeapi.glitch.me/v1/";


    //Pour les générations de pokémon
    @GET("pokemon?")
    Call<Post> getPokemonGen(@Query("offset")int offset,@Query("limit")int limit);

    //Pour les détails sur les pokémons (la taille, le poids, etc...)
    @GET("/api/v2/pokemon/{id}")
    Call<PokemonFullData> getDetails(@Path("id")String Id);
    //Pour la description des pokémons
    @GET("/api/v2/pokemon-species/{id}")
    Call<PokemonFullData.Species> getSpecies(@Path("id")String Id);




/*
    @GET("pokemon/{id}")
    Call<List<PokemonFullData>> getPokemonsdetails(@Path("id") String id);

*/


/*
    @GET("/users/{user}/repos")
    List<Repo> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);
*/
/*
    @GET("/users/{user}/repos")
    listRepos(@Path("user") String user);


    @GET("/users/{user}/repos")
    List listRepos(@Path("user") String user);


    @GET("/users/{user}/repos")
    Call<List<Pokemon>> listRepos(@Path("user") String user);
*/

/*
    @GET("/search/repositories")
    Call<RepoItem> searchRepos(@Query("q") String query);
*/
        //  @GET("/search/repositories?q=language:java+location:lagos")
        // Call<RepoItem> getItems();



    }




/*
}
*/