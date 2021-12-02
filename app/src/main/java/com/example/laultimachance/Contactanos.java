package com.example.laultimachance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Contactanos extends AppCompatActivity {

    private Button btnLinkFB;
    private Button btnLinkIG;
    private String linkFB = "https://www.facebook.com/LaUltimaChanceAGS";
    private String linkIG = "https://instagram.com/laultimachanceags?utm_medium=copy_link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        btnLinkFB = findViewById(R.id.buttonAccederFB);
        btnLinkIG = findViewById(R.id.buttonAccederIG);
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
    public void openFacebookPage(View view) {
        Uri urlFB = Uri.parse(linkFB);
        Intent i = new Intent (Intent.ACTION_VIEW,urlFB);
        startActivity(i);
    }

    public void openInstagramProfile(View view) {
        Uri urlIG = Uri.parse(linkIG);
        Intent i = new Intent (Intent.ACTION_VIEW,urlIG);
        startActivity(i);
    }
}