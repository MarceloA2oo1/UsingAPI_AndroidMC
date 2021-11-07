package com.example.usingapi_androidmc.VistasMC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.usingapi_androidmc.databinding.ActivityAboutMcactivityBinding;
import com.example.usingapi_androidmc.databinding.ActivityMainMcactivityBinding;

public class AboutMCActivity extends AppCompatActivity {

    private ActivityAboutMcactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutMcactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }
}