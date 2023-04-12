package ru.mirea.smelkin.practice4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import ru.mirea.smelkin.practice4.databinding.FragmentPlayBinding;

public class PlayFragment extends Fragment {

    private FragmentPlayBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPlayBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root, "предыдущая композиция", Toast.LENGTH_SHORT).show();
            }
        });

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root, "воспроизвести", Toast.LENGTH_SHORT).show();
            }
        });

        binding.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root, "следующая композиция", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}