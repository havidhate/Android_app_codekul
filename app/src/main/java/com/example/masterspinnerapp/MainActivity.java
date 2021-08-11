package com.example.masterspinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCountry, spinnerState, spinnerDistrict, spinnerTahsil;
    private MasterAPI masterAPI;
    private ArrayList<String> listCountry = new ArrayList<String>();
    private ArrayList<String> listState = new ArrayList<String>();
    private ArrayList<String> listDistrict = new ArrayList<String>();
    private ArrayList<String> listTahsil = new ArrayList<String>();
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerState = findViewById(R.id.spinnerState);
        spinnerDistrict = findViewById(R.id.spinnerDistrict);
        spinnerTahsil = findViewById(R.id.spinnerTahsil);

        submitBtn = findViewById(R.id.submitBtn);

        listCountry.add("--Select Country--");
        listState.add("--Select State--");
        listDistrict.add("--Select District--");
        listTahsil.add("--Select Tahsil--");
        /*listCountry.add("India");
        listCountry.add("USA");
        listCountry.add("UK");*/

        setCountrySpinner();
        setStateSpinner();
        setDistrictSpinner();
        setTahsilSpinner();


        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerCountry.setSelection(position);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.29.54:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                masterAPI = retrofit.create(MasterAPI.class);

                String countryName = spinnerCountry.getSelectedItem().toString();

                Call<List<CountryModel>> call = masterAPI.getCountryDetails();

                call.enqueue(new Callback<List<CountryModel>>() {
                    @Override
                    public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {

                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            List<CountryModel> countryModels = response.body();

                            for (CountryModel countryModel : countryModels) {
                                if (countryModel.getCountry_name().equals(countryName)) {
                                    long country_id = countryModel.getCountry_id();
                                    listState.clear();
                                    listDistrict.clear();
                                    listState.add("--Select State--");
                                    listDistrict.add("--Select District--");
                                    for (StateModel stateModel : countryModel.getStateModel()) {
                                        listState.add(stateModel.getState_name());
                                    }
                                    setStateSpinner();
                                    break;
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerState.setSelection(position);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.29.54:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                masterAPI = retrofit.create(MasterAPI.class);

                String stateName = spinnerState.getSelectedItem().toString();

                Call<List<StateModel>> call = masterAPI.getStateDetails();

                call.enqueue(new Callback<List<StateModel>>() {
                    @Override
                    public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {

                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "State Code: " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            List<StateModel> stateModels = response.body();
                            for (StateModel stateModel : stateModels) {
                                if (stateModel.getState_name().equals(stateName)) {
                                    long stateId = stateModel.getState_id();
                                    listDistrict.clear();
                                    listDistrict.add("--Select District--");
                                    listTahsil.clear();
                                    listTahsil.add("--Select Tahsil--");
                                    for (DistrictModel districtModel : stateModel.getDistrictModel()) {
                                        listDistrict.add(districtModel.getDistrict_name());
                                    }
                                    setDistrictSpinner();
                                }
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<List<StateModel>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerDistrict.setSelection(position);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.29.54:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8070/").addConverterFactory(GsonConverterFactory.create()).build();
                masterAPI = retrofit.create(MasterAPI.class);

                String districtName = spinnerDistrict.getSelectedItem().toString();

                Call<List<DistrictModel>> call = masterAPI.getDistrictDetails();

                call.enqueue(new Callback<List<DistrictModel>>() {
                    @Override
                    public void onResponse(Call<List<DistrictModel>> call, Response<List<DistrictModel>> response) {

                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "District Code: " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            List<DistrictModel> districtModels = response.body();
                            for (DistrictModel districtModel : districtModels) {
                                if (districtModel.getDistrict_name().equals(districtName)) {
                                    long districtId = districtModel.getDistrict_id();
                                    listTahsil.clear();
                                    listTahsil.add("--Select Tahsil--");

                                    for (TahsilModel tahsilModel : districtModel.getTahsilModels()) {
                                        listTahsil.add(tahsilModel.getTahsil_name());
                                    }
                                    setTahsilSpinner();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DistrictModel>> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RecyclerActivity.class));
            }
        });

    }

    private void setTahsilSpinner() {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTahsil);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTahsil.setAdapter(arrayAdapter);
    }

    private void setDistrictSpinner() {

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listDistrict);

        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDistrict.setAdapter(arrayAdapter2);

    }

    private void setStateSpinner() {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listState);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerState.setAdapter(arrayAdapter);


    }

    private void setCountrySpinner() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.29.54:8070/").addConverterFactory(GsonConverterFactory.create()).build();
        //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8070/").addConverterFactory(GsonConverterFactory.create()).build();
        masterAPI = retrofit.create(MasterAPI.class);

        Call<List<CountryModel>> call = masterAPI.getCountryDetails();

        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    List<CountryModel> countryModels = response.body();

                    for (CountryModel countryModel : countryModels) {
                        listCountry.add(countryModel.getCountry_name());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {

            }
        });


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCountry);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCountry.setAdapter(arrayAdapter);

    }
}