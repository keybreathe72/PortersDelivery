package com.example.portersdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity{

    TextView title, hints;
    EditText email;
    EditText password;
    ImageView logo;
    Button login, signup;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        title = findViewById(R.id.textView2);
        hints = findViewById(R.id.textView3);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        logo = findViewById(R.id.imageView);
        login = findViewById(R.id.button);
        signup = findViewById(R.id.button3);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(v -> {

            String lemail = email.getText().toString().trim();
            String lpassword = password.getText().toString().trim();

            if(TextUtils.isEmpty(lemail)){
                email.setError("Email is required");
                return;
            }

            if(TextUtils.isEmpty(lpassword)) {
                password.setError("Email is required");
                return;
            }

            if(password.length()<6) {
                password.setError("Password must be >= 6 characters");
                return;
            }

            mAuth.signInWithEmailAndPassword(lemail,lpassword).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Sucessfully logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),HomePage.class));
                }else  {
                    Toast.makeText(Login.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        });


       signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Login.this, Register.class));
        }
    });
    }
}

