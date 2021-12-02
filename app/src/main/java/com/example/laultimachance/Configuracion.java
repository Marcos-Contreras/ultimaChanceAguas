package com.example.laultimachance;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Configuracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void btnTerminos(View view) {
        Intent toTerminos = new Intent(this, Terminos.class);
        startActivity(toTerminos);
    }

    public void btnPreguntas(View view) {
        Intent toPreguntas = new Intent(this, Preguntas.class);
        startActivity(toPreguntas);
    }

    public void btnContactanos(View view) {
        Intent cont = new Intent(this, Contactanos.class);
        startActivity(cont);
    }

    public void setLanguage (Activity activity, String language){
        Locale locale = new Locale(language);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public void btn_cambiar(View view) {
        switch (view.getId()){
            case R.id.button_espanol:{
                setLanguage(this, "es");
                startActivity(new Intent(this, PaginaPrincipal.class));
                break;
            }
            case R.id.button_ingles:{
                setLanguage(this, "en");
                startActivity(new Intent(this, PaginaPrincipal.class));
                break;
            }
        }
    }

    public void btnUbicanos(View view) {
        Intent toUbicanos = new Intent(this, Mapa.class);
        startActivity(toUbicanos);
    }

    public void evaluar(View view) {
        Intent evapp = new Intent(this, Evaluar.class);
        startActivity(evapp);
    }
}