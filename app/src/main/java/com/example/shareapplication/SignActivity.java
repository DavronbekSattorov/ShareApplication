package com.example.shareapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText emailEdit, passwordEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        firebaseAuth = FirebaseAuth.getInstance();
        emailEdit = findViewById(R.id.emailEdit);
        passwordEdit = findViewById(R.id.passwordEdit);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser != null){
            Intent intent  = new Intent(SignActivity.this,FeedActivity.class);
            startActivity(intent);
            finish();;

        }


    }

    public  void  signUpButton(View view){

        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignActivity.this,FeedActivity.class);
                startActivity(intent);
                finish();;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    public  void signInButton(View view){
        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(SignActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_SHORT).show();

            }

        });


    }
}
