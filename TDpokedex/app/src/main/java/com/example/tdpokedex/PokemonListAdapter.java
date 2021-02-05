package com.example.tdpokedex;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>
{
    List<Pokemon> listpokemons ;
    Context context;



    public PokemonListAdapter ( List<Pokemon>pokemons)
    {
        this.listpokemons =  pokemons;
    }


    @NonNull
    @Override
    public PokemonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.pokemonitem, parent, false);

        // Return a new holder instance
        return new PokemonListViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonListViewHolder holder, int position) {


        TextView Name =holder.getName();
        ImageView Image= holder.getImage();
        Context context = holder.getContext();
        Pokemon pokemon = listpokemons.get(position);
        String Id = listpokemons.get(position).Id;

        // Pour les url d'image avec 3 paramètres with (holder.getContext()) load( url de récupération) into
        Glide.with(context)
                .load( "https://pokeres.bastionbot.org/images/pokemon/"+Id+".png")
                .into(Image);



        Name.setText(pokemon.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(),PageTest.class);
                intent.putExtra("Id",pokemon.getId() );
                v.getContext().startActivity(intent);


            }
        });











    }

    @Override
    public int getItemCount()
    {
        return listpokemons.size();
    }

    public static class PokemonListViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView image;
        //itemview dans pokemon item
        Context context = itemView.getContext();

        public TextView getName() {
            return name;
        }
        public ImageView getImage()
        {
            return image;
        }

        public Context getContext() {
            return context;
        }

        public PokemonListViewHolder(@NonNull View itemView) {
            super(itemView);
            //faire appel au items view
             name = itemView.findViewById(R.id.pokename);
             image = itemView.findViewById(R.id.image);

        }
    }
}










