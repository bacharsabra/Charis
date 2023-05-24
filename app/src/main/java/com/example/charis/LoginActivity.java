package com.example.charis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Charis.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity {

    EditText EditTextUsername, EditTextPassword;
    Button btnLogin;
    TextView textViewSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditTextUsername = findViewById(R.id.Username);

        EditTextPassword = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
        textViewSignUp = findViewById(R.id.textViewSignUp);

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                                         startActivity(intent);
                                         finish();
                                     }
                                 });

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        final String username, password;

                        username = String.valueOf(EditTextUsername.getText());
                        password = String.valueOf(EditTextPassword.getText());

                        if (!username.equals("") && !password.equals("")) {

                            //Start ProgressBar first (Set visibility VISIBLE)
                            Handler handler = new Handler(Looper.getMainLooper());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //Starting Write and Read data with URL
                                    //Creating array for parameters
                                    String[] field = new String[2];
                                    field[0] = "username";
                                    field[1] = "password";

                                    //Creating array for data
                                    String[] data = new String[2];
                                    data[0] = username;
                                    data[1] = password;
                                    PutData putData = new PutData("http://somlb.com/basharsabra/reg/login.php", "POST", field, data);
                                    if (putData.startPut()) {
                                        if (putData.onComplete()) {
                                            String result = putData.getResult();
                                            if (result.equals("Login Success")) {
                                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(getApplicationContext(), "All fields are required!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}