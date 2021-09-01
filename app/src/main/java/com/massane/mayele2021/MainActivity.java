package com.massane.mayele2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private CatViewModel catViewModel;
    private List<Model> getCats;
    private CatAdapter catAdapter;
   // private RecyclerView recyclerView;
    private Repository repository;

    private CoursViewModel coursViewModel;
    private List<ModelCours> getCours;
    private CoursAdapter coursAdapter;
    private RecyclerView recyclerView,recyclerViewClasse;
    private RepositoryCours repositoryCours;
    private ClasseAdapter classeAdapter;

    Button primairesClick;
    String textPrimaire="primaire" ,content;

    String classe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        primairesClick =findViewById(R.id.primaire);

        primairesClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              content =   textPrimaire;
                //Toast.makeText(getApplicationContext(),"veuillez remplir",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this, ClasseMayele.class);
                intent2.putExtra("cycle",content);
                startActivity(intent2);
            }
        });




        //recuperation de tous les cours
        repositoryCours=new RepositoryCours(getApplication());
        getCours=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(false);

        coursViewModel=new ViewModelProvider(this).get(CoursViewModel.class);

        coursAdapter=new CoursAdapter(this, getCours);
        makeRequest();
        coursViewModel.getAllCours.observe(this, new Observer<List<ModelCours>>() {
            @Override
            public void onChanged(List<ModelCours> cours) {
                recyclerView.setAdapter(coursAdapter);
                coursAdapter.getAllDatas(cours);
                Log.d("main", "onChanged: "+cours);
            }
        });


/*
        repository=new Repository(getApplication());
        getCats=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);

        catViewModel=new ViewModelProvider(this).get(CatViewModel.class);

        catAdapter=new CatAdapter(this, getCats);
        makeRequest();
        catViewModel.getAllCats().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> cats) {
                recyclerView.setAdapter(catAdapter);
                catAdapter.getAllDatas(cats);
                Log.d("main", "onChanged: "+cats);
            }
        });*/

    }

  /*  private void loadCycle(){
        CoursDatabase coursDatabase = CoursDatabase.getInstance(this.getApplicationContext());
        List<ModelCours> cycleClase = coursDatabase.coursDao().getAllClasse("primaire");
        Log.d("Classe",cycleClase.toString());
    }*/



    private void makeRequest() {
        Log.e("successs","okkkkkkk");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://cg-mayele.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CoursApi api=retrofit.create(CoursApi.class);

        Call<List<ModelCours>> call=api.getApi(100);

        call.enqueue(new retrofit2.Callback<List<ModelCours>>() {
            @Override
            public void onResponse(Call<List<ModelCours>> call, Response<List<ModelCours>> response) {
                if(response.isSuccessful()) {
                    JSONArray courArray =  new JSONArray(response.body());

                    repositoryCours.insertCours(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ModelCours>> call, Throwable t) {

                Log.d("main", "onFailure: "+t.getMessage());
            }
        });
    }
/*
    private void makeRequest() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/images/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CATapi api=retrofit.create(CATapi.class);
        Call<List<Model>> call=api.getImgs(10);
        call.enqueue(new retrofit2.Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response.isSuccessful()) {
                    repository.insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("main", "onFailure: "+t.getMessage());
            }
        });
    }*/
}