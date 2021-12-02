package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
//sin flechita de atras
public class forgotpassword extends AppCompatActivity {

    TextInputEditText etEmailRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
    }


    public void recuperarPass(View view) {
        Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show();
        Intent toLogin = new Intent(this, Login.class);
        startActivity(toLogin);
        finish();
        // validate();
    }

    /*public void validate() {
        String email = etEmailRecuperar.getText().toString().trim();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailRecuperar.setError("Correo inválido");
            return;
        }
        sendEmail();
    }*/


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent backToLogin = new Intent(this, Login.class);
        startActivity(backToLogin);
        finish();
    }

    /*public void sendEmail(){
         FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email;

        auth.sendPasswordResetEmail(emailaddress)
                .addOnCompleteListener(new OnCompleteListener<Void>(){
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        if(task.isSuccessful()){
                            Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show();
                            Intent toLogin = new Intent(this, Login.class);
                            startActivity(toLogin);
                            finish();
                        } else {
                            Toast.makeText(this, "Correo inválido", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/
}