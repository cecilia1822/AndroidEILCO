package com.example.tdpokedex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface JsonPlaceHolderAPI1 {

    public static final String ENDPOINT = "https://pokeapi.co/api/v2/";
    public static final String ENDPOINT2 = " https://pokeapi.glitch.me/v1/";
    public String Id = null;

    @GET("pokemon?offset=0+&limit=151")
        Call<Post> getPokemonGen1() ;
    @GET("/api/v2/pokemon/{id}")
    Call<PokeDetail> getDetails(@Path("id")String Id);


    @GET("pokemon?offset=151&limit=251")
    Call<Post> getPokemonGen2();

    @GET("pokemon?offset=251&limit=386")
    Call<Post> getPokemonGen3();

    @GET("pokemon?offset=386&limit=493")
    Call<Post> getPokemonGen4();

    @GET("pokemon?offset=493&limit=649")
    Call<Post> getPokemonGen5();

    @GET("pokemon?offset=649&limit=721")
    Call<Post> getPokemonGen6();

    @GET("pokemon?offset=721&limit=809")
    Call<Post> getPokemonGen7();

    @GET("pokemon?offset=809&limit=898")
    Call<Post> getPokemonGen8();

    @GET("pokemon/{id}")
    Call<List<PokemonFullData>> getPokemonsdetails(@Path("id") String id);




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