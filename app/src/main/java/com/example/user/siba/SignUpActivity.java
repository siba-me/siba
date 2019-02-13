package com.example.user.siba;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    EditText userName,email,pass;
    Button btDone;
    private FirebaseAuth mAuth;
    public static final String TAG = "FIREBASE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textView = (TextView) findViewById(R.id.textView);
        userName = (EditText) findViewById(R.id.userName);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        btDone = (Button) findViewById(R.id.btDone);
        btDone.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void createUserWithEmailAndPassword(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    //updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    //updateUI(null);
                }

                // ...
            }
        });
    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public void onClick(View v) {

        createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString());

        if (v == btDone) {
            String getEmail = email.getText().toString();

            if ((userName.equals("") || pass == null || email.equals("")) || (!isEmailValid(getEmail))) {

                //Check if one or more fields are empty
                if (userName.equals("") || pass == null || email.equals(""))
                    Toast.makeText(this, "There Are Empty Fields", Toast.LENGTH_SHORT).show();

                // Check if email id is valid or not
                if (!isEmailValid(getEmail))
                    Toast.makeText(this, "\"Your Email Id is Invalid.\"", Toast.LENGTH_SHORT).show();
            } else {
                createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString());
                Intent i = new Intent(this, FlightDetailsActivity.class);
                startActivity(i);

            }

        }
    }
}
