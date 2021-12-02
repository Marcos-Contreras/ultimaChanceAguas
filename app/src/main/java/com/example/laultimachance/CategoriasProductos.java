package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CategoriasProductos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_productos);
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
    public void btnBotanas (View view) {
        Intent botanas = new Intent(this, Botanas.class);
        startActivity(botanas);
    }

    public void btnLacteos(View view) {
        Intent lacteos = new Intent(this, Lacteos.class);
        startActivity(lacteos);
    }

    public void btnBebidas (View view) {
        Intent bebidas = new Intent(this, Bebidas.class);
        startActivity(bebidas);
    }
}