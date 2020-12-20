package com.iamseb.boundstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DetalleCactus extends AppCompatActivity {

    Toolbar toolbar;
    Toolbar miactionbar;
    RecyclerView RecyclerViewMain;
    ArrayList<Cactus> cactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cactus);
        miactionbar=(Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(miactionbar);

        RecyclerViewMain=(RecyclerView)findViewById(R.id.ReciclerViewMain);
        GridLayoutManager glm=new GridLayoutManager(this,2);
        RecyclerViewMain.setLayoutManager(glm);

        inicializarListaCactus();
        inicializarAdaptadorFav();
    }
    public void inicializarAdaptadorFav(){
        FavAdaptador adaptador=new FavAdaptador(cactus,this);
        RecyclerViewMain.setAdapter(adaptador);
    }

    public void inicializarListaCactus(){
        cactus=new ArrayList<Cactus>();
        cactus.add(new Cactus("Yonahandy",R.drawable.yonahandy));
        cactus.add(new Cactus("Moira",R.drawable.moira));
        cactus.add(new Cactus("Mary",R.drawable.mary));
        cactus.add(new Cactus("Argelia",R.drawable.argelia));
        cactus.add(new Cactus("Argel",R.drawable.argel));
    }
}