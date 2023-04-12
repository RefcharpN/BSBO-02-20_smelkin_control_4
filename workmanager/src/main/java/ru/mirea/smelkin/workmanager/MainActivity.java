package ru.mirea.smelkin.workmanager;

import androidx.appcompat.app.AppCompatActivity;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;

import ru.mirea.smelkin.workmanager.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED).setRequiresCharging(true).build();
        WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class).setConstraints(constraints).build();

        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
    }
}