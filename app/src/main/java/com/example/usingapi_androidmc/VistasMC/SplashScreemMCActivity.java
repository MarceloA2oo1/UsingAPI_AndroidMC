package com.example.usingapi_androidmc.VistasMC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.usingapi_androidmc.databinding.ActivityMainMcactivityBinding;
import com.example.usingapi_androidmc.databinding.ActivitySplashScreemMcactivityBinding;

public class SplashScreemMCActivity extends AppCompatActivity {

    private ActivitySplashScreemMcactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreemMcactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        Handler handler = new Handler();
        handler.postDelayed(ejecutar, 6500);
    }

    public void runMain(){
        Intent intent = new Intent(SplashScreemMCActivity.this, MainMCActivity.class);
        startActivity(intent);
    }

    final Runnable ejecutar = new Runnable() {
        @Override
        public void run() {
            runMain();
        }
    };
}