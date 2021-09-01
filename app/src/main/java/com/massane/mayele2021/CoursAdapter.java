package com.massane.mayele2021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CoursAdapter extends RecyclerView.Adapter<CoursAdapter.CourViewHolder> {

    private Context context;
    private List<ModelCours> cours;

    public CoursAdapter(Context context, List<ModelCours> cours) {
        this.context = context;
        this.cours = cours;
    }

    @NonNull
    @Override
    public CoursAdapter.CourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CourViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cours,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull CourViewHolder holder, int position) {
        ModelCours cour=cours.get(position);
        Picasso.get().load(cour.getLiensImage()).into(holder.image);
        holder.libelle.setText(cour.getLibele());
        holder.classe.setText(cour.getClasse());
        holder.cycle.setText(cour.getCycle());

    }

    @Override
    public int getItemCount() {
        return cours.size();
    }

    public void getAllDatas(List<ModelCours> cours)
    {
        this.cours=cours;
    }

    public static class CourViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView image;
        public TextView libelle;
        public TextView classe;
        public TextView cycle;

        public CourViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imgCours);
            libelle = itemView.findViewById(R.id.libeleCoursId);
            cycle = itemView.findViewById(R.id.cycleId);
            classe = itemView.findViewById(R.id.classeId);
        }
    }
}
