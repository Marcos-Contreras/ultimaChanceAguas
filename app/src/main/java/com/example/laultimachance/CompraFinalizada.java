package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
//no se le ha puesto flechita de atras
public class CompraFinalizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_finalizada);
    }

    public void btnPurchaseCompleted(View view) {
        Intent toPaginaPrincipal = new Intent(this, PaginaPrincipal.class);
        startActivity(toPaginaPrincipal);
    }
}