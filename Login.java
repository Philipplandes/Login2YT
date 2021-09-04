package com.rechentrainer.login2yt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Login extends AppCompatActivity {
    EditText email , pass;
    Button login ;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email= findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        login= findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Pass = pass.getText().toString();

                auth.signInWithEmailAndPassword(Email,Pass)
                        .addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task <AuthResult> task) {
                                if (task.isSuccessful()){
                                  Intent intent = new Intent(Login.this,Home.class);
                                  startActivity(intent);

                                }else {
                                    Toast.makeText(Login.this, "Fehler", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}