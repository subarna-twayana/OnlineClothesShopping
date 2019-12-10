package com.subarna.onlineclothesshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText Lusername, Lpassword;
    Button Login;
    TextView lsignup;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Lusername = findViewById(R.id.lusername);
        Lpassword = findViewById(R.id.lpassword);
        lsignup = findViewById(R.id.lsignup);
        lsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        Login = findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);

                if (Lusername.getText().toString().equals("admin") &&
                        Lpassword.getText().toString().equals("admin")) {


                    //Store();
                    Toast.makeText(LoginActivity.this, "Redirecting to dashboard page", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();


//                    Lusername.setVisibility(View.VISIBLE);
//                    Lpassword.setBackgroundColor(Color.RED);
//                    counter--;
//                    Lusername.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        Login.setEnabled(false);
//                    }
                }


                startActivity(intent);

            }
        });

    }
    private void Store(){
        SharedPreferences sharedPreferences= getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", Lusername.getText().toString());
        editor.putString("password", Lpassword.getText().toString());
        editor.commit();

        Toast.makeText(this, "Login Successfully store", Toast.LENGTH_SHORT).show();
    }
}
