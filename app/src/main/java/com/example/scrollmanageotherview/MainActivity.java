package com.example.scrollmanageotherview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.scrollmanageotherview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.otherView.setOnClickListener(v -> openSettingsOtherView());
    }


    private void openSettingsOtherView(){
        new DialogSettingsOtherView().show(getSupportFragmentManager(),"otherSetiings");
    }
}