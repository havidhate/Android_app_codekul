package com.example.masterspinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpPage extends AppCompatActivity {

    TextInputLayout fnameEt,lnameEt,contactEt,passwordEt,emailEt;
    Button loginBtn,signupBtn;
    ProgressBar progbar;
    private MasterAPI masterAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        fnameEt=findViewById(R.id.fnameEt);
        lnameEt=findViewById(R.id.lnameEt);
        contactEt=findViewById(R.id.contactEt);
        passwordEt=findViewById(R.id.passwordEt);
        loginBtn=findViewById(R.id.loginBtn);
        signupBtn=findViewById(R.id.signupBtn);
        emailEt=findViewById(R.id.emailEt);
        progbar = findViewById(R.id.progbar);

        progbar.setVisibility(View.INVISIBLE);


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progbar.setVisibility(View.VISIBLE);

                String fname = fnameEt.getEditText().getText().toString();
                String lname = lnameEt.getEditText().getText().toString();
                Long contact = Long.parseLong(contactEt.getEditText().getText().toString());
                String password = passwordEt.getEditText().getText().toString();
                String emailId = emailEt.getEditText().getText().toString();

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.29.54:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8070/").addConverterFactory(GsonConverterFactory.create()).build();

                masterAPI=retrofit.create(MasterAPI.class);

                UserModel userModel = new UserModel(contact,emailId,fname,lname,password);

                Call<UserModel> call =masterAPI.createUserPost(userModel);

                call.enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        Toast.makeText(getApplicationContext(),"Account Created!!Login To The Account!!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),LoginPage.class));
                        progbar.setVisibility(View.INVISIBLE);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Error: "+t.getMessage(),Toast.LENGTH_SHORT).show();
                        progbar.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginPage.class));
                finish();
            }
        });


    }
}