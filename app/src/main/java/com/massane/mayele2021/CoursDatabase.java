package com.massane.mayele2021;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ModelCours.class},version = 5)
public abstract  class CoursDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Cours";
    public abstract coursDao coursDao();
    public static volatile CoursDatabase INSTANCE = null;

    public static CoursDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CoursDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, CoursDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new CoursDatabase.PopulateDbAsyn(INSTANCE);
        }
    };

    static  class  PopulateDbAsyn extends AsyncTask<Void,Void,Void> {
        private coursDao coursDao;
        public PopulateDbAsyn(CoursDatabase coursDatabase)
        {
            coursDao=coursDatabase.coursDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            coursDao.deleteCoursAll();
            return null;
        }
    }

}


