package com.subarna.onlineclothesshopping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    TextInputEditText Fname, Lname, Username, Password, Repassword;
    Button Signup;
    ImageView imageView;
    Button button;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && requestCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap =(Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Fname= findViewById(R.id.fname);
        Lname= findViewById(R.id.lname);
        Username= findViewById(R.id.username);
        Password= findViewById(R.id.password);
        Repassword= findViewById(R.id.repassword);
        imageView= findViewById(R.id.iv);

        checkPermission();

        button= findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCamera();
            }
        });

        Signup= findViewById(R.id.signup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadCamera(){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, 1);
        }
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0
                    );
        }
    }

}
