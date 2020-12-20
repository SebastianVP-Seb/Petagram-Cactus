package com.iamseb.boundstone;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

//ESTA CLASE INCRUSTARÁ CADA FRAGMENT EN CADA TAB DEL MAIN ACTIVITY
//(1) INDICAR DE QUIÉN HEREDA, PIDE SE CREEN MÉTODOS Y LUEGO PIDE EL CONSTRUCTOR
public class PageAdapter extends FragmentPagerAdapter {
    //(2) DECLARAR EL ARREGLO DE FRAGMENTOS
    ArrayList<Fragment>fragments;
    //(3) AGREGAR EL ARRAYLIST AL CONSTRUCTOR
    public PageAdapter(@NonNull FragmentManager fm,ArrayList<Fragment>fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //(4) SE REGRESA EL FRAGMENT CON SU POSICIÓN
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        //(5) SE REGRESA EL TAMAÑO DE LA LISTA
        return fragments.size();
    } //(6) EN EL MAINACTIVITY SE CREA EL MÉTODO setUpViewPager()
}
