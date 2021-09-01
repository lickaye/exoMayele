package com.massane.mayele2021;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface coursDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCours(List<ModelCours> coursList);

    @Query("SELECT DISTINCT * FROM cours")
    LiveData<List<ModelCours>> getAllcours();

    @Query("SELECT * FROM cours WHERE cycle = :sCycle ")
    LiveData<List<ModelCours>> getAllClasse(String sCycle);



    @Query("DELETE FROM cours")
    void deleteCoursAll();
}
