package com.example.time2t3yourpills;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private User user;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        user = userRepository.getUser();
    }

    public User getUser() {
        return user;
    }

    public void insertOrUpdate(User user) {
        userRepository.insertOrUpdate(user);
    }
}
