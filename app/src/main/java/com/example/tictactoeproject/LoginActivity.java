package com.example.tictactoeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(mAuth.getCurrentUser() != null){
            //move to another activity
            System.out.println(mAuth.getCurrentUser().getUid());
            changeActivity();
        }



    }


    public void onLogin(View view){
        String email = ((EditText) findViewById(R.id.email_input)).getText().toString();
        String password = ((EditText) findViewById(R.id.password_input)).getText().toString();
        EditText etYear = findViewById(R.id.year_of_birth_input);
        int yearOfBirth = Integer.parseInt( etYear.getText().toString());
        String username = ((EditText) findViewById(R.id.username_input)).getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    changeActivity();
                    System.out.println("Login Successful");
                    UserData u = new UserData(email, username, yearOfBirth);
                    db.collection("users").document(mAuth.getCurrentUser().getUid()).set(u);

                } else {
                    System.out.println("Login Failed");
                    Exception e = task.getException();
                    if (e != null) {
                        System.err.println("Login failed: " + e.getMessage());
                    }
                }
            }
        });

    }


    public void changeActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class); // Replace MainActivity.class with your desired activity
        startActivity(intent);
        finish();

    }



}