package com.massane.mayele2021;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepositoryCours {
    public coursDao coursDao;
    public LiveData<List<ModelCours>> getAllcours;
    private CoursDatabase database;

    public RepositoryCours(Application application){
        database=CoursDatabase.getInstance(application);
        coursDao=database.coursDao();
        getAllcours=coursDao.getAllcours();

    }

    public void insertCours(List<ModelCours> cours){
        new InsertAsyncTask(coursDao).execute(cours);

    }

    public LiveData<List<ModelCours>> getAllCours(){
        return getAllcours;
    }

    private static class InsertAsyncTask extends AsyncTask<List<ModelCours>,String,Void> {
        private coursDao coursDao;

        public InsertAsyncTask(coursDao coursDao)
        {
            this.coursDao=coursDao;
        }
        @Override
        protected Void doInBackground(List<ModelCours>... lists) {
            coursDao.insertCours(lists[0]);
            return null;
        }
    }
}
