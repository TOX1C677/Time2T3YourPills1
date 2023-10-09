package com.example.time2t3yourpills;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.time2t3yourpills.models.Medication;
import com.example.time2t3yourpills.repository.MedicationRepository;

import java.util.List;

public class MedicationViewModel extends AndroidViewModel {

    private MedicationRepository medicationRepository;
    private LiveData<List<Medication>> allMedications;

    public MedicationViewModel(@NonNull Application application) {
        super(application);
        medicationRepository = new MedicationRepository(application);
        allMedications = medicationRepository.getAllMedications();
    }

    LiveData<List<Medication>> getAllMedications() {
        return allMedications;
    }

    public void insert(Medication medication) {
        medicationRepository.insert(medication);
    }
}
