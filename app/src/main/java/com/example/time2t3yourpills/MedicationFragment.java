package com.example.time2t3yourpills;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.time2t3yourpills.adapters.MedicationAdapter;
import com.example.time2t3yourpills.models.Medication;
import java.util.ArrayList;
import java.util.List;

public class MedicationFragment extends Fragment {

    private MedicationViewModel medicationViewModel;
    private EditText medicationNameEditText;
    private EditText dosageEditText;
    private EditText timerEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medication, container, false);

        RecyclerView medicationsRecyclerView = view.findViewById(R.id.medications_recycler_view);
        Button addButton = view.findViewById(R.id.add_button);
        medicationNameEditText = view.findViewById(R.id.medication_name);
        dosageEditText = view.findViewById(R.id.dosage);
        timerEditText = view.findViewById(R.id.timer);

        medicationViewModel = new ViewModelProvider(this).get(MedicationViewModel.class);

        MedicationAdapter adapter = new MedicationAdapter(new ArrayList<>());
        medicationsRecyclerView.setAdapter(adapter);
        medicationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        medicationViewModel.getAllMedications().observe(getViewLifecycleOwner(), new Observer<List<Medication>>() {
            @Override
            public void onChanged(List<Medication> medications) {
                adapter.medications.clear();
                adapter.medications.addAll(medications);
                adapter.notifyDataSetChanged();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String medicationName = medicationNameEditText.getText().toString();
                String dosage = dosageEditText.getText().toString();
                String timer = timerEditText.getText().toString();

                if (!medicationName.isEmpty() && !dosage.isEmpty() && !timer.isEmpty()) {
                    Medication medication = new Medication();
                    medication.setName(medicationName);
                    medication.setDosage(Integer.parseInt(dosage));
                    medication.setTimer(Long.parseLong(timer));
                    medicationViewModel.insert(medication);
                } else {
                    Toast.makeText(getContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
