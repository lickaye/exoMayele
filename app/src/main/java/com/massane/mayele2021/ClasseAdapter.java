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

public class ClasseAdapter extends RecyclerView.Adapter<ClasseAdapter.ClasseViewHolder> {

    private Context context;
    private List<ModelCours> cours;
    private CoursDatabase database;

    public ClasseAdapter(Context context, List<ModelCours> cours) {
        this.context = context;
        this.cours = cours;
    }

    @NonNull
    @Override
    public ClasseAdapter.ClasseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClasseAdapter.ClasseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_classe_mayele,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClasseAdapter.ClasseViewHolder holder, int position) {
        ModelCours classe=cours.get(position);
        holder.cycle.setText(classe.getCycle());

        //initialize database
        database = CoursDatabase.getInstance(context);


       holder.cycle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ModelCours c = cours.get(holder.getAdapterPosition());

               //Get classe
               String sCycle = c.getCycle();

               database.coursDao().getAllClasse(sCycle);

           }
       });

    }

    @Override
    public int getItemCount() {
        return cours.size();
    }

    public void getAllDatas(List<ModelCours> cours)
    {
        this.cours=cours;
    }

    public static class ClasseViewHolder extends RecyclerView.ViewHolder
    {

        public TextView cycle;

        public ClasseViewHolder(@NonNull View itemView) {
            super(itemView);
            cycle = itemView.findViewById(R.id.primaire);
        }
    }
}
