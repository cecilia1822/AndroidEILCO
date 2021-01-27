package com.example.tdpokedex;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class PokemonFullData {



        /*Sérialiser un champ avec un nom différent au lieu d'un nom de champ réel*/
        @SerializedName("id")
        @Expose /* marque un champ à exposer ou non pour sérialisé ou désérialisé*/
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("weight")
        @Expose
        private Integer weight;
        /*private Object previous;*/
        @SerializedName("abilities")
        @Expose
        private List<Pokemon> abilities = null;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public List<Pokemon> getAbilities() {
        return abilities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setAbilities(List<Pokemon> abilities) {
        this.abilities = abilities;
    }

}
