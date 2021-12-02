package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Novedades extends AppCompatActivity {

    Button carritofragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novedades);

        /*Carrito
        carritofragment = findViewById(R.id.button1);
        carritofragment.setOnClickListener(this);*/
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
    public void descProduct(View view) {
        Intent des = new Intent(this, ProductoBotanas1.class);
        startActivity(des);
    }

    /*@Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Carro()).commit();
        }
    }*/
}