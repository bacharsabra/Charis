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

public class RegisterActivity extends AppCompatActivity {

    EditText EditTextUsername, EditTextEmail, EditTextPassword, EditTextConfirmPassword;
    Button btnRegister;
    TextView gologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditTextUsername = findViewById(R.id.Username);
        EditTextEmail = findViewById(R.id.Email);
        EditTextPassword = findViewById(R.id.Password);
        EditTextConfirmPassword = findViewById(R.id.ConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        gologin = findViewById(R.id.textViewLogin);

        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username, email, password, confirm;

                username = String.valueOf(EditTextUsername.getText());
                email = String.valueOf(EditTextEmail.getText());
                password = String.valueOf(EditTextPassword.getText());
                confirm = String.valueOf(EditTextConfirmPassword.getText());

                if (!username.equals("") && !email.equals("") && !password.equals("")) {

                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "username";
                            field[1] = "email";
                            field[2] = "password";

                            //Creating array for data
                            String[] data = new String[3];
                            data[0] = username;
                            data[1] = email;
                            data[2] = password;

                            if (confirm.equals(password)) {
                                PutData putData = new PutData("http://somlb.com/basharsabra/reg/signup.php", "POST", field, data);
                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        String result = putData.getResult();
                                        if (result.equals("Sign Up Success")) {
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Password is different", Toast.LENGTH_SHORT).show();
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