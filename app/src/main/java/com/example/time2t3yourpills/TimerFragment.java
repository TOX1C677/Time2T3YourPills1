package com.example.time2t3yourpills;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TimerFragment extends Fragment {

    private CountDownTimer timer;
    private TextView timerText;
    private Button startButton;
    private Button confirmButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        timerText = view.findViewById(R.id.timer_text);
        startButton = view.findViewById(R.id.start_button);
        confirmButton = view.findViewById(R.id.confirm_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer(60000);  // 1 minute for demonstration
                startButton.setVisibility(View.GONE);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer != null) {
                    timer.cancel();
                }
                startButton.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void startTimer(long durationMillis) {
        if (timer != null) {
            timer.cancel();
        }
        timer = new CountDownTimer(durationMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                // Handle timer finish, e.g., show notification
            }
        };
        timer.start();
    }
}
