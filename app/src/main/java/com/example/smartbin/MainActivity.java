package com.example.smartbin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView Level, Percentage;
    int value, percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Level = findViewById(R.id.level);
        Percentage = findViewById(R.id.percent);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Value");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String lev = snapshot.getValue(String.class);
                value = Integer.parseInt(lev);
                percentage = 100 - ((value * 100) / 65);
                if(value <= 5 ){
                    Level.setText(value + " cm" + "\n" + "Please collect the wastage");
                    Percentage.setText(percentage + " %");
                }
                else if(value <= 65 && value >= 5 ) {
                    Level.setText(value + " cm" + "\n" + " Ready for use");
                    Percentage.setText(percentage + " %");
                }
                else {
                    Level.setText("Wait for Response");
                    Percentage.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Level.setText(error.getMessage());
            }
        });

    }
}