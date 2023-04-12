package ru.mirea.smelkin.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

import ru.mirea.smelkin.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//TODO: после выполнения поток удаляется(список), но память не отчищается(смотреть profiler)
        binding.calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.printf("\n\n\n\n");
                Set<Thread> threads = Thread.getAllStackTraces().keySet();
                System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
                for (Thread t : threads) {
                    System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
                }
                System.out.printf("\n\n\n\n");


                Thread thread = new Thread(new Runnable() {
                    public void run() {

                        System.out.printf("\n\n\n\n");
                        Set<Thread> threads = Thread.getAllStackTraces().keySet();
                        System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
                        for (Thread t : threads) {
                            System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
                        }
                        System.out.printf("\n\n\n\n");

                        Log.d("thread_calculate", String.format("Запущен поток студентом группы %s номер по списку No %s ", "БСБО-02-20", "24"));
                        int days = Integer.parseInt(String.valueOf(binding.editTextTextPersonName2.getText()));
                        int lessons = Integer.parseInt(String.valueOf(binding.editTextTextPersonName.getText()));

                        //для изменения ui
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.textView.setText(String.format("среднее кол-во пар = %s", lessons/days));
                            }});


                        Log.d("thread_calculate", "Выполнен поток расчёта");
                    }
                });
                thread.setName("TEST");
                thread.start();
            }
        });




    }
}