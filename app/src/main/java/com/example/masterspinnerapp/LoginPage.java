package com.example.masterspinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPage extends AppCompatActivity {

    TextInputLayout emailIdEt,passwordEt;
    Button loginBtn,signupBtn;
    ProgressBar progbar;
    private MasterAPI masterAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailIdEt = findViewById(R.id.emailIdEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);
        signupBtn = findViewById(R.id.signupBtn);
        progbar = findViewById(R.id.progbar);

        progbar.setVisibility(View.INVISIBLE);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpPage.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progbar.setVisibility(View.VISIBLE);
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.29.54:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                masterAPI=retrofit.create(MasterAPI.class);


                String email = emailIdEt.getEditText().getText().toString();
                String password = passwordEt.getEditText().getText().toString();

                Log.d("Email Tag", "onClick: "+email);
                Log.d("Password Tag", "onClick: "+password);

                Call<List<UserModel>> call = masterAPI.getUserDetails();

                call.enqueue(new Callback<List<UserModel>>() {
                    @Override
                    public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                        if(!response.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Code: "+response.code(),Toast.LENGTH_SHORT).show();
                            progbar.setVisibility(View.VISIBLE);
                            return;
                        }
                        else {
                            int temp=0;
                            List<UserModel> userModels = response.body();
                            for (UserModel userModel:userModels)
                            {
                                 if(userModel.getEmailId().equals(email)&&userModel.getPassword().equals(password))
                                {
                                    temp=1;
                                    progbar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getApplicationContext(),"Login Successfull!!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                    break;
                                }
                            }
                            if(temp==0)
                            {
                                progbar.setVisibility(View.INVISIBLE);
                                Toast.makeText(getApplicationContext(),"User Not Found!!!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserModel>> call, Throwable t) {
                        progbar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Error: "+t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

                /*call.enqueue(new Callback<List<UserModel>>() {
                    @Override
                    public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                        if(!response.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),response.code(), Toast.LENGTH_SHORT).show();
                            progbar.setVisibility(View.INVISIBLE);
                            //tv1.setText(response.code());
                            return;
                        }
                        else
                        {
                            int temp=0;
                            List<UserModel> userModels =response.body();
                            for(UserModel userModel:userModels)
                            {
                                if(userModel.getEmailId().equals(email)&&userModel.getPassword().equals(password))
                                {
                                    temp=1;
                                    progbar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getApplicationContext(),"Login Successfull!!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                    break;
                                }
                            }
                            if(temp==0)
                            {
                                progbar.setVisibility(View.INVISIBLE);
                                Toast.makeText(getApplicationContext(),"User Not Found!!!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserModel>> call, Throwable t) {
                        progbar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Error: "+t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        });
    }
}