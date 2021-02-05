package com.example.tdpokedex;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class Post {

    /*Sérialiser un champ avec un nom différent au lieu d'un nom de champ réel*/
    @SerializedName("count")
    @Expose /* marque un champ à exposer ou non pour sérialisé ou désérialisé*/
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Pokemon> results = null;


    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public Object getPrevious() {
        return previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
