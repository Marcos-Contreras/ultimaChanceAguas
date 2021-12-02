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
//Aquí no va flechita de atras
public class Login extends AppCompatActivity {

    EditText etEmailLogin,etPasswordLogin;
    Button btnLogin;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etEmailLogin=findViewById(R.id.etEmailLogin);
        etPasswordLogin=findViewById(R.id.etPasswordLogin);
        btnLogin=findViewById(R.id.btnLogin);

        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String email=etEmailLogin.getText().toString();
        String password=etPasswordLogin.getText().toString();

        if (!email.matches(emailPattern)){
            etEmailLogin.setError("Ingrese un email válido");
        }else if(password.isEmpty() || password.length()<6){
            etPasswordLogin.setError("La contraseña no es correcta");
        }else {
            progressDialog.setMessage("Iniciando sesión...");
            progressDialog.setTitle("Inicio de sesión");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        toPaginaPrincipal();
                        Toast.makeText(Login.this, "Sesión iniciada con exito", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void toPaginaPrincipal() {
        Intent intent=new Intent(Login.this,PaginaPrincipal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void btnNoAccount(View view) {
        Intent toRegister = new Intent(this, Register.class);
        startActivity(toRegister);
    }

    public void btnToForgotPassword(View view) {
        Intent toForgotPassword = new Intent(this, forgotpassword.class);
        startActivity(toForgotPassword);
    }

    public void btnIniciarSesion(View view) {
        Intent toPaginaPrincipal = new Intent(this, PaginaPrincipal.class);
        startActivity(toPaginaPrincipal);
    }
}