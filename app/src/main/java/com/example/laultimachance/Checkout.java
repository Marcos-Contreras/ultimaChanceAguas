package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Checkout extends AppCompatActivity {

    double totalPrice = 0;
    TextView  TotalTotal;
    EditText Fname, Lname, Email, Phone, Address, City, PostaleCode;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String payment;
    private DatabaseReference purchasesReference, cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TotalTotal = (TextView) findViewById(R.id.totalTxt);
        getTotalPrice();
        Fname = (EditText) findViewById(R.id.nombreEditTxt);
        Lname = (EditText) findViewById(R.id.apellidoEditTxt);
        Email = (EditText) findViewById(R.id.correoEditTxt);
        Phone = (EditText) findViewById(R.id.editTextPhone);
        Address = (EditText) findViewById(R.id.direcEditTxt);
        City = (EditText) findViewById(R.id.ciudadEditTxt);
        PostaleCode = (EditText) findViewById(R.id.editTextTextPostalAddress);
        radioGroup = (RadioGroup) findViewById(R.id.radiogrupo);

        purchasesReference = FirebaseDatabase.getInstance().getReference().child("Purchases");



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
    public void btnCompraFinalizada(View view) {
        /*Purchases purchases = new Purchases();
        checkButton();
        String name = Fname.getText().toString().trim();
        purchases.setFname(Fname.getText().toString().trim());
        purchases.setLname(Lname.getText().toString().trim());
        purchases.setEmail(Email.getText().toString().trim());
        purchases.setPhone(Phone.getText().toString().trim());
        purchases.setAddress(Address.getText().toString().trim());
        purchases.setCity(City.getText().toString().trim());
        purchases.setPostaleCode(PostaleCode.getText().toString().trim());
        purchases.setTotalTotal(TotalTotal.getText().toString().trim());
        purchases.setPaymentMethod(payment.trim());
        purchasesReference.child(String.valueOf(name)).setValue(purchases);

        cart = FirebaseDatabase.getInstance().getReference("Cart");

        cart.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Checkout.this, "Carrito vaciado", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Checkout.this, "No hay elemento en el carrito", Toast.LENGTH_SHORT).show();
            }
        });*/

        Intent toCompraFinalizada = new Intent(this, CompraFinalizada.class);
        startActivity(toCompraFinalizada);

    }
    private void getTotalPrice (){
        Bundle price = getIntent().getExtras();
        totalPrice =price.getDouble("preciototal");
        TotalTotal.setText("" + totalPrice);
    }
    public void checkButton(){
        int radioid = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioid);

        if(radioButton.getText().equals("PayPal")){
            payment="PayPal";

        } else {
            payment = "MercadoPago";
        }
    }
}