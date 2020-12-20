package com.iamseb.boundstone;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CactusAdaptador extends RecyclerView.Adapter<CactusAdaptador.CactusViewHolder>{
    ArrayList<Cactus>cactus;
    Activity activity;

    public CactusAdaptador(ArrayList<Cactus>cactus,Activity activity){
        this.cactus=cactus;
        this.activity=activity;
    }
    @NonNull
    @Override
    public CactusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cactus,parent,false);

        return new CactusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CactusViewHolder holder, int position) {
        Cactus cactu=cactus.get(position);
        holder.NombreCardCactus.setText(cactu.getNombre());
        holder.imgCactus.setImageResource(cactu.getFoto());
   //     holder.imgLike.setImageResource(cactu.getFoto()); Sólo mandar a llamar los elementos que cambian
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Te gusta "+cactu.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cactus.size();
    }

    public static class CactusViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCactus;
        ImageButton btnLike;
        TextView NombreCardCactus;
        ImageView imgLike;

        public CactusViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCactus=(ImageView)itemView.findViewById(R.id.imgCactus);
            btnLike=(ImageButton)itemView.findViewById(R.id.btnLike);
            NombreCardCactus=(TextView)itemView.findViewById(R.id.NombreCardCactus);
            imgLike=(ImageView)itemView.findViewById(R.id.imgLike);
        }
    }
}
