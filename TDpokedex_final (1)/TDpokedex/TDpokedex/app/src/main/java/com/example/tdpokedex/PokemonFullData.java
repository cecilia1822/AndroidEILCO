package com.example.tdpokedex;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class PokemonFullData {





        /*Sérialiser un champ avec un nom différent au lieu d'un nom de champ réel*/
        @SerializedName("id")
        @Expose /* marque un champ à exposer ou non pour sérialisé ou désérialisé*/

        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("height")
        @Expose
        public Integer height;
        @SerializedName("weight")
        @Expose
        public Integer weight;

        @SerializedName("abilities")
        @Expose
        public List<Pokemon> abilities = null;





    public class Name{
        public Language language;
        public String name;
    }




    //pour les types des pokémons


    public List<Type2> types;


    public class Type{
        public String name = null;
        public String url = null;

        @Override
        public String toString(){
            return name;

        }


    }


    public class Type2{
        public int slot = 0;
        public Type type = null;

        @Override
        public String toString(){
            return type.toString();

        }

    }


// pour la description des pokémons

    public class FlavorTextEntry {

        public String flavor_text = null;
        public Language language = null;
        public Version version = null;

        @Override
        public String toString() {

            return  flavor_text ;
        }
    }



    public class Species {

        @SerializedName("id")
        @Expose
        public Integer id;

        public List<FlavorTextEntry> flavor_text_entries;

        public String name = null;
        public String url = null;


        @Override
        public String toString(){
            return name;

        }



    }




    public class Version{
        public String name = null;
        public String url = null;
    }

    public class Language{

        public String url;
        public String name;

    }



    public class Pokemon{
        public String name;
        public String url;
    }









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
