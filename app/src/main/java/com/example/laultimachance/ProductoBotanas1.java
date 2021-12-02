package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProductoBotanas1 extends AppCompatActivity {

    private TextView stextDescProd;
    private DatabaseReference mDatabase;
    private DatabaseReference cartReference;
    private TextView stextPrecio;
    private TextView sTextProducto;
    private ImageView sImgProducto;
    String juanito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_botanas1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        stextDescProd = (TextView) findViewById(R.id.textDescProd);
        stextPrecio = (TextView) findViewById(R.id.textPrecio);
        sTextProducto = (TextView) findViewById(R.id.textProducto);
        sImgProducto = (ImageView) findViewById(R.id.imgProducto);
        cartReference = FirebaseDatabase.getInstance().getReference().child("Cart");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Products").child("Sabritas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String description = snapshot.child("DEscription").getValue().toString();
                    String price = snapshot.child("Price").getValue().toString();
                    String name = snapshot.child("Name").getValue().toString();
                    //Esto es para las imagenes
                    juanito = snapshot.child("Image").getValue().toString();
                    Glide.with(ProductoBotanas1.this).load(juanito).into(sImgProducto);
                    stextDescProd.setText(description);
                    stextPrecio.setText(price);
                    sTextProducto.setText(name);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
    public void btnAñadir(View view) {
        //Intent añadir = new Intent(this, Carro.class);
        //startActivity(añadir);
        Cart cart = new Cart();
        String name = sTextProducto.getText().toString().trim();
        cart.setProduct(sTextProducto.getText().toString().trim());
        cart.setDescription(stextDescProd.getText().toString().trim());
        cart.setPrice(stextPrecio.getText().toString().trim());
        cart.setImage(juanito);
        cartReference.child(String.valueOf(name)).setValue(cart);
        Toast.makeText(this, "Producto añadido al carrito", Toast.LENGTH_SHORT).show();
    }
}