package com.example.recyclerviewwithretrofit;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<CarsModel> carsModels = new ArrayList<>();
    private CarsAdapter carsAdapter;
    private RecyclerView cars_recyclerView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cars_recyclerView = (RecyclerView) findViewById(R.id.cars_recyclerView);
        cars_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getCarsResponse();
    }

    private void getCarsResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<CarsModel>> call = requestInterface.getCarsJason();

        call.enqueue(new Callback<List<CarsModel>>() {
            @Override
            public void onResponse(Call<List<CarsModel>> call, Response<List<CarsModel>> response) {

                carsModels = new ArrayList<>(response.body());
                carsAdapter =new CarsAdapter(carsModels,MainActivity.this);
                cars_recyclerView.setAdapter(carsAdapter);
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<CarsModel>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed" + t, Toast.LENGTH_LONG).show();
            }
        });

    }

}