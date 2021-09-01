package com.massane.mayele2021;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CoursViewModel  extends AndroidViewModel {

    private RepositoryCours repositoryCours;
    public LiveData<List<ModelCours>> getAllCours;

    public CoursViewModel(@NonNull Application application) {
        super(application);
        repositoryCours=new RepositoryCours(application);
        getAllCours=repositoryCours.getAllCours();
    }

    public void insertCours(List<ModelCours> cours){
        repositoryCours.insertCours(cours);
    }

    public LiveData<List<ModelCours>> getAllCours()
    {
        return getAllCours;
    }
}
