package com.example.time2t3yourpills.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.time2t3yourpills.database.AppDatabase;
import com.example.time2t3yourpills.dao.UserDao;
import com.example.time2t3yourpills.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
        if (allUsers.getValue() == null) {
            allUsers = new MutableLiveData<>(new ArrayList<>());
        }
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user) {
        new InsertAsyncTask(userDao).execute(user);
    }

    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao asyncTaskDao;

        InsertAsyncTask(UserDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            if (params[0] != null) {
                asyncTaskDao.insert(params[0]);
            }
            return null;
        }
    }
}
