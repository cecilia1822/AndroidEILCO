package com.example.tdpokedex;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderAPItest {

    @GET("todos/1")
    Call<List<PostTest>> getPosts();

}
