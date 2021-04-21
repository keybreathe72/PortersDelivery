package com.example.portersdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText rphone, remail, rpassword;
    Button rsignup;
    TextView rhints;
    FirebaseAuth fAuth;
    ProgressBar rprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rphone = findViewById(R.id.editTextPhone);
        remail = findViewById(R.id.editTextTextEmailAddress2);
        rpassword = findViewById(R.id.editTextTextPassword2);
        rsignup = findViewById(R.id.button2);
        rhints = findViewById(R.id.textView8);

        fAuth = FirebaseAuth.getInstance();
        rprogress = findViewById(R.id.progressBar);

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomePage.class));
            finish();
        }

        rsignup.setOnClickListener(v -> {
            String email = remail.getText().toString().trim();
            String password = rpassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                return;
            }
            rprogress.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                    Toast.makeText(Register.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                    rprogress.setVisibility(View.GONE);
                    if (!task.isSuccessful()) {
                        Toast.makeText(Register.this, "Authentication failed" + task.getException(), Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(Register.this, HomePage.class));
                        finish();

                    }
                }

            });

        });

    }
}

