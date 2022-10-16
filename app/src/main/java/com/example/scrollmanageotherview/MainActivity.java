package com.example.scrollmanageotherview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scrollmanageotherview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ManageActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.otherView.setOnClickListener(v -> openSettingsOtherView());
    }


    private void openSettingsOtherView() {
        new DialogSettingsOtherView(binding.otherView).show(getSupportFragmentManager(), "otherSetiings");
    }

    @Override
    public void updateScrollView() {

    }
}