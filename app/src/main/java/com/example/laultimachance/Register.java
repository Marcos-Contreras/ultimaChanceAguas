package com.example.laultimachance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    
    EditText etEmailRegister,etPasswordRegister,etConfirmPassword;
    Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmailRegister=findViewById(R.id.etEmailRegister);
        etPasswordRegister=findViewById(R.id.etPasswordRegister);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);
        btnRegister=findViewById(R.id.btnRegister);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
    }

    public void PerforAuth(){
        String email=etEmailRegister.getText().toString();
        String password=etPasswordRegister.getText().toString();
        String confirmPassword=etConfirmPassword.getText().toString();

        if (!email.matches(emailPattern)){
            etEmailRegister.setError("Ingrese un email válido");
        }else if(password.isEmpty() || password.length()<6){
            etPasswordRegister.setError("Contraseña vacía o debe tener más de 6 caracteres");
        }else if(!password.equals(confirmPassword)){
            etConfirmPassword.setError("La contraseña no coincide en ambos campos");
        }else{
            progressDialog.setMessage("Creando registro...");
            progressDialog.setTitle("Registro");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        toPaginaPrincipal();
                        Toast.makeText(Register.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(Register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void toPaginaPrincipal() {
        Intent intent=new Intent(Register.this,PaginaPrincipal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    public void btnHaveAccount(View view) {
        Intent toLogin = new Intent(this, Login.class);
        startActivity(toLogin);
    }

    /*public void btnRegistrarse(View view) {
        Intent toPaginaPrincipal = new Intent(this, PaginaPrincipal.class);
        startActivity(toPaginaPrincipal);
    }*/


}