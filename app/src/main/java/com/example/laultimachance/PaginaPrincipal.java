package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PaginaPrincipal extends AppCompatActivity {

    Home inicio = new Home();
    Carro carrito = new Carro();
    Cuenta micuenta = new Cuenta();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(inicio);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.inicio:
                    loadFragment(inicio);
                    return true;
                case R.id.carrito:
                    loadFragment(carrito);
                    return true;
                case R.id.micuenta:
                    loadFragment(micuenta);
                    return true;
            }
            return false;
        }
    };


    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overview, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.item1){
            Intent intent = new Intent(PaginaPrincipal.this, MisPedidos.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(PaginaPrincipal.this, FormasDePago.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(PaginaPrincipal.this, Configuracion.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(PaginaPrincipal.this, Login.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}