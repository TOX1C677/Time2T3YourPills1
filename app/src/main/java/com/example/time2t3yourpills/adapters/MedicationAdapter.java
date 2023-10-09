package com.example.time2t3yourpills.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.time2t3yourpills.MedicationViewHolder;
import com.example.time2t3yourpills.R;
import com.example.time2t3yourpills.models.Medication;
import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationViewHolder> {
    public List<Medication> medications;  // Made this public for easy access

    public MedicationAdapter(List<Medication> medications) {
        this.medications = medications;
    }

    @Override
    public MedicationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medication_list_item, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicationViewHolder holder, int position) {
        Medication medication = medications.get(position);
        holder.medicationName.setText(medication.getName());
        holder.dosage.setText(String.valueOf(medication.getDosage()));
        holder.timer.setText(String.valueOf(medication.getTimer()));
    }

    @Override
    public int getItemCount() {
        return medications.size();
    }
}
