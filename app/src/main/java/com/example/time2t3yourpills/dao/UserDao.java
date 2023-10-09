package com.example.time2t3yourpills.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.time2t3yourpills.models.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM user_table WHERE id = 1")
    User getUser();

    @Update
    void update(User user);

    // ... Other queries such as delete if necessary
}
