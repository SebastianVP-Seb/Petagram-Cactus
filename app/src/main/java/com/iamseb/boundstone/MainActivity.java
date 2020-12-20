package com.iamseb.boundstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
//NOTA: PARA EL VIEW PAGER, EL RECYCLER SE CORTÓ Y SE LLEVÓ AL FRAGMENT_RECYCLERVIEW.XML, AGREGAR LA ETIQUETA APPBARLAYOUT
//DENTRO METER EL INCLUDE. AGREGAR LOS TABS
//EN EL ARCHIVO APPBAR.XML SE AGREGÓ app:layout_scrollFlags="scroll|enterAlways"
//INSERTAR EL VIEWPAGER EN EL MAINACTIVITY.XML. DECLARAR LOS VIEWS
//EL RECYCLER VIEW QUE VIVÍA AQUÍ, SE TIENE QUE MOVER AL RECYCLERVIEWFRAGMENT
//LOS MÉTODOS inicializarListaCactus y inicializarAdaptador también se llevan al RecyclerViewFragment
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Toolbar miactionbar;
    //PARA EL VIEW PAGER Y FRAGMENTS
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //PARA EL VIEWPAGER
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        miactionbar=(Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(miactionbar);
        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

//PARA EL MENÚ DE OPCIONES, FUERA DEL MÉTODO onCreate, cambiar el return a true
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
    switch (item.getItemId()) {
        case R.id.mContact:
            Intent ab = new Intent(this, Contactame.class);
            startActivity(ab);
            break;
        case R.id.mAbout:
            Intent cd = new Intent(this, sebastian.class);
            startActivity(cd);
            break;
    }
        return super.onOptionsItemSelected(item);
    }
    public void irafav(View view){
        Intent ef=new Intent(this,DetalleCactus.class);
        startActivity(ef);
    }
    //PARA EL VIEWPAGER
    //PONDRÁ LOS FRAGMENTS EN ÓRBITA --------------Aquí se deben agregar los fragments que se tienen
    //AÑADIR ANTES LOS FRAGMENTS, YA QUE PAGEADAPTER RECIBE LOS FRAGMENTS
    //SE PONENE LOS FRAGMENTS QUE SE CREARON, PARA LOS TABS
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment>fragments=new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }//ESTE ARRAYLIST SE PASA AL PAGEADAPTER
    private void setUpViewPager(){//SE PASA LA LISTA QUE SE ACABA DE CREAR Y SE AGREGA AL TAB, LLAMAR AL MÉTODO EN ESTE MAIN
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //AQUÍ SE AGREGAN LOS ÍCONOS QUE TENDRÁN LOS TABS, SE MANEJAN PO ÍNDICES
        tabLayout.getTabAt(0).setIcon(R.drawable.tabb);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab);
    }
}