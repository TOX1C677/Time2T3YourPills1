package com.example.time2t3yourpills;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MedicationViewHolder extends RecyclerView.ViewHolder {
    public TextView medicationName, dosage, timer;

    public MedicationViewHolder(View itemView) {
        super(itemView);
        medicationName = itemView.findViewById(R.id.medication_name);
        dosage = itemView.findViewById(R.id.dosage);
        timer = itemView.findViewById(R.id.timer);
    }
}
