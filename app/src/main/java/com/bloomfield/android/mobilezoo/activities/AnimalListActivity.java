package com.bloomfield.android.mobilezoo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bloomfield.android.mobilezoo.R;
import com.bloomfield.android.mobilezoo.models.Animal;
import com.bloomfield.android.mobilezoo.models.Zoo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import adapters.AnimalAdapter;

public class AnimalListActivity extends AppCompatActivity {
    // pre-populated list of animals (search logs for "AnimalListActivity")
    private List<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvAnimals = findViewById(R.id.rvAnimals);
        animals = new ArrayList<>();
        AnimalAdapter animalAdapter = new AnimalAdapter(this, animals);
        rvAnimals.setAdapter(animalAdapter);
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));



        animals = Zoo.getZoo().getAnimals();
        Log.i("AnimalListActivity", animals.toString());
    }
}