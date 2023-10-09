package com.example.time2t3yourpills.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey
    private int id = 1;  // Only one user, so ID is constant
    private String name;
    private String middleName;
    private String notes;

    // ... Getters and setters
}
