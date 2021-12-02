package com.example.laultimachance;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FormasDePago extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas_de_pago);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
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
    public void Ingresar (View view){
        Intent ingresarenpaypal = new Intent(this, IngresarPaypal.class);
        startActivity(ingresarenpaypal);
    }
    public void Acceder (View view){
        Intent accedermercadopago = new Intent(this, IngresarMercadopago.class);
        startActivity(accedermercadopago);
    }
    public boolean OnCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.overview, menu);
        return true;
    }
    public boolean OnOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==R.id.item1){
            Toast.makeText(this, "Abriendo pedidos", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item2){
            Toast.makeText(this, "Abriendo metodos de pagos", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item3){
            Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item4){
            Toast.makeText(this, "Cerrando sesión", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
