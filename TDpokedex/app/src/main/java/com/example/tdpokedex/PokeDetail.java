package com.example.tdpokedex;

import java.util.List;

public class PokeDetail {
    public List<Ability> abilities;
    public int base_experience;
    public List<Form> forms;
    public List<GameIndice> game_indices;
    public int height;
    public List<Object> held_items;
    public int id;
    public boolean is_default;
    public String location_area_encounters;
    public List<Move> moves;
    public String name;
    public int order;
    public Species species;
    public Sprites sprites;
    public List<Stat> stats;
    public List<Type> types;
    public int weight;
    public class Ability2{
        public String name;
        public String url;
    }

    public class Ability{
        public Ability ability;
        public boolean is_hidden;
        public int slot;
    }
    public PokeDetail(   int id, String name, List<Type> types,int height, int weight)
    {
        id=id;
        name=name;
        types=types;
        height=height;
        weight=weight;
    }

    public class Form{
        public String name;
        public String url;
    }

    public class Version{
        public String name;
        public String url;
    }

    public class GameIndice{
        public int game_index;
        public Version version;
    }

    public class Move2{
        public String name;
        public String url;
    }

    public class MoveLearnMethod{
        public String name;
        public String url;
    }

    public class VersionGroup{
        public String name;
        public String url;
    }

    public class VersionGroupDetail{
        public int level_learned_at;
        public MoveLearnMethod move_learn_method;
        public VersionGroup version_group;
    }

    public class Move{
        public Move move;
        public List<VersionGroupDetail> version_group_details;
    }

    public class Species{
        public String name;
        public String url;
    }

    public class DreamWorld{
        public String front_default;
        public Object front_female;
    }

    public class OfficialArtwork{
        public String front_default;
    }

    public class Other{
        public DreamWorld dream_world;

        public OfficialArtwork officialArtwork;
    }

    public class RedBlue{
        public String back_default;
        public String back_gray;
        public String front_default;
        public String front_gray;
    }

    public class Yellow{
        public String back_default;
        public String back_gray;
        public String front_default;
        public String front_gray;
    }

    public class GenerationI{

        public RedBlue redBlue;
        public Yellow yellow;
    }

    public class Crystal{
        public String back_default;
        public String back_shiny;
        public String front_default;
        public String front_shiny;
    }

    public class Gold{
        public String back_default;
        public String back_shiny;
        public String front_default;
        public String front_shiny;
    }

    public class Silver{
        public String back_default;
        public String back_shiny;
        public String front_default;
        public String front_shiny;
    }

    public class GenerationIi{
        public Crystal crystal;
        public Gold gold;
        public Silver silver;
    }

    public class Emerald{
        public String front_default;
        public String front_shiny;
    }

    public class FireredLeafgreen{
        public String back_default;
        public String back_shiny;
        public String front_default;
        public String front_shiny;
    }

    public class RubySapphire{
        public String back_default;
        public String back_shiny;
        public String front_default;
        public String front_shiny;
    }

    public class GenerationIii{
        public Emerald emerald;

        public FireredLeafgreen fireredLeafgreen;

        public RubySapphire rubySapphire;
    }

    public class DiamondPearl{
        public String back_default;
        public Object back_female;
        public String back_shiny;
        public Object back_shiny_female;
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }

    public class HeartgoldSoulsilver{
        public String back_default;
        public Object back_female;
        public String back_shiny;
        public Object back_shiny_female;
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }

    public class Platinum{
        public String back_default;
        public Object back_female;
        public String back_shiny;
        public Object back_shiny_female;
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }



    public class Animated{
        public String back_default;
        public Object back_female;
        public String back_shiny;
        public Object back_shiny_female;
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }

    public class BlackWhite{
        public Animated animated;
        public String back_default;
        public Object back_female;
        public String back_shiny;
        public Object back_shiny_female;
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }



    public class OmegarubyAlphasapphire{
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }

    public class XY{
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }



    public class Icons{
        public String front_default;
        public Object front_female;
    }

    public class UltraSunUltraMoon{
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
    }



    public class GenerationViii{
        public Icons icons;
    }


    public class Sprites{
        public String back_default;
        public Object back_female;
        public String back_shiny;
        public Object back_shiny_female;
        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;
        public Other other;

    }

    public class Stat2{
        public String name;
        public String url;
    }

    public class Stat{
        public int base_stat;
        public int effort;
        public Stat stat;
    }

    public class Type2{
        public String name;
        public String url;
    }

    public class Type{
        public int slot;
        public Type type;
    }






}
