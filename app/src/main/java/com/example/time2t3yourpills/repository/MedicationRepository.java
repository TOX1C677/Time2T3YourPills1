package com.example.time2t3yourpills.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.time2t3yourpills.database.AppDatabase;
import com.example.time2t3yourpills.dao.MedicationDao;
import com.example.time2t3yourpills.models.Medication;

import java.util.ArrayList;
import java.util.List;

public class MedicationRepository {

    private MedicationDao medicationDao;
    private LiveData<List<Medication>> allMedications;

    public MedicationRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        medicationDao = db.medicationDao();
        allMedications = medicationDao.getAllMedications();
        if (allMedications.getValue() == null) {
            allMedications = new MutableLiveData<>(new ArrayList<>());
        }
    }

    public LiveData<List<Medication>> getAllMedications() {
        return allMedications;
    }

    public void insert(Medication medication) {
        new InsertAsyncTask(medicationDao).execute(medication);
    }

    private static class InsertAsyncTask extends AsyncTask<Medication, Void, Void> {

        private MedicationDao asyncTaskDao;

        InsertAsyncTask(MedicationDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Medication... params) {
            if (params[0] != null) {
                asyncTaskDao.insert(params[0]);
            }
            return null;
        }
    }
}
