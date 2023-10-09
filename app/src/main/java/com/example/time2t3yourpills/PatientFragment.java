package com.example.time2t3yourpills;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.time2t3yourpills.models.User;

public class PatientFragment extends Fragment {

    private UserViewModel userViewModel;
    private EditText nameEditText;
    private EditText middleNameEditText;
    private EditText notesEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient, container, false);

        nameEditText = view.findViewById(R.id.name_edit_text);
        middleNameEditText = view.findViewById(R.id.middle_name_edit_text);
        notesEditText = view.findViewById(R.id.notes_edit_text);
        Button saveButton = view.findViewById(R.id.save_button);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String middleName = middleNameEditText.getText().toString();
                String notes = notesEditText.getText().toString();

                User user = new User();
                user.setName(name);
                user.setMiddleName(middleName);
                user.setNotes(notes);

                userViewModel.insertOrUpdate(user);
            }
        });

        return view;
    }
}
