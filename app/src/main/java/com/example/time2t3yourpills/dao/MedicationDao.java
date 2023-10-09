package com.example.time2t3yourpills.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.time2t3yourpills.models.Medication;

import java.util.List;

@Dao
public interface MedicationDao {
    @Insert
    void insert(Medication medication);

    @Query("SELECT * FROM medication_table")
    List<Medication> getAllMedications();

    // ... Other queries such as update, delete
}
