package com.example.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private RecyclerView doctorRecyclerView;
    private DoctorAdapter doctorAdapter;
    private List<Doctor> doctorList;
    private ArrayList<RendezVou> appointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        doctorRecyclerView = findViewById(R.id.doctorRecyclerView);
        doctorRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        doctorList = new ArrayList<>();
        doctorList.add(new Doctor("Dr. Smith", "Cardiologist", R.drawable.a)); // Replace with your images
        doctorList.add(new Doctor("Dr. Johnson", "Dermatologist", R.drawable.a));
        doctorList.add(new Doctor("Dr. Lee", "Pediatrician", R.drawable.a));

        doctorAdapter = new DoctorAdapter(doctorList, this);
        doctorRecyclerView.setAdapter(doctorAdapter);

        // Button to view appointments
        Button viewAppointmentsButton = findViewById(R.id.viewAppointmentsButton);
        viewAppointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, AppointmentListActivity.class);
                startActivity(intent);
            }
        });
    }
}
