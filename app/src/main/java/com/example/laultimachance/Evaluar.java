package com.example.laultimachance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Evaluar extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    String opcion;
    private DatabaseReference evaluarReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluar);

        evaluarReference = FirebaseDatabase.getInstance().getReference().child("Evaluations");
    }
    public void checkButton(){
        int radioid = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioid);

        if(radioButton.getText().equals("Excelente")){
            opcion="Excelente";


        } if(radioButton.getText().equals("Muy bueno")){
            opcion="Muy bueno";


        }if(radioButton.getText().equals("Regular")){
            opcion="Regular";


        }if(radioButton.getText().equals("Puede mejorar")){
            opcion="Puede mejorar";


        }if(radioButton.getText().equals("Malo")){
            opcion="Malo";


        }
    }
    public void btn_calificar(View view) {/*
        checkButton();
        Evaluation evaluation = new Evaluation();
        String name = opcion;
        evaluation.setCalificacion(opcion);
        evaluarReference.child(String.valueOf(name)).setValue(evaluation);*/
        Toast.makeText(Evaluar.this, "Gracias por calificar", Toast.LENGTH_SHORT).show();
    }
}