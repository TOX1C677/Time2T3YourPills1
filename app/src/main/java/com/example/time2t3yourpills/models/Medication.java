package com.example.time2t3yourpills.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medication_table")
public class Medication {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int dosage;
    private long timer;

    // ... Getters and setters
}
